#!/bin/sh
#export DYLD_LIBRARY_PATH=$DYLD_LIBRARY_PATH:.
javac HelloWorld.java
javah HelloWorld
gcc -I$JAVA_HOME/include/ -I$JAVA_HOME/include/darwin/ -dynamiclib -fPIC libHelloWorld.c -o libHelloWorld.jnilib

java HelloWorld
