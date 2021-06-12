package Task_11;

import Task_9.BinarySearchTree;
import Task_9.BinarySearchTreeElement;

public interface RBTree extends BinarySearchTree {
    void SetRoot(RBTreeElement NewRoot);
    void ColourCorrection(RBTreeElement Element);
}
