package Task_10;
import Task_9.BinarySearchTreeElement;

public interface AVLElement extends BinarySearchTreeElement {
    int GetHeight();
    void ChangeHeight(boolean Change);
    void SetIsRight(boolean Direction);
    boolean IsRight();
}
