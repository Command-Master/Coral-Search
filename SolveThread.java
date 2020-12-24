import com.seedfinding.latticg.reversal.DynamicProgram;
import com.seedfinding.latticg.reversal.calltype.java.JavaCalls;
import com.seedfinding.latticg.util.LCG;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

public class SolveThread implements Runnable {
    int c0, c1, c2, c3, c4, c5, c6;
    int[] offset;
    public SolveThread(int c0, int c1, int c2, int c3, int c4, int c5, int c6, int[] offset) {
        this.c0 = c0;
        this.c1 = c1;
        this.c2 = c2;
        this.c3 = c3;
        this.c4 = c4;
        this.c5 = c5;
        this.c6 = c6;
        this.offset = offset;
    }


    public void run() {
        DynamicProgram dynamicProgram = DynamicProgram.create(LCG.JAVA);
        dynamicProgram.add(JavaCalls.nextInt(5).equalTo(0));
        dynamicProgram.add(JavaCalls.nextInt(3).equalTo(0));
        dynamicProgram.add(JavaCalls.nextFloat().lessThan(0.25f).not());
        dynamicProgram.add(JavaCalls.nextFloat().lessThan(0.05f).not());

        dynamicProgram.add(JavaCalls.nextFloat().lessThan(0.2f).not());
        dynamicProgram.add(JavaCalls.nextFloat().lessThan(0.2f).not());
        dynamicProgram.add(JavaCalls.nextFloat().lessThan(0.2f).not());
        if (c0 == 0) {
            dynamicProgram.add(JavaCalls.nextFloat().lessThan(0.2f).not());
        } else {
            dynamicProgram.add(JavaCalls.nextFloat().lessThan(0.2f));
            dynamicProgram.add(JavaCalls.nextInt(5).betweenII(0, 4));
        }
        dynamicProgram.add(JavaCalls.nextInt(3).equalTo(0));
        for (int var3 = 5; var3 > 1; --var3) {
//            System.out.println(var3);
            dynamicProgram.add(JavaCalls.nextInt(var3).betweenII(0, var3 - 1));
        }
        for (int i : offset) { // 0 = south, 1 = west
            switch (i) {
                case 0:
                    dynamicProgram.add(JavaCalls.nextInt(5).equalTo(1));
                    // block 1
                    dynamicProgram.add(JavaCalls.nextFloat().lessThan(0.25f).not());
                    dynamicProgram.add(JavaCalls.nextFloat().lessThan(0.05f).not());

                    dynamicProgram.add(JavaCalls.nextFloat().lessThan(0.2f).not());
                    dynamicProgram.add(JavaCalls.nextFloat().lessThan(0.2f).not());
                    dynamicProgram.add(JavaCalls.nextFloat().lessThan(0.2f).not());
                    if (c1 == 0) {
                        dynamicProgram.add(JavaCalls.nextFloat().lessThan(0.2f).not());
                    } else {
                        dynamicProgram.add(JavaCalls.nextFloat().lessThan(0.2f));
                        dynamicProgram.add(JavaCalls.nextInt(5).betweenII(0, 4));
                    }

                    // block 2
                    dynamicProgram.skip(2);

                    dynamicProgram.add(JavaCalls.nextFloat().lessThan(0.2f).not());
                    dynamicProgram.add(JavaCalls.nextFloat().lessThan(0.2f));
                    dynamicProgram.add(JavaCalls.nextInt(5).equalTo(3));
                    dynamicProgram.add(JavaCalls.nextFloat().lessThan(0.2f).not());
                    if (c2 == 0) {
                        dynamicProgram.add(JavaCalls.nextFloat().lessThan(0.2f).not());
                    } else {
                        dynamicProgram.add(JavaCalls.nextFloat().lessThan(0.2f));
                        dynamicProgram.add(JavaCalls.nextInt(5).betweenII(0, 4));
                    }

                    // block 3
                    dynamicProgram.add(JavaCalls.nextFloat().lessThan(0.25f));
                    dynamicProgram.add(JavaCalls.nextInt(5).equalTo(4));

                    dynamicProgram.add(JavaCalls.nextFloat().lessThan(0.2f).not());
                    dynamicProgram.add(JavaCalls.nextFloat().lessThan(0.2f).not());
                    dynamicProgram.add(JavaCalls.nextFloat().lessThan(0.2f));
                    dynamicProgram.add(JavaCalls.nextInt(5).equalTo(4));
                    if (c3 == 0) {
                        dynamicProgram.add(JavaCalls.nextFloat().lessThan(0.2f).not());
                    } else {
                        dynamicProgram.add(JavaCalls.nextFloat().lessThan(0.2f));
                        dynamicProgram.add(JavaCalls.nextInt(5).betweenII(0, 4));
                    }
                    break;
                case 1:
                    dynamicProgram.add(JavaCalls.nextInt(5).equalTo(1));

                    // block 1:
                    dynamicProgram.add(JavaCalls.nextFloat().lessThan(0.25f).not());
                    dynamicProgram.add(JavaCalls.nextFloat().lessThan(0.05f).not());

                    dynamicProgram.add(JavaCalls.nextFloat().lessThan(0.2f).not());
                    dynamicProgram.add(JavaCalls.nextFloat().lessThan(0.2f));
                    dynamicProgram.add(JavaCalls.nextInt(5).equalTo(1));
                    dynamicProgram.add(JavaCalls.nextFloat().lessThan(0.2f).not());
                    if (c4 == 0) {
                        dynamicProgram.add(JavaCalls.nextFloat().lessThan(0.2f).not());
                    } else {
                        dynamicProgram.add(JavaCalls.nextFloat().lessThan(0.2f));
                        dynamicProgram.add(JavaCalls.nextInt(5).betweenII(0, 4));
                    }

                    // block 2:
                    dynamicProgram.skip(2);

                    dynamicProgram.add(JavaCalls.nextFloat().lessThan(0.2f).not());
                    dynamicProgram.add(JavaCalls.nextFloat().lessThan(0.2f).not());
                    dynamicProgram.add(JavaCalls.nextFloat().lessThan(0.2f).not());
                    if (c5 == 0) {
                        dynamicProgram.add(JavaCalls.nextFloat().lessThan(0.2f).not());
                    } else {
                        dynamicProgram.add(JavaCalls.nextFloat().lessThan(0.2f));
                        dynamicProgram.add(JavaCalls.nextInt(5).betweenII(0, 4));
                    }

                    // block 3:
                    dynamicProgram.add(JavaCalls.nextFloat().lessThan(0.25f));
                    dynamicProgram.add(JavaCalls.nextInt(5).equalTo(1));

                    dynamicProgram.add(JavaCalls.nextFloat().lessThan(0.2f));
                    dynamicProgram.add(JavaCalls.nextInt(5).equalTo(0));
                    dynamicProgram.add(JavaCalls.nextFloat().lessThan(0.2f).not());
                    dynamicProgram.add(JavaCalls.nextFloat().lessThan(0.2f).not());
                    if (c6 == 0) {
                        dynamicProgram.add(JavaCalls.nextFloat().lessThan(0.2f).not());
                    } else {
                        dynamicProgram.add(JavaCalls.nextFloat().lessThan(0.2f));
                        dynamicProgram.add(JavaCalls.nextInt(5).betweenII(0, 4));
                    }
                    break;
                default:
                    throw new RuntimeException("ohoh!");
            }
        }
        AtomicInteger count = new AtomicInteger(0);
        dynamicProgram.reverse().forEach(s -> {
            count.incrementAndGet();
            synchronized (CoralReverse.fw) {
                try {
                    CoralReverse.fw.write(s + "\n");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        System.out.println(count.get());
    }
}
