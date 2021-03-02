public class DoubleLinkedElement <T> implements DoubleLinkedElement_Interface{
    private int Key;
    private int Next;
    private int Previous;
    private T Data;

    @Override
    public int GetNext() {
        return Next;
    }

    @Override
    public int GetKey() {
        return Key;
    }

    @Override
    public int GetPrevious() {
        return Previous;
    }

    @Override
    public void ChangeNext(int NewNext) {
        Next = NewNext;
    }

    @Override
    public void ChangePrevious(int NewPrevious) {
        Previous = NewPrevious;
    }

    @Override
    public Object GetData() {
        return Data;
    }
}
