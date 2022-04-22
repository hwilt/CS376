/**
 * @author Henry Wilt
 * Class: CS376, Hw4
 */

/**
 * PCB class:
 * Holds the PID, creation time, burst time, wait time, turnaround time
 */
public class PCB {
    private int PID;
    private int creationTime;
    private int burstTime;
    private int waitTime;
    private int turnaroundTime;
    private int RR8;
    private int RR16;
    private int FCFS;
    
    /**
     * Constructor:
     * @param PID
     * @param creationTime
     * @param burstTime
     */
    public PCB(int PID, int creationTime, int burstTime) {
        this.PID = PID;
        this.creationTime = creationTime;
        this.burstTime = burstTime;
        this.waitTime = 0;
        this.turnaroundTime = 0;
        this.RR8 = 0;
        this.RR16 = 0;
        this.FCFS = 0;
    }
    
    /**
     * getPID:
     * @return PID
     */
    public int getPID() {
        return PID;
    }
    
    /**
     * getCreationTime:
     * @return creationTime
     */
    public int getCreationTime() {
        return creationTime;
    }
    
    /**
     * getBurstTime:
     * @return burstTime
     */
    public int getBurstTime() {
        return burstTime;
    }
    
    /**
     * getWaitTime:
     * @return waitTime
     */
    public int getWaitTime() {
        return waitTime;
    }
    
    /**
     * getTurnaroundTime:
     * @return turnaroundTime
     */
    public int getTurnaroundTime() {
        return turnaroundTime;
    }
    
    /**
     * AddWaitTime:
     * 
     * Adds one to the wait time
     */
    public void addWaitTime() {
        this.waitTime++;
    }
    

    /**
     * calcTurnaroundTime:
     * 
     * @param endTime
     * 
     */
    public void calcTurnaroundTime(int endTime) {
        this.turnaroundTime = endTime - creationTime;
    }

    /**
     * addRR8:
     * 
     * adds 1 to the Round Robin 8
     */
    public void addRR8() {
        this.RR8++;
    }

    /**
     * addRR16:
     * 
     * adds 1 to the Round Robin 16
     */
    public void addRR16() {
        this.RR16++;
    }

    /**
     * addFCFS:
     * 
     * adds 1 to the FCFS
     */
    public void addFCFS() {
        this.FCFS++;
    }

}