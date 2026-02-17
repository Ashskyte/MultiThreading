package org.example.synchronization.producerconsumer;

public class SharedResource {
    boolean isItemAvailable = false;

    public synchronized void addItem() {
        isItemAvailable = true;try{
            Thread.sleep(1000);
        }catch(InterruptedException ie){
            System.out.println(ie.getMessage());
        }
        System.out.println("Item has been added successfully by thread " + Thread.currentThread().getName());
        notifyAll();
    }

    public synchronized void consumeItem() {

        while (!isItemAvailable) {

            try {
                System.out.println(Thread.currentThread().getName()+" is waiting for item");
                wait();
            } catch (InterruptedException ie) {
                System.out.println(ie.getMessage());
            }
        }
        System.out.println("Item has been consumed successfully by thread " + Thread.currentThread().getName());
        isItemAvailable = false;
    }
}
