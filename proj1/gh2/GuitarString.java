package gh2;


import deque.ArrayDeque;
import deque.Deque;


//Note: This file will not compile until you complete the Deque implementations
public class GuitarString {
    private static final int SR = 44100;      // Sampling Rate
    private static final double DECAY = .996; // energy decay factor
    private Deque<Double> buffer = new ArrayDeque<>();

    /* Create a guitar string of the given frequency.  */
    public GuitarString(double frequency) {
        int capacity = (int) Math.round(SR / frequency);
        for (int i = 0; i < capacity; i++) {
            buffer.addLast(0.0);
        }
    }


    /* Pluck the guitar string by replacing the buffer with white noise. */
    public void pluck() {
        for (int i = 0; i < buffer.size(); i++) {
            double s = Math.random() - 0.5;
            buffer.removeFirst();
            buffer.addLast(s);
        }

    }

    public void tic() {
        double newItem = ((buffer.get(0) + buffer.get(1)) / 2)  * DECAY;
        buffer.removeFirst();
        buffer.addLast(newItem);
    }

    /* Return the double at the front of the buffer. */
    public double sample() {

        return buffer.get(0);
    }
}
    // TODO: Remove all comments that say TODO when you're done.
