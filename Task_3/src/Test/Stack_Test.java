package Test;
import impl.Stack_impl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import base.Stack;

public class Stack_Test extends Assertions{
    @Test
    public void CreateStack_And_PushTest(){
        Stack Stack = new Stack_impl();
        Stack.CreateStack();
        assertTrue(Stack.IsEmpty());
        Stack.Push("Test");
        assertFalse(Stack.IsEmpty());
    }
    @Test
    public void Pop_And_PeekTest(){
        Stack Stack = new Stack_impl();
        Stack.CreateStack();
        Stack.Push("Test");
        assertEquals(Stack.Peek(),  "Test");
        assertFalse(Stack.IsEmpty());
        assertEquals(Stack.Pop(),  "Test");
        assertTrue(Stack.IsEmpty());
    }
}
