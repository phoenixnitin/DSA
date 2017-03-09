JFLAGS = -g
JC = javac
.SUFFIXES: .java .class
.java.class:
		$(JC) $(JFLAGS) $*.java

CLASSES = \
		Stack.java \
		ArrayStack.java \
		myQueue1.java \
		myQueue2.java

default: classes

classes: $(CLASSES:.java=.class)

clean:
		$(RM) *.class