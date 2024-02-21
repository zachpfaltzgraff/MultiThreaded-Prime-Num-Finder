import java.util.Arrays;

public class SingleThread implements Runnable {
    private final int limit;
    private int[] primes;
    private int count;

    public SingleThread(int limit) {
        this.limit = limit;
        this.primes = new int[limit / 2];
        this.count = 0;
    }


    private boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
    @Override
    public void run() {
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        for (int i = 2; i <= limit; i++) {
            if (isPrime(i)) {
                synchronized (this) {
                    primes[count++] = i;
                    System.out.print(i + " ");
                }
            }
        }
    }
}
