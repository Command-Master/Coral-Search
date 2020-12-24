import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class CoralReverse {
    public static FileWriter fw;

    static {
        try {
            fw = new FileWriter("seeds.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        int[][] perms = new int[][]{{0, 1}, {1, 0}};
        ExecutorService service = Executors.newFixedThreadPool(10);
        for (int c0 = 0; c0 <= 1; c0++) {
            for (int c1 = 0; c1 <= 1; c1++) {
                for (int c2 = 0; c2 <= 1; c2++) {
                    for (int c3 = 0; c3 <= 1; c3++) {
                        for (int c4 = 0; c4 <= 1; c4++) {
                            for (int c5 = 0; c5 <= 1; c5++) {
                                for (int c6 = 0; c6 <= 1; c6++) {
                                    for (int[] offset : perms) {
                                        Runnable t = new SolveThread(c0, c1, c2, c3, c4, c5, c6, offset);
                                        service.submit(t);
                                    }
                                }
                            }
                        }
                    }
                }
            }
            service.shutdown();
            service.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        }

    }


}