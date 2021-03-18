package impl.Task_5;

import base.Task_3.DoubleLinkedListElement_Interface;
import base.Task_3.DoubleLinkedList_Interface;
import base.Task_5.Queue;
import impl.Task_3.DoubleLinkedList;

public class Queue_impl<T> implements Queue {
    DoubleLinkedList_Interface List;



    @Override
    public void CreateQueue() {
        List = new DoubleLinkedList();
        List = List.CreateList(0);
    }

    @Override
    public void Enqueue(Object Data) {
        List.AddElement(Data, List.ReturnTail());
    }

    @Override
    public Object Dequeue() {
        Object Data = List.ReturnHead().GetData();
        List.DeleteElement(List.ReturnTail());
        return Data;
    }


    @Override
    public Object Peek() {
        return List.ReturnHead().GetData();
    }

    @Override
    public int GetSize() {
        return List.ReturnSize();
    }
}
