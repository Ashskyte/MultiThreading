package org.example.synchronization.producerconsumer.producerconsumerwithqueue;

public class ProducerThread implements Runnable{
    private SharedResourceQueue sharedResourceQueue;
    public ProducerThread(SharedResourceQueue sharedResourceQueue) {
        this.sharedResourceQueue = sharedResourceQueue;
    }
    @Override
    public void run() {
        for(int i=0;i<6;i++){
            sharedResourceQueue.addItem(i);
        }

    }
}
