public class DoubleLinkedList<T> implements DoubleLinkedList_Interface{
    int Size;
    private DoubleLinkedListElement_Interface Head;
    private DoubleLinkedListElement_Interface Tail;
    private DoubleLinkedListElement_Interface Dummy;

    @Override
    public void  CreateDummy() {
        Dummy = new DoubleLinkedListElement(0, 0, null, 0);
    }

    @Override
    public void SetTail(DoubleLinkedListElement_Interface NewTail) {
        Tail = NewTail;
    }

    @Override
    public void SetHead(DoubleLinkedListElement_Interface NewHead) {
        Head = NewHead;
    }
}
