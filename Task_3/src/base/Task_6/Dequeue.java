package base.Task_6;

public interface Dequeue<T> {
    void PushFront(T Data);
    void PushBack(T Data);
    T PopFront();
    T PopBack();
    T PeekFront();
    T PeekBack();
}
