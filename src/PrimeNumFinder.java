public class PrimeNumFinder {
    public static final int limit = 100000;
    public static final int numThreads = 5;
    public static void main(String[] args) {
        // Single Thread
        System.out.println("Single Thread Primes: ");
        long singleStart = System.currentTimeMillis();
        SingleThread singleThread = new SingleThread(limit);
        singleThread.run();
        long singleEnd = System.currentTimeMillis();
        long singleTime = (singleEnd - singleStart);

        System.out.println("\nSingle thread time: " + singleTime + " mills");

        // MultiThreaded
        System.out.println("Multi Thread Primes: ");
        long multiStart = System.currentTimeMillis();
        for (int i = 0; i < numThreads; i++) {
            MultiThread multiThread = new MultiThread(limit, numThreads, i);
            Thread thread = new Thread(multiThread);
            thread.start();
        }
        long multiEnd = System.currentTimeMillis();
        long multiTime = multiEnd - multiStart;

        System.out.println("\nMultiThread time: " + multiTime + " mills");
    }
}
