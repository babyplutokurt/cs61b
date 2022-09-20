package timingtest;

import edu.princeton.cs.algs4.Stopwatch;

/**
 * Created by hug.
 */
public class TimeSLList {
    private static void printTimingTable(AList<Integer> Ns, AList<Double> times, AList<Integer> opCounts) {
        System.out.printf("%12s %12s %12s %12s\n", "N", "time (s)", "# ops", "microsec/op");
        System.out.printf("------------------------------------------------------------\n");
        for (int i = 0; i < Ns.size(); i += 1) {
            int N = Ns.get(i);
            double time = times.get(i);
            int opCount = opCounts.get(i);
            double timePerOp = time / opCount * 1e6;
            System.out.printf("%12d %12.2f %12d %12.2f\n", N, time, opCount, timePerOp);
        }
    }

    public static void main(String[] args) {
        timeGetLast();
    }

    public static void timeGetLast() {
        int Size[] = new int[]{1000, 2000, 4000, 8000, 16000, 32000, 64000, 128000};
        AList Ns = new AList();
        AList times = new AList();
        AList opCounts = new AList();
        for (int i = 0; i < Size.length; i++) {
            SLList s = new SLList();
            for (int index = 0; index < Size[i]; index++) {
                s.addLast(index);
            }
            Stopwatch sw = new Stopwatch();
            for (int op = 0; op < 10000; op++) {
                s.addLast((op));
            }
            double timeInSeconds = sw.elapsedTime();
            Ns.addLast(Size[i]);
            times.addLast(timeInSeconds);
            opCounts.addLast(10000);
        }
        printTimingTable(Ns, times, opCounts);

    }

}
