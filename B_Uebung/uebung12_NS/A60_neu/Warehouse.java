package B_Uebung.uebung12_NS.A60_neu;

import java.util.ArrayList;
import java.util.LinkedList;

public class Warehouse {

    // Attribute
    private final LinkedList<Integer> queue = new LinkedList<>();
    private final int MAX_SIZE = 5;

    // produce
    public synchronized void produce (int item) throws InterruptedException {

        while (queue.size() == MAX_SIZE) {
            wait();
        }

        queue.addLast(item);
        System.out.println("Produced item " + item);
        notifyAll(); // Wecke alle auf nach wait
    }

    // consume
    public synchronized int consume() throws InterruptedException {

        // Wenn die queue leer ist, kann ich nichts konsumieren
        while (queue.isEmpty() == true) {
            wait();
        }

        int item = queue.removeFirst();
        System.out.println("Consumed item: " + item);
        notifyAll();

        return item;

    }

    public static void main (String [] args) {

        Warehouse w = new Warehouse();

        ArrayList<Producer> myProducer = new ArrayList<>();
        ArrayList<Consumer> myConsumer = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            myProducer.add(new Producer(w));
            myConsumer.add(new Consumer(w));
        }

        myProducer.forEach(p -> p.start());
        myConsumer.forEach(Consumer::start);
    }
    
}

/**
 * In the provided code, you've used the intrinsic lock of the `Warehouse` object 
 * (`synchronized` methods) and the `wait()` and `notifyAll()` methods to coordinate 
 * between producer and consumer threads. Here's a breakdown of how it works:
 * 
 * 1. **Producer (`produce` method)**:
 *    - If the queue has reached its maximum size (`MAX_SIZE`), the producer thread will 
 *      enter the `wait()` state and release the lock.
 *    - Once a consumer consumes an item, it will call `notifyAll()`, which wakes up all 
 *      waiting threads, including the producer thread(s).
 *    - When woken up, the producer thread tries to re-acquire the lock. Once it succeeds, 
 *      it checks the condition (`queue.size() == MAX_SIZE`) again. If there's now space 
 *      in the queue, the producer will add the new item; otherwise, it will go back to waiting.
 *   
 * 2. **Consumer (`consume` method)**:
 *    - If the queue is empty, the consumer thread will enter the `wait()` state and release 
 *      the lock.
 *    - Once a producer produces an item, it will call `notifyAll()`, waking up all waiting 
 *      threads, including the consumer thread(s).
 *    - When woken up, the consumer thread tries to re-acquire the lock. Once it succeeds, 
 *      it checks the condition (`queue.isEmpty() == true`) again. If there's now an item 
 *      in the queue, the consumer will remove and process it; otherwise, it will go back to waiting.
 * 
 * So, in short:
 * - The producer knows there's space in the queue because, when woken up, it rechecks the condition.
 * - The consumer knows there's an item in the queue because, when woken up, it also rechecks its condition.
 * 
 * Using `notifyAll()` wakes up all waiting threads, but only one of them will get the lock at a time. 
 * The others will be blocked until they can acquire the lock. It's worth noting that using `notifyAll()` 
 * can be inefficient when you have many waiting threads because it wakes all of them up, even if only 
 * one of them can do useful work. An alternative approach is to use `notify()`, which only wakes up a 
 * single waiting thread. However, this approach requires more careful coordination to ensure that you 
 * don't run into deadlocks or miss notifications.
 */

