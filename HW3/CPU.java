/**
 * @author Henry Wilt
 * Class: CS376, Hw3
 */

import java.util.*;

public class CPU{

    // Private Variables
    private int[] process;          // Array of process id's
    private int[] burst;            // Array of burst times
    private int[] arrival;          // Array of arrival times
    private int[] wait;             // Array of wait times
    private int[] turnaround;       // Array of turnaround times
    private int[] response;         // Array of response times
    private int quantumTime;        // Time quantum for Round Robin Scheduling
    private int currentTime = 0;    // Current time
    private int idleTime = 0;       // Cpu Idle time
    

    public CPU(ArrayList<int[]> config){
        process = new int[config.size()];
        arrival = new int[config.size()];
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
     * Returns the percent of cpu usage
     * 
     * @return double 
     */
    private double getCpuUsage(){
        double temp = currentTime - idleTime;
        return temp/currentTime * 100;
    }

    /**
     * Returns the average Wait time for each process
     * Add up them then divide by the number of processes
     * 
     * @return double
     */
    private double getAvgWait(){
        double sum = 0.0;
        for(int waitNum : wait){
            //System.out.println(waitNum);
            sum += waitNum;
        }
        return sum/wait.length;
    }

    /**
     * Returns the average response time for each process
     * Adds them up then divide by the number of processes
     * 
     * @return double
     */
    private double getAvgResponse(){
        double sum = 0.0;
        for(int responseNum : response){
            sum += responseNum;
        }
        return sum/response.length;
    }

    /**
     * Returns the average turnaround time for each process
     * Adds them up then divide by the number of processes
     * 
     * @return double
     */
    private double getAvgTurnaround(){
        double sum = 0.0;
        for(int turnaroundNum : turnaround){
            sum += turnaroundNum;
        }
        return sum/turnaround.length;
    }
    

    /**
     * Printing out the end results of the CPU scheduling
     * 
     * At end of Algorithm, print out the average cpu usage, average wait time, average turnaround time, and average response time.
     * Example output:
     * Average CPU usage: 100%
     * Average wait time: n
     * Average turnaround time: n
     * Average response time: n
     */
    private void printOutMetrics(){
        System.out.println("=========================");
        System.out.println("Average CPU usage: " + String.format("%.2f",getCpuUsage()) + "%");
        System.out.println("Average Wait Time: " + String.format("%.2f",getAvgWait()));
        System.out.println("Average Turnaround Time: " + String.format("%.2f",getAvgResponse()));
        System.out.println("Average Response Time: " + String.format("%.2f",getAvgTurnaround()));
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
     * 
     */
    public void firstComeFirstServe(){
        int currentProcess = 0;
        int lastProcess = process.length - 1;
        while (currentProcess <= lastProcess){
            if (arrival[currentProcess] <= currentTime){
                response[currentProcess] = currentTime - arrival[currentProcess];
                for (int burstTime = 0; burstTime < burst[currentProcess]; burstTime++){
                    System.out.println("<System time " + currentTime + "> process " + process[currentProcess] + " is running");
                    currentTime++;
                }
                turnaround[currentProcess] = currentTime - arrival[currentProcess];
                wait[currentProcess] = turnaround[currentProcess] - burst[currentProcess];
                System.out.println("<System time " + currentTime + "> process " + process[currentProcess] + " is finished.......");
                currentProcess++;
            }
            else{
                System.out.println("<System time " + currentTime + "> CPU is idle");
                idleTime++;
            }
        }
        System.out.println("<System time " + currentTime + "> All processes finish");
        printOutMetrics();
    }


    /**
     * Get max of an array
     * 
     * @param array int[]
     * @return int max
     */
    public int getMax(int[] arr){
        int max = arr[0];
        for (int i = 1; i < arr.length; i++){
            if (arr[i] > max){
                max = arr[i];
            }
        }
        return max;
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
     */
    public void shortestJobFirst(){
        int[] burstOG = Arrays.copyOf(burst, burst.length);
        boolean[] started = new boolean[burst.length];
        Arrays.fill(started, Boolean.FALSE);
        int currentProcess = 0;
        boolean isRunning = true;
        while (isRunning){

            // Finding the shortest burst time
            for (int i = 0; i < process.length; i++){
                if (arrival[i] <= currentTime && burst[i] != 0){
                    if (burst[i] < burst[currentProcess] || burst[currentProcess] == 0){
                        currentProcess = i;
                        if (!started[currentProcess]){
                            response[currentProcess] = currentTime - arrival[currentProcess];
                            started[currentProcess] = true;
                        }  
                    }
                }
            }

            burst[currentProcess]--;
            System.out.println("<System time " + currentTime + "> process " + process[currentProcess] + " is running");
            currentTime++;
            
            // Checking if the current process is done
            if (burst[currentProcess] == 0){
                turnaround[currentProcess] = currentTime - arrival[currentProcess];
                wait[currentProcess] = turnaround[currentProcess] - burstOG[currentProcess];
                System.out.println("<System time " + currentTime + "> process " + process[currentProcess] + " is finished.......");
            }
            

            // Checking if all the processes are done
            if (getMax(burst) == 0){
                isRunning = false;
            }
        }
        System.out.println("<System time " + currentTime + "> All processes finish");
        printOutMetrics();
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
     */
    public void roundRobin(){
        

    }

}