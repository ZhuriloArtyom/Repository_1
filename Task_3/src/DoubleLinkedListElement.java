public class DoubleLinkedListElement <T> implements DoubleLinkedListElement_Interface{
    private int Key;
    private int Next;
    private int Previous;
    private T Data;

    public DoubleLinkedListElement(int Key, int Previous, T Data, int Next){
        this.Key = Key;
        this.Previous = Previous;
        this.Data = Data;
        this.Next = Next;
    }
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
