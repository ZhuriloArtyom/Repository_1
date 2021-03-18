package Test.Task_5;
import base.Task_4.Stack;
import impl.Task_4.Stack_impl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import base.Task_5.Queue;
import impl.Task_5.Queue_impl;

public class Queue_Test extends Assertions{
    @Test
    public void CreateQueue_And_EnqueueTest(){
        Queue Queue = new Queue_impl();
        Queue.CreateQueue();
        Queue.Enqueue("Test");
        assertEquals(Queue.GetSize(), 1);
    }
    @Test
    public void Dequeue_And_PeekTest(){
        Queue Queue = new Queue_impl();
        Queue.CreateQueue();
        Queue.Enqueue("Test");
        Queue.Enqueue("Test1");
        assertEquals(Queue.Peek(),  "Test");
        assertEquals(Queue.Dequeue(),  "Test");
    }
}
