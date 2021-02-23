package Test;
import Code.Main;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class MainTest extends Assertions{
    @Test
    public void CreateArrayTest(){
        int[] Array = Main.CreateArray(7);
        assertEquals(7, Array.length);
    }
}
