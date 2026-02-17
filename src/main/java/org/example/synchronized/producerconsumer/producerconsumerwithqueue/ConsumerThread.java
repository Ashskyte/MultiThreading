package org.example.producerconsumer.producerconsumerwithqueue;

public class ConsumerThread implements Runnable{
    private SharedResourceQueue sharedResourceQueue;
    public ConsumerThread(SharedResourceQueue sharedResourceQueue) {
        this.sharedResourceQueue = sharedResourceQueue;
    }
    @Override
    public void run() {
        for(int i=0;i<6;i++) {
            sharedResourceQueue.consumeItem();
        }
    }
}
