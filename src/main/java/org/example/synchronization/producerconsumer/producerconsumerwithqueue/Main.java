package org.example.synchronization.producerconsumer.producerconsumerwithqueue;

public class Main {
    public static void main(String[] args) {
        SharedResourceQueue sharedResourceQueue = new SharedResourceQueue(3);
        Thread producerThread = new Thread(new ProducerThread(sharedResourceQueue), "ProducerThread");
        Thread consumerThread = new Thread(new ConsumerThread(sharedResourceQueue), "ConsumerThread");
        producerThread.start();
        consumerThread.start();
    }
}
