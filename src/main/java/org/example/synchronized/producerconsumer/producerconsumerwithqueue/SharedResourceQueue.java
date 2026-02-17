package org.example.producerconsumer.producerconsumerwithqueue;

import java.util.LinkedList;
import java.util.Queue;

public class SharedResourceQueue {

    private final int bufferSize;
    private final Queue<Integer> queue;

    public SharedResourceQueue(int bufferSize) {
        this.queue = new LinkedList<>();
        this.bufferSize=bufferSize;
    }

    public synchronized void consumeItem() {
        while (queue.isEmpty()) {
            System.out.println("Queue is empty");
            try {
                System.out.println(Thread.currentThread().getName() + " is waiting for item");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        int item = queue.poll();
        System.out.println("Item " + item + " has been consumed successfully by thread " + Thread.currentThread().getName());

        notifyAll();

    }

    public synchronized void addItem(int item) {

        while (queue.size() == bufferSize) {
            System.out.println("Queue is full");
            try {
                System.out.println(Thread.currentThread().getName() + " is waiting for space in queue");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Item " + item + " has been added successfully by thread " + Thread.currentThread().getName());
        queue.offer(item);
        notifyAll();

    }
}
