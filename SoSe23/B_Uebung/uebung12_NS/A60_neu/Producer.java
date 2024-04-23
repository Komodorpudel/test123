package SoSe23.B_Uebung.uebung12_NS.A60_neu;

import java.util.concurrent.ThreadLocalRandom;

public class Producer extends Thread {

    private Warehouse warehouse;

    public Producer (Warehouse warehouse) {
        this.warehouse = warehouse;
    }
    
    @Override
    public void run() {

        try {
            while (true) {
                warehouse.produce(ThreadLocalRandom.current().nextInt(100));
                Thread.sleep(ThreadLocalRandom.current().nextInt(1,6)* 1000);
                
            }
        }

        catch(InterruptedException e ) {

        }
    }
}

/**
 * Both `implements Runnable` and `extends Thread` are mechanisms in Java to define a new thread of execution, 
 * but they have some fundamental differences:
 * 
 * 1. **Nature**:
 *    - **`implements Runnable`**: When a class implements the `Runnable` interface, it has to provide the 
 *      implementation of the `run()` method. The class doesn't become a thread in itself, but it provides 
 *      the means to execute code in a thread. To actually start this as a thread, you'd need to instantiate 
 *      a `Thread` object and pass the `Runnable` object to its constructor.
 *    - **`extends Thread`**: When a class extends the `Thread` class, it inherits the `Thread` class's 
 *      properties and behaviors. You'll override the `run()` method to provide the code you want to execute 
 *      in this thread. To start this thread, you'd create an instance of this class and call the `start()` method.
 * 
 * 2. **Use-case Suitability**:
 *    - **`implements Runnable`**: More suitable when you want to provide a "job" that a thread should execute, 
 *      but you don't want to specifically define how threading should behave. Since Java doesn't support multiple 
 *      inheritance, implementing `Runnable` allows your class to still extend another class.
 *    - **`extends Thread`**: More suitable when you want to create a custom behavior of the thread itself. 
 *      However, it's rarely recommended to do so.
 * 
 * 3. **Flexibility**:
 *    - **`implements Runnable`**: More flexible. A single `Runnable` instance can be passed to multiple thread 
 *      objects if needed. This separation of task and thread execution is often preferred.
 *    - **`extends Thread`**: Less flexible. Once you extend a `Thread`, you can't extend any other class, 
 *      which limits the inheritance capabilities of your new class.
 * 
 * 4. **Composition Over Inheritance**:
 *    - **`implements Runnable`**: Encourages composition (you provide a task to a thread to execute it) which 
 *      is a recommended design pattern.
 *    - **`extends Thread`**: Makes use of inheritance, which can be considered a less flexible design approach 
 *      especially when dealing with threads.
 * 
 * 5. **Memory Overhead**:
 *    - **`implements Runnable`**: Usually has less memory overhead since only the task (or the job to be run) 
 *      is defined in the class, not the thread mechanisms.
 *    - **`extends Thread`**: Can introduce more memory overhead since you're creating a new instance of the 
 *      `Thread` class every time.
 * 
 * In most scenarios, the recommended approach is to `implements Runnable` because of the flexibility and 
 * design advantages it offers. However, the choice largely depends on the specific requirements of your application.
 */
// public class ThreadingExplanation {
    // This is just a dummy class to encapsulate the explanation in a comment.
//}

