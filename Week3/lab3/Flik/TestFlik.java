import org.junit.Test;
import static org.junit.Assert.*;

public class TestFlik {
    @Test
    public void testFlik(){
        int i=0;
        while(i++ <= 500){
            boolean x = Flik.isSameNumber(i,i);
            assertTrue(x);
        }
    }
}
