import  org.junit.Test;
import static org.junit.Assert.*;

public class TestSLList {
    @Test
    public void testSLList(){
        SLList A = new SLList();
        A.addFirst(3);
        A.addFirst(2);
        A.addFirst(1);
        A.addFirst(0);
        A.insert(99,2);

        SLList B = new SLList();
        B.addFirst(3);
        B.addFirst(2);
        B.addFirst(99);
        B.addFirst(1);
        B.addFirst(0);

        assertEquals(A,B);
    }
}
