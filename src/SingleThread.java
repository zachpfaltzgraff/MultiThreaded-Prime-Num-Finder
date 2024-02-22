import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class SingleThread implements Runnable {
    private final int limit;
    private ArrayList<Integer> primes;
    private PrimeChecker primeChecker;

    public SingleThread(int limit) {
        this.limit = limit;
        this.primes = new ArrayList<>();
        this.primeChecker = new PrimeChecker();
    }

    @Override
    public void run() {
        for (int i = 1; i <= limit; i++) {
            if (primeChecker.isPrime(i)) {
                synchronized (this) {
                    primes.add(i);
                    System.out.print(i + " ");
                }
            }
        }
    }
}
