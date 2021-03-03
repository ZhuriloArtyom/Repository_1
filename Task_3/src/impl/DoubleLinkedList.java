package impl;
import base.*;

public class DoubleLinkedList<T> implements DoubleLinkedList_Interface {
    int Size;
    private DoubleLinkedListElement_Interface Head;
    private DoubleLinkedListElement_Interface Tail;
    private DoubleLinkedListElement_Interface Dummy;

    @Override
    public void  CreateDummy() {
        Dummy = new DoubleLinkedListElement( Dummy, null, Dummy);
    }

    @Override
    public void SetTail(DoubleLinkedListElement_Interface NewTail) {
        Tail = NewTail;
    }

    @Override
    public void SetHead(DoubleLinkedListElement_Interface NewHead) {
        Head = NewHead;
    }

    @Override
    public DoubleLinkedListElement_Interface ReturnTail() {
        return Tail;
    }

    @Override
    public DoubleLinkedListElement_Interface ReturnHead() {
        return Head;
    }


    @Override
    public DoubleLinkedListElement_Interface ReturnNext(DoubleLinkedListElement_Interface CurrentElement) {
        return CurrentElement.GetNext();
    }

    @Override
    public DoubleLinkedListElement_Interface ReturnPrev(DoubleLinkedListElement_Interface CurrentElement) {
        return CurrentElement.GetPrevious();
    }


}
