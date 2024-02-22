/*
    Implementing runnable is better than what we did in class because it
    promotes modularity, which in turn is better object-oriented-programming.
    It is cleaner, works faster, and is generally better practice.

    CHANGE LOGS
        - Changed the prime numbers to be stored in an array list (wow something from oop *shocked*)
        - Changed name of zip to MultiThreadPrimeNum instead of MultiThreatPrimeNum
        - Added class PrimeChecker instead of having Prime Method in each Mutli and Single class
        - Removed sleep in single thread
        - Changed to start at 1 inside the classes instead of 2.
        - Looked over the multithreading in class and does indeed work
 */
public class PrimeNumFinder {
    public static final int limit = 10000;
    public static final int numThreads = 5;
    public static void main(String[] args) throws InterruptedException {
        // Single Thread
        long singleStart = System.currentTimeMillis();
        SingleThread singleThread = new SingleThread(limit);
        singleThread.run();
        long singleEnd = System.currentTimeMillis();
        long singleTime = (singleEnd - singleStart);

        System.out.println("\nSingle thread time: " + singleTime + " mills");

        // MultiThreaded
        Thread[] threads = new Thread[numThreads];
        long multiStart = System.currentTimeMillis();
        for (int i = 0; i < numThreads; i++) {
            MultiThread multiThread = new MultiThread(limit, numThreads, i);
            threads[i] = new Thread(multiThread);
            threads[i].start();
        }
        for (Thread thread : threads) {
            thread.join();
        }

        long multiEnd = System.currentTimeMillis();
        long multiTime = multiEnd - multiStart;

        System.out.println("\nMultiThread time: " + multiTime + " mills");
    }
}
