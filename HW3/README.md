# Driver.java
This java file calls the functions in the CPU java class and gets the input from the file.

# CPU.java
This java file has all three scheduling algorithms, First Come First Serve, Round Robin, Shortest Job First.

## How to run the code:
Keep all the files in same folder; CPU.java, Driver.java, config.txt, makefile.<br>
In the terminal type `make` for the java files to compile.<br>
Then type `java Driver <config file> <[FCFS, RR, SJF]> <QuantumTime>`<br>
The config file is config.txt and you only need use the Quantum Time if you use RR (Round Robin) Scheduling
