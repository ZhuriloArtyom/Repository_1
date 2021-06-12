package Task_11;

import Task_9.BinarySearchTreeElement_impl;

public class RBTreeElement_impl extends BinarySearchTreeElement_impl implements RBTreeElement{
    private boolean IsRed;
    private boolean IsRight;
    public RBTreeElement_impl(String Data) {
        super(Data);
        IsRed = true;
    }

    @Override
    public void TurnRed() {
        IsRed = true;
    }

    @Override
    public void TurnBlack() {
        IsRed = false;
    }

    @Override
    public boolean IsRed() {
        return IsRed;
    }

    @Override
    public boolean IsRight() {
        return IsRight;
    }

    @Override
    public void SetIsRight(boolean i) {
        IsRight = i;
    }
}
