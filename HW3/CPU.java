/**
 * @author Henry Wilt
 * Class: CS376, Hw3
 */

import java.util.*;

public class CPU{

    // Private Variables
    private int[] process;      // Array of process id's
    private int[] burst;        // Array of burst times
    private int[] arrival;      // Array of arrival times
    private int[] wait;         // Array of wait times
    private int[] turnaround;   // Array of turnaround times
    private int[] response;     // Array of response times
    private int quantumTime;    // Time quantum for Round Robin Scheduling
    

    public CPU(ArrayList<int[]> config){
        process = new int[config.size()];
        burst = new int[config.size()];
        wait = new int[config.size()];
        turnaround = new int[config.size()];
        response = new int[config.size()];
        for(int i = 0; i < config.size(); i++){
            process[i] = config.get(i)[0];
            arrival[i] = config.get(i)[1];
            burst[i] = config.get(i)[2];
            wait[i] = 0;
            turnaround[i] = 0;
            response[i] = 0;
        }
    }

    /**
     * Sets the time quantum for Round Robin Scheduling
     * 
     * @param quantumTime int of the time quantum
     */
    public void setQuantumTime(int quantum){
        quantumTime = quantum;
    }

    /**
     * First Come First Serve Scheduling
     * 
     * Algorithm:
     * Non-preemptive
     * Lowest PID to highest PID
     * 
     * During the task print progress of every unit of time.
     * Example output:
     * <System time n> process n is running 
     * 
     * When the process is done, print the following:
     * <System time n> process n is finished........
     * 
     * At end of Algorithm, print out the average cpu usage, average wait time, average turnaround time, and average response time.
     * Example output:
     * Average CPU usage: 100%
     * Average wait time: n
     * Average turnaround time: n
     * Average response time: n
     * 
     */
    public void firstComeFirstServe(){

    }

    /**
     * Shortest Job First Scheduling
     * 
     * Algorithm:
     * Preemptive scheduling
     * Shortest burst time is selected first and goes to highest Burst Time.
     * 
     * During the task print progress of every unit of time.
     * Example output:
     * <System time n> process n is running 
     * 
     * When the process is done, print the following:
     * <System time n> process n is finished........
     * 
     * At end of Algorithm, print out the average cpu usage, average wait time, average turnaround time, and average response time.
     * Example output:
     * Average CPU usage: 100%
     * Average wait time: n
     * Average turnaround time: n
     * Average response time: n
     * 
     */
    public void shortestJobFirst(){

    }

    /**
     * Round Robin Scheduling
     * 
     * Algorithm:
     * Preemptive scheduling
     * Given a time quantum, lower PID will be given priority then only be in the CPU for that time quantum.
     * 
     * During the task print progress of every unit of time.
     * Example output:
     * <System time n> process n is running 
     * 
     * When the process is done, print the following:
     * <System time n> process n is finished........
     * 
     * At end of Algorithm, print out the average cpu usage, average wait time, average turnaround time, and average response time.
     * Example output:
     * Average CPU usage: 100%
     * Average wait time: n
     * Average turnaround time: n
     * Average response time: n
     * 
     */
    public void roundRobin(){

    }

}