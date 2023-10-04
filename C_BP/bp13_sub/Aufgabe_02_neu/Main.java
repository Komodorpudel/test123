package C_BP.bp13_sub.Aufgabe_02_neu;

import java.util.ArrayList;

public class Main {

    public static void main (String [] args) {

        ArrayList<Thread> myThreads = new ArrayList<>();
        Counter counter = new Counter();

        for (int i = 0; i < 3 ; i++){

            Thread myThread = new Thread(new Runnable(){
                public void run() {
                    for (int j = 0; j < 50; j++){
                        counter.increment();
                        System.out.println(Thread.currentThread()+ ": " + counter.getCount());
                    }
                }
            });

            myThreads.add(myThread);
            myThread.start();
        }

        for (Thread t : myThreads) {
            try{
                t.join();
            }

            catch(InterruptedException e) {
                System.out.println("Fehler bei warten:" + e.getMessage());
            }
        }
    }
    
}
