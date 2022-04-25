/**
 * Author Sam Cox
 */
public class MonitorPower implements Runnable{


    private final Notification notification;
    private final PowerLevel powerLevel;
    private final SignalHandler signalHandler;

    /**
     * Initializes Monitor power with a new Notification and PowerLevel.
     * Starts separate thread to check power every two seconds.
     */
    public MonitorPower(SignalHandler signalHandler){
        this.notification = new Notification();
        this.powerLevel = new PowerLevel();
        this.signalHandler = signalHandler;
        Thread thread = new Thread(this);
        thread.start();
    }

    /**
     * Changes the power level for the simulation.
     * @param level low or high
     */
    public void changeSimPowerLevel(String level){
        String[] command = level.split(" ");
        powerLevel.setPowerLevel(command[1]);
    }


    /**
     * Runs a separate thread. Checks the power level every 2 seconds and
     * updates the notification accordingly.
     */
    @Override
    public void run() {
        while(true){
            if(!powerLevel.powerOk()){
                this.notification.setLowStatus(false);
                this.signalHandler.sendSignal("low power");
            }else if(powerLevel.powerOk()){
                this.notification.setLowStatus(true);
                this.signalHandler.sendSignal("high power");
            }
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public PowerLevel getPowerLevel() {
        return powerLevel;
    }

}
