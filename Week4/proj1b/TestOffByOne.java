import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByOne {
    // You must use this CharacterComparator and not instantiate
    // new ones, or the autograder might be upset.
    static CharacterComparator offByOne = new OffByOne();
    // Your tests go here.
    @Test
    public void testEqualChars() {
        assertTrue(offByOne.equalChars('a','b'));
        assertTrue(offByOne.equalChars('I','H'));
        assertTrue(offByOne.equalChars('C','D'));
        assertFalse(offByOne.equalChars('!','s'));
    }

}