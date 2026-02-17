package org.example.synchronization.producerconsumer;

public class ProducerThread implements Runnable{
    private SharedResource sharedResource;

    public ProducerThread(SharedResource sharedResource) {
        this.sharedResource = sharedResource;
    }

    @Override
    public void run() {
        sharedResource.addItem();
    }
}
