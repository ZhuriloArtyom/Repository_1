package base;


public interface DoubleLinkedListElement_Interface <T> {
    DoubleLinkedListElement_Interface GetNext();
    DoubleLinkedListElement_Interface GetPrevious();
    void ChangeNext(DoubleLinkedListElement_Interface NewNext);
    void ChangePrevious(DoubleLinkedListElement_Interface NewPrevious);
    T GetData();
}
