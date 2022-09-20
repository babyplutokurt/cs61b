package randomizedtest;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;
import timingtest.AList;

import javax.print.attribute.IntegerSyntax;

import static org.junit.Assert.*;

/**
 * Created by hug.
 */
public class TestBuggyAList {
  // YOUR TESTS HERE
    @Test
    public void testThreeAddThreeRemove() {
        AListNoResizing<Integer> correct = new AListNoResizing<>();
        BuggyAList<Integer> broken = new BuggyAList<>();

        correct.addLast(5);
        correct.addLast(10);
        correct.addLast(15);

        broken.addLast(5);
        broken.addLast(10);
        broken.addLast(15);

        assertEquals(correct.size(), broken.size());
        assertEquals(correct.removeLast(), broken.removeLast());
        assertEquals(correct.removeLast(), broken.removeLast());
        assertEquals(correct.removeLast(), broken.removeLast());
    }

    @Test
    public void randomizedTest(){
        AListNoResizing<Integer> L = new AListNoResizing<>();
        BuggyAList<Integer> B = new BuggyAList<>();
        int N = 5000;
        for (int i = 0; i < N; i += 1) {
            int operationNumber = StdRandom.uniform(0, 4);
            if (operationNumber == 0) {
                // addLast
                int randVal = StdRandom.uniform(0, 100);
                L.addLast(randVal);
                B.addLast(randVal);
                //System.out.println("addLast(" + randVal + ")" + "   L last is " + L.getLast() + "   B last is " + B.getLast());
            } else if (operationNumber == 1) {
                // size
                int size = L.size();
                int size_B = B.size();
                //System.out.println("L size : " + size + "   B size : " + size_B);
            }
            else if (operationNumber == 2) {
                // getLast
                if (L.size() > 0 && B.size() > 0) {
                    int LastValue = L.getLast();
                    int LastValue_B = B.getLast();
                    //System.out.println(("L last = " + LastValue + "   B last = " + LastValue_B));
                }
            }
            else if (operationNumber == 3) {
                // removeLast
                if (L.size() > 0 && B.size() > 0) {
                    int remove = L.removeLast();
                    int remove_B = B.removeLast();
                    //System.out.println(("L removed = " + remove + "   B removed = " + remove_B));
                    //add test
                }
            }
        }
    }

}
