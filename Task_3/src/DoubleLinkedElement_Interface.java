public interface DoubleLinkedElement_Interface <T> {
    int GetNext();
    int GetKey();
    int GetPrevious();
    void ChangeNext(int NewNext);
    void ChangePrevious(int NewPrevious);
    T GetData();
}
