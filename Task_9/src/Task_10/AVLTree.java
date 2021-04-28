package Task_10;
import Task_9.BinarySearchTree;
import Task_9.BinarySearchTreeElement;

public interface AVLTree extends BinarySearchTree{
    void HeightDifferenceAdjustments(AVLElement Element, boolean Change);
    void HeightDifferenceCorrection(AVLElement Element);
    boolean SimpleTurnCheck(AVLElement Element);
    void SimpleTurn(AVLElement Element);
    void ComplexTurn(AVLElement Element);
    void Delete(AVLElement Element);
}
