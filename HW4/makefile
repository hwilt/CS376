JFLAGS = -g
JC = javac
.SUFFIXES: .java .class
.java.class:
	$(JC) $(JFLAGS) $*.java

CLASSES = \
	PCB.java \
	Main.java \
	Algorothims.java \
	Scheduler.java

default: compile 

compile: $(CLASSES:.java=.class)

clean: 
	@echo "Cleaning..."
	rm -f *.class
	