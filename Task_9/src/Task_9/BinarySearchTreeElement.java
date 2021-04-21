package Task_9;

public interface BinarySearchTreeElement {
    BinarySearchTreeElement GetRoot();
    void SetRoot(BinarySearchTreeElement Element);
    BinarySearchTreeElement GetLeft();
    void SetLeft(BinarySearchTreeElement Element);
    BinarySearchTreeElement GetRight();
    void SetRight(BinarySearchTreeElement Element);
    String GetData();
    void SetData(String NewData);
}
