import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Author Sam Cox
 */
public class SignalHandler {

    private final Controller controller;
    private final BlockingQueue<String> commands;

    /**
     * SignalHandler constructor.
     */
    public SignalHandler(){
        this.commands = new LinkedBlockingQueue<>();
        this.controller = new Controller(this);
    }

    /**
     * Sends command to controller.
     * @param command string
     */
    public void sendSignal(String command){
        this.controller.receiveSignal(command);
    }

    public synchronized void receiveSignal(String command){
        //For this initial simulation this won't do much
        //but during the unity simulation this will tell
        //drone control what to do.
        commands.add(command);
        this.engageCommand();

    }

    public void engageCommand(){
        try {
            //Essentially copy-paste handleCommand code in here from drone
            //control.
            commands.take(); //String of command
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
