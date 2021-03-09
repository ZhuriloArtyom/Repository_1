package base;

public interface Stack<T>{
    boolean IsEmpty();
    void CreateStack();
    void Push(T Data);
    T Pop();
    T Peek();
}
