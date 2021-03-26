package impl.Task_6;

import base.Task_3.DoubleLinkedList_Interface;
import base.Task_6.Dequeue;
import impl.Task_3.DoubleLinkedList;

public class Dequeue_impl implements Dequeue {
    DoubleLinkedList_Interface List;



    @Override
    public void CreateDeQ() {
        List = new DoubleLinkedList();
        List = List.CreateList(0);
    }
    @Override
    public void PushFront(Object Data) { List.AddElement(Data, List.ReturnHead().GetPrevious()); }

    @Override
    public void PushBack(Object Data) { List.AddElement(Data, List.ReturnTail()); }

    @Override
    public Object PopFront() {
        return null;
    }

    @Override
    public Object PopBack() {
        return null;
    }

    @Override
    public Object PeekFront() {
        return null;
    }

    @Override
    public Object PeekBack() {
        return null;
    }
}
