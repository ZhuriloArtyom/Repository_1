package Task_9;

public interface BinarySearchTree {
    BinarySearchTreeElement GetInitialRoot();
    void SetRoot(BinarySearchTreeElement NewRoot);
    BinarySearchTreeElement Search(String Data);
    BinarySearchTreeElement IterationOfSearch(String Data, BinarySearchTreeElement Element);
    void Insert(String Data);
    BinarySearchTreeElement Min();
    BinarySearchTreeElement Max();
    void Delete(BinarySearchTreeElement Element);
    BinarySearchTreeElement Successor(BinarySearchTreeElement Element);
    BinarySearchTreeElement Predecessor(BinarySearchTreeElement Element);
}

