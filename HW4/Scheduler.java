/**
 * @author Henry Wilt
 * Class: CS376, Hw4
 */

import java.util.*;

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
     * printTable:
     * Prints the table of the finished queue
     * 
     */
    public void printTable(){
        Collections.sort(finishedQueue, new Comparator<PCB>() {
            @Override
            public int compare(PCB pcb1, PCB pcb2) {
                return pcb1.getPID() - pcb2.getPID();
            }
        });
        System.out.println("PID\tRR8\tRR16\tFCFS\tWait Time\tTurnaround Time");
        for(PCB pcb : finishedQueue){
            System.out.println("P" + pcb.getPID() + "\t" + pcb.getRR8() + "\t" + pcb.getRR16() + "\t" + pcb.getFCFS() + "\t" + pcb.getWaitTime() + "\t\t" + pcb.getTurnaroundTime() + "\t\t" );
        }
    }

    /**
     * run:
     * Runs the scheduler
     */
    public void run() {
        Algorothims algorithm = new Algorothims();
        while (config.size() > 0 || readyQueue.size() > 0) {
            // Get the next process
            PCB[] tobeRemoved = new PCB[config.size()];
            for (int i = 0; i < config.size(); i++) {
                //System.out.println(pcb.toString());
                PCB pcb = config.get(i);
                if (pcb.getCreationTime() >= time) {
                    readyQueue.add(pcb);
                    tobeRemoved[i] = pcb;
                }
            }
            for (PCB pcb : tobeRemoved) {
                config.remove(pcb);
            }
            
            if (readyQueue.size() > 0) {
                //System.out.println("here");
                PCB current = readyQueue.get(0);
                readyQueue.remove(current);
                // Run the process
                if (current.getAlgorithm() == 0) {
                    //System.out.println("RR8");
                    time = algorithm.RR(current, time, 8, readyQueue);
                    current.addAlgorithm();
                } else if (current.getAlgorithm() == 1) {
                    //System.out.println("RR16");
                    time = algorithm.RR(current, time, 16, readyQueue);
                    current.addAlgorithm();
                } else if (current.getAlgorithm() == 2) {
                    //System.out.println("FCFS");
                    time = algorithm.FCFS(current, time, readyQueue);
                }
                //System.out.println(time);
                readyQueue.add(current);

                // Remove the process from the ready queue
                // Add the process to the finished queue
                if (current.getBurstTime() == 0) {
                    finishedQueue.add(current);
                    readyQueue.remove(current);
                }
            }
        }
        printTable();
        
    }


}