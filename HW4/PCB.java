/**
 * @author Henry Wilt
 * Class: CS376, Hw4
 */

/**
 * PCB class:
 * Holds the PID, creation time, burst time, wait time, turnaround time
 */
public class PCB {
    private final int PID;
    private final int creationTime;
    private int burstTime;
    private int waitTime;
    private int turnaroundTime;
    private byte algorithm = 0;
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
     * substractBurstTime:
     * 
     */
    public void substractBurstTime() {
        this.burstTime--;
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
    public void addWaitTime(int time) {
        this.waitTime += time;
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

    /**
     * getRR8:
     * 
     * @return RR8
     */
    public int getRR8() {
        return RR8;
    }

    /**
     * getRR16:
     * 
     * @return RR16
     */
    public int getRR16() {
        return RR16;
    }

    /**
     * getFCFS:
     * 
     * @return FCFS
     */
    public int getFCFS() {
        return FCFS;
    }

    /**
     * addAlgorithm:
     * 
     */
    public void addAlgorithm(){
        this.algorithm++;
    }


    /**
     * getAlgorithm:
     * 
     * @return algorithm
     */
    public byte getAlgorithm() {
        return algorithm;
    }

    /**
     * toString:
     * 
     */
    public String toString() {
        return "PID: " + PID + " Creation Time: " + creationTime + " Burst Time: " + burstTime + " Wait Time: " + waitTime + " Turnaround Time: " + turnaroundTime;
    }
}