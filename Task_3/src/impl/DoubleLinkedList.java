package impl;
import base.*;
import base.DoubleLinkedListElement_Interface;

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

    @Override
    public void AddElement(Object Data, DoubleLinkedListElement_Interface CurrentElement) {
        DoubleLinkedListElement_Interface AddedElement = new DoubleLinkedListElement(CurrentElement, Data, CurrentElement.GetNext());
        CurrentElement.GetNext().ChangePrevious(AddedElement);
        CurrentElement.ChangeNext(AddedElement);
    }

    @Override
    public void DeleteElement(DoubleLinkedListElement_Interface CurrentElement) {
        CurrentElement.GetNext().ChangePrevious(CurrentElement.GetPrevious());
        CurrentElement.GetPrevious().ChangeNext(CurrentElement.GetNext());
    }


}
