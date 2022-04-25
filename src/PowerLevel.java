/**
 * Author Sam Cox
 */
public class PowerLevel {

    private boolean okPowerLevel;
    private boolean isPowerOn = false;

    /**
     * Initializes PowerLevel with okPowerLevel being set to true
     * which means the power level is ok.
     */
    public PowerLevel(){
        this.okPowerLevel = true;
    }

    /**
     * Checks the power level of the battery.
     * @return true ok, false low
     */
    public boolean powerOk(){
        return this.okPowerLevel;
    }

    /**
     * Sets the power level for simulation purposes.
     * @param level high, low
     */
    public void setPowerLevel(String level){
        this.okPowerLevel = level.equals("high");

        if(okPowerLevel){
            System.out.println("Battery status: Normal");
        }else{
            System.out.println("Battery status: Low");
        }
    }

    public boolean isPowerOn() {
        return isPowerOn;
    }

    public void setPowerOn(boolean powerOn) {
        isPowerOn = powerOn;
        if(powerOn){
            System.out.println("Drone power is On");
        } else {
            System.out.println("Drone power is Off");
        }
    }
}
