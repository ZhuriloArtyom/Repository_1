package base.Task_5;

import base.Task_3.DoubleLinkedListElement_Interface;

public interface Queue<T> {
    void CreateQueue();
    void Enqueue(T Data);
    T Dequeue();
    T Peek();
    int GetSize();

}
