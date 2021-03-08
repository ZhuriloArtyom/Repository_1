package base;

public interface Stack_Interface<T> {
    void CreateStack();
    void push(T Data);
    T pop() throws Exception;
    T peek();
}
