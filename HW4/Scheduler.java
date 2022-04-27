/**
 * @author Henry Wilt
 * Class: CS376, Hw4
 */

public class Scheduler{
    private ArrayList<PCB> config;
    private ArrayList<PCB> readyQueue;
    private ArrayList<PCB> finishedQueue;
    private int time;


    /**
     * Constructor:
     * @param config
     */
    public Scheduler(ArrayList<PCB> config) {
        this.config = config;
        this.readyQueue = new ArrayList<PCB>();
        this.finishedQueue = new ArrayList<PCB>();
        this.time = 0;
    }

    /**
     * run:
     * Runs the scheduler
     */
    public void run() {
        
    }


}