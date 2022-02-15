JFLAGS = -g
JC = javac
.SUFFIXES: .java .class
.java.class:
	$(JC) $(JFLAGS) $*.java

CLASSES = \
	QuoteServer.java \
	QuoteClient.java 

default: compile 

compile: $(CLASSES:.java=.class)
	@echo "Compiling..."


start:
	@echo "Starting server..."
	java QuoteServer

clean: 
	@echo "Cleaning..."
	rm -f *.class
	