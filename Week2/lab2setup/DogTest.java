import static org.junit.Assert.*;
import org.junit.Test;

public class DogTest {    

    public void testSmall() {
        Dog d = new Dog(3);
        assertEquals("yip", d.noise());
    }


    public void testLarge() {
        Dog d = new Dog(20);
        assertEquals("bark", d.noise());
    }
}
