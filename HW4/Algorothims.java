/**
 * @author Henry Wilt
 * Class: CS376, Hw4
 */
import java.util.ArrayList;

public class Algorothims{
    
    /**
     * Constructor:
     * 
     */
    public Algorothims(){}

    /**
     * printCPU:
     * Prints the output of th PID, TIME, Algorithm, and the burst time
     * Format is:
     * <time>:P<pid>:<algorithm>:<burst time>
     */
    private static void printCPU(PCB pcb, int time, String algorithm){
        System.out.println(time + ":P" + pcb.getPID() + ":" + algorithm + ":" + pcb.getBurstTime());
    }



    public int RR(PCB pcb, int time, int quantum, ArrayList<PCB> readyQueue){
        String algorithm = "RR" + quantum;
        while(quantum > 0 && pcb.getBurstTime() > 0){
            quantum--;
            pcb.substractBurstTime();
            if(pcb.getBurstTime() == 0){
                pcb.calcTurnaroundTime(time);
                quantum = 0;
            }
            if (algorithm.equals("RR8")){
                pcb.addRR8();
            }
            else if (algorithm.equals("RR16")){
                pcb.addRR16();
            }
            printCPU(pcb, time, algorithm);
            for (PCB pcb2 : readyQueue){
                pcb2.addWaitTime(1);
            }
            time++;
        }
        return time;
    }
    

    public int FCFS(PCB pcb, int time, ArrayList<PCB> readyQueue){
        while(pcb.getBurstTime() > 0){
            pcb.addFCFS();
            pcb.substractBurstTime();
            printCPU(pcb, time, "FCFS");
            for (PCB pcb2 : readyQueue){
                pcb2.addWaitTime(1);
            }
            time++;
        }
        pcb.calcTurnaroundTime(time);
        return time;
    }
}