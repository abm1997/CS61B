import org.junit.Test;
import static org.junit.Assert.* ;

public class TestSort{
    @Test
    public void testSort(){
        String[] input = {"I" , "have" , "an" , "egg"};
        String[] expected = {"an" , "egg" , "have" , "I"};
        Sort.sort(input);
        assertArrayEquals(input,expected);
    }

    @Test
    public void testFindSmallest(){
        String[] input = {"I" , "have" , "an" , "egg"};
        int expected = 2;
        int actual = Sort.findSmallest(input,0);
        assertEquals(actual,expected);

        String[] input2 = {"there", "are", "many", "pigs"};
        int expected2 = 1;
        int actual2 = Sort.findSmallest(input2,0);
        assertEquals(expected2 , actual2 );

    }

}