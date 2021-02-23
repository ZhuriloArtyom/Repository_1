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
    @Test
    public void AddToArrayTest(){
        int[] Array = new int[3];
        Array = Main.AddToArray(1,5, Array);
        assertEquals(5, Array[1]);

    }
}
