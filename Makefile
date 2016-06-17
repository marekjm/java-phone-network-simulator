all:
	javac Cellular/Cell.java
	javac Cellular/Phone.java

clean:
	find . -name '*.class' | xargs rm -v
