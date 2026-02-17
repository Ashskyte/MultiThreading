package org.example.producerconsumer;

public class ProducerConsumerMain {
    public static void main(String[] args) {
        SharedResource sharedResource = new SharedResource();
        Thread producerThread = new Thread(new ProducerThread(sharedResource));
        Thread consumerThread = new Thread(new ConsumerThread(sharedResource));
        producerThread.start();
        consumerThread.start();
    }
}
