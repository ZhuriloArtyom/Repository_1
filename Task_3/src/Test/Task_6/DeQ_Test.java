package Test.Task_6;
import base.Task_6.Dequeue;
import impl.Task_6.Dequeue_impl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DeQ_Test extends Assertions{
    @Test
    public void FrontTest(){
        Dequeue DeQ = new Dequeue_impl();
        DeQ.CreateDeQ();
        DeQ.PushFront(0);
        DeQ.PushFront(0);
        DeQ.PushFront(0);
        DeQ.PushFront("Test");
        assertEquals(DeQ.PeekFront(),  "Test");
        assertEquals(DeQ.PopFront(),  "Test");
        assertEquals(DeQ.PeekFront(),  0);
    }
    @Test
    public void BackTest(){
        Dequeue DeQ = new Dequeue_impl();
        DeQ.CreateDeQ();
        DeQ.PushBack(0);
        DeQ.PushBack(0);
        DeQ.PushBack(0);
        DeQ.PushBack("Test");
        assertEquals(DeQ.PeekBack(),  "Test");
        assertEquals(DeQ.PopBack(),  "Test");
        assertEquals(DeQ.PeekBack(),  0);
    }
}
