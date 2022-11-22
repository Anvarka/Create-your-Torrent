#!/bin/sh
#cd `dirname "$0"`
#javac client/src/ru/itmo/java/client/Client.java
#java --class-path java-2-2022.client.main client/src/ru/itmo/java/client/Client.class

#mainClassName=classToExecute
#./gradlew run -PclassToExecute=com.myClass
#./gradlew build -q
./gradlew  --console=plain client:run