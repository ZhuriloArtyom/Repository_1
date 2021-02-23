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
    @Test
    public void ResizeArrayTest1(){
        int[] Array = new int[5];
        Array[4] = 6;
        Array = Main.ResizeArray(7, Array);
        assertEquals(6, Array[4]);
        assertEquals(7, Array.length);
    }
    @Test
    public void ResizeArrayTest2(){
        int[] Array = new int[5];
        Array = Main.ResizeArray(3, Array);
        assertEquals(3, Array.length);
    }
}
