import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Author Sam Cox
 */
public class Controller {


    private final SignalHandler signalHandler;
    private final BlockingQueue<String> commands;
    private boolean droneLowPower;

    /**
     * Controller constructor.
     * @param signalHandler commands from drone and to drone
     */
    public Controller(SignalHandler signalHandler){
        this.signalHandler = signalHandler;
        this.commands = new LinkedBlockingQueue<>();
        this.droneLowPower = false;
    }

    /**
     * Pulls command from drone.
     * @param command string of command
     */
    public synchronized void receiveSignal(String command){
        commands.add(command);
        this.engageCommand();

    }

    /**
     * Takes command from drone and controller engages the command.
     */
    public void engageCommand(){

        try {
            if(commands.take().equals("low power")){
                this.droneLowPower = true;
            } else if(commands.take().equals("high power")){
                this.droneLowPower = true;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Returns power state of the drone so that the LED on the controller
     * can be lit to indicate low power.
     * @return true false
     */
    public boolean getDroneLowPower(){
        return this.droneLowPower;
    }

    /**
     * Sends commands from the controller to the drone.
     * In command line simulation this doesn't do much, but
     * in the unity sim this will interpret button presses.
     * @param command button pressed/joystick moved.
     */
    public synchronized void sendCommand(String command){
        this.signalHandler.receiveSignal(command);
    }

}
