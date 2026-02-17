package org.example.synchronization.monitorlock;
/*this way we do not need additional CounterThread class directly we can call runnable and do our job*/
public class MonitorLockModernWithLamda {

    public static void main(String[] args) {
        Thread t1= new Thread(()->{
            for(int i=0;i<1000;i++){
                CounterResource.increment();
            }
        });
        Thread t2= new Thread(()->{
            for(int i=0;i<1000;i++){
                CounterResource.increment();
            }
        });
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Counter value: " + CounterResource.getCounter());
    }
}
