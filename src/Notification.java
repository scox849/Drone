/**
 * Author Sam Cox.
 */
public class Notification {

    private boolean status;

    /**
     * Initializes a new Notification with battery status set to not low.
     */
    public Notification(){
        this.status = true;
    }
    /**
     * Sets the status of the battery. If isBatLow is false
     * then the battery is low and vice versa.
     * @param batLow low status of battery
     */
    public void setLowStatus(boolean batLow){
        this.status = batLow;
    }

    /**
     * Returns the low status of the battery.
     * @return true false
     */
    public boolean getLowStatus(){
        return this.status;
    }

}
