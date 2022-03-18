JFLAGS = -g
JC = javac
.SUFFIXES: .java .class
.java.class:
	$(JC) $(JFLAGS) $*.java

CLASSES = \
	CPU.java \
	Driver.java 

default: compile 

compile: $(CLASSES:.java=.class)
	@echo "Compiling..."

clean: 
	@echo "Cleaning..."
	rm -f *.class
	