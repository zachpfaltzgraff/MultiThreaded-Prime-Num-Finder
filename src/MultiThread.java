import java.util.Arrays;

class MultiThread implements Runnable {
    private final int limit;
    private final int numThreads;
    private final int threadNumber;
    private int[] primes;
    private int count;

    MultiThread(int limit, int numThreads, int threadNum) {
        this.limit = limit;
        this.numThreads = numThreads;
        this.primes = new int[limit / 2];
        this.count = 0;
        this.threadNumber = threadNum;
    }

    private boolean isPrime(int number) {
        if (number <= 1)
            return false;
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0)
                return false;
        }
        return true;
    }

    @Override
    public void run() {
        int start = 2 + threadNumber;
        int step = numThreads;

        for (int i = start; i <= limit; i+= step) {
            if (isPrime(i)) {
                synchronized (this) {
                    primes[count++] = i;
                    System.out.print(i + " ");
                }
            }
        }
    }
}
