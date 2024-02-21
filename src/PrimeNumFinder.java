/*
    Implementing runnable is better than what we did in class because it
    promotes modularity, which in turn is better object-oriented-programming.
    It is cleaner, works faster, and is generally better practice.
 */
public class PrimeNumFinder {
    public static final int limit = 1000000;
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
