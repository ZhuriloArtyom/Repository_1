package impl;
import base.*;

public class DoubleLinkedListElement <T> implements DoubleLinkedListElement_Interface {
    private DoubleLinkedListElement_Interface Next;
    private DoubleLinkedListElement_Interface Previous;
    private T Data;

    public DoubleLinkedListElement( DoubleLinkedListElement_Interface Previous, T Data, DoubleLinkedListElement_Interface Next){
        this.Previous = Previous;
        this.Data = Data;
        this.Next = Next;
    }
    @Override
    public DoubleLinkedListElement_Interface GetNext() {
        return Next;
    }


    @Override
    public DoubleLinkedListElement_Interface GetPrevious() {
        return Previous;
    }

    @Override
    public void ChangeNext(DoubleLinkedListElement_Interface NewNext) {
        Next = NewNext;
    }

    @Override
    public void ChangePrevious(DoubleLinkedListElement_Interface NewPrevious) {
        Previous = NewPrevious;
    }

    @Override
    public Object GetData() {
        return Data;
    }

}
