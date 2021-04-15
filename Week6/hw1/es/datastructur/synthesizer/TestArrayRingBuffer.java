package es.datastructur.synthesizer;
import org.junit.Test;
import static org.junit.Assert.*;

/** Tests the ArrayRingBuffer class.
 *  @author Josh Hug
 */

public class TestArrayRingBuffer {
    @Test
    public void someTest() {
        ArrayRingBuffer<Integer> RB = new ArrayRingBuffer<>(7);
        assertTrue(RB.isEmpty());
        RB.enqueue(23);
        RB.enqueue(24);
        RB.enqueue(25);
        RB.enqueue(26);
        RB.enqueue(27);
        RB.enqueue(28);
        RB.enqueue(29);
        assertTrue(RB.isFull());
        RB.dequeue();
        RB.dequeue();
        RB.dequeue();
        assertEquals(RB.first, 3);

        //Testing Iterator
        int[] x = new int[RB.fillCount()];
        int i = 0;
        for (int item : RB) {
            x[i] = item;
            i++;
        }
        assertArrayEquals(x, new int[]{26, 27, 28, 29});


        ArrayRingBuffer<Integer> BB = new ArrayRingBuffer<>(5);
        assertTrue(BB.isEmpty());
        BB.enqueue(1);
        BB.enqueue(2);
        BB.enqueue(3);
        BB.enqueue(4);
        BB.enqueue(5);
        BB.dequeue();
        BB.enqueue(99);
        BB.dequeue();
        BB.dequeue();


        int[] y = new int[BB.fillCount()];
        int j = 0;
        for (int item : BB) {
            y[j] = item;
            j++;
        }
        assertArrayEquals(y, new int[]{4,5,99});

        //Testing equals()
        ArrayRingBuffer<Integer> e1 = new ArrayRingBuffer<>(5);
        ArrayRingBuffer<Integer> e2 = new ArrayRingBuffer<>(5);
        for (int c=0; i<5; i++) {
            e1.enqueue(c);
            e2.enqueue(c);
        }
        assertTrue(e1.equals(e2));
    }
}
