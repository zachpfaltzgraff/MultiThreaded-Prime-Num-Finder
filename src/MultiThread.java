import java.util.ArrayList;

class MultiThread implements Runnable {
    private final int limit;
    private final int numThreads;
    private final int threadNumber;
    private ArrayList<Integer> primes;
    private PrimeChecker primeChecker;

    MultiThread(int limit, int numThreads, int threadNum) {
        this.limit = limit;
        this.numThreads = numThreads;
        this.primes = new ArrayList<>();
        this.threadNumber = threadNum;
        this.primeChecker = new PrimeChecker();
    }

    @Override
    public void run() {
        int start = 1 + threadNumber;
        int step = numThreads;

        for (int i = start; i <= limit; i+= step) {
            if (primeChecker.isPrime(i)) {
                synchronized (this) {
                    primes.add(i);
                    System.out.print(i + " ");
                }
            }
        }
    }
}
