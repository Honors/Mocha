all: compile cleanup

compile: src/*.java
	cd src; \
	javac Test.java
	
cleanup: src/*.java
	mv src/*.class build/
