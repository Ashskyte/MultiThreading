package org.example.monitorlock;

//this is the class which will consume our resource and call their methods here
public class CounterThread extends Thread {
    /*this is injection of our resource to this thread class*/
    private final CounterResource counterResource;

    public CounterThread(CounterResource counterResource) {
        this.counterResource = counterResource;
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            counterResource.increment();
        }
    }
}
