package Task_10;
import Task_9.BinarySearchTreeElement_impl;


public class AVLElement_impl extends BinarySearchTreeElement_impl implements AVLElement{
   private int HeightDifference =0;
    public AVLElement_impl(String Data) {
        super(Data);
    }


    @Override
    public int GetHeight() {
        return HeightDifference;
    }
}
