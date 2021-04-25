package Task_10;
import Task_9.BinarySearchTreeElement_impl;


public class AVLElement_impl extends BinarySearchTreeElement_impl implements AVLElement{
   private int HeightDifference =0;
   private boolean IsRightNod;
    public AVLElement_impl(String Data) {
        super(Data);
    }


    @Override
    public int GetHeight() {
        return HeightDifference;
    }

    @Override
    public void ChangeHeight(boolean Change) {
        if (Change){
            HeightDifference++;
        }
        else{
            HeightDifference--;
        }
    }

    @Override
    public void SetIsRight(boolean Direction) {
        IsRightNod = Direction;
    }

    @Override
    public boolean IsRight() {
        return IsRightNod;
    }
}
