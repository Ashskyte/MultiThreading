package org.example.synchronization.producerconsumer;

public class ConsumerThread implements Runnable {
    private SharedResource sharedResource;

    public ConsumerThread(SharedResource sharedResource) {
        this.sharedResource = sharedResource;
    }

    @Override
    public void run() {
        sharedResource.consumeItem();
    }
}
