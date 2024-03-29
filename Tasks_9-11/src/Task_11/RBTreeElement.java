package Task_11;

import Task_9.BinarySearchTreeElement;

public interface RBTreeElement extends BinarySearchTreeElement {
    void TurnRed();
    void TurnBlack();
    boolean IsRed();
    boolean IsRight();
    void SetIsRight(boolean i);
    void CopyColour(RBTreeElement Element);
}
