package org.example.monitorlock;

public class MonitorLockMain {

    public static void main(String[] args) {
        /*this will be our shared resource*/
        /*this resource will be shared between different threads to hold monitor lock*/
        CounterResource counterResource = new CounterResource();

        CounterThread thread1 = new CounterThread(counterResource);
        CounterThread thread2 = new CounterThread(counterResource);
        thread1.start();
        thread2.start();

       /*we need to use join because we want our main thread to wait until t1 and t2 finishes otherwise main
       thread will finish first and print some wrong values , we want to see 2000 , it will only happen when both finishes
       and then main thread have to finish.
        */
        try {
            thread2.join();
            thread1.join();
        } catch (InterruptedException ie) {
            System.out.println(ie.getMessage());
        }

        System.out.println("Counter value: " + counterResource.getCounter());

    }
}
