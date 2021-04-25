package Task_10;
import Task_9.BinarySearchTree;

public interface AVLTree extends BinarySearchTree{
    void HeightDifferenceAdjustments(AVLElement Element, boolean Change);
    void HeightDifferenceCorrection(AVLElement Element);
    boolean SimpleTurnCheck(AVLElement Element);
    void SimpleTurn(AVLElement Element);
    void ComplexTurn(AVLElement Element);
}
