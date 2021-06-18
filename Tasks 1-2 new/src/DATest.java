import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class  DATest extends Assertions {

    @Test
    public void Test1()
    {
        DinamicArray Arr = new DinamicArray_impl(6);
        Arr.resize(9);
        assertEquals(9, Arr.Size());}
    @Test
    public void Test2()
    {
        DinamicArray Arr = new DinamicArray_impl(6);
        Arr.set(4, 9);
        assertEquals(9, Arr.get(4));}

    @Test
    public void Test3()
    {
        DinamicArray Arr = new DinamicArray_impl(6);
        Arr.set(4, 9);
        Arr.removed(2);
        assertEquals(9, Arr.get(3));}

    @Test
    public void Test4()
    {
        DinamicArray Arr = new DinamicArray_impl(6);
        Arr.set(4, 9);
        Arr.insert(4, 16);
        assertEquals(9, Arr.get(5));}

}
