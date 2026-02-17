package org.example.monitorlock;

//this resource will be shared between different threads to hold monitor lock
public class CounterResource {

    private static int counter = 0;

    public static synchronized int getCounter() {
        return counter;
    }

    public static synchronized void increment() {
        counter++;
    }
}
