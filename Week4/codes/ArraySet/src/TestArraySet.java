import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestArraySet {
    @Test
    public void test() {
        ArraySet<String> s = new ArraySet<>();
        //s.add(null);
        s.add("horse");
        s.add("fish");
        s.add("house");
        s.add("fish");
        assertTrue(s.contains("horse"));
        assertEquals(3, s.size());

        ArraySet<Integer> aset1 = new ArraySet<>();
        aset1.add(5);
        aset1.add(23);
        aset1.add(42);
        ArraySet<Integer> aset2 = new ArraySet<>();
        aset2.add(5);
        aset2.add(23);
        aset2.add(42);
        assertTrue(aset1.equals(aset2));
    }
}
