package Task_9;

import Task_9.BinarySearchTreeElement;

public class BinarySearchTreeElement_impl implements BinarySearchTreeElement {
    private BinarySearchTreeElement Root;
    private BinarySearchTreeElement Left;
    private BinarySearchTreeElement Right;
    private String Data;

    public BinarySearchTreeElement_impl(String Data){
        this.Root = null;
        this.Data = Data;
        this.Left = null;
        this.Right = null;
    }

    @Override
    public BinarySearchTreeElement GetRoot() {
        return Root;
    }

    @Override
    public void SetRoot(BinarySearchTreeElement Element) {
        Root = Element;
    }

    @Override
    public BinarySearchTreeElement GetLeft() {
        return Left;
    }

    @Override
    public void SetLeft(BinarySearchTreeElement Element) {
        Left = Element;
    }

    @Override
    public BinarySearchTreeElement GetRight() {
        return Right;
    }

    @Override
    public void SetRight(BinarySearchTreeElement Element) {
        Right = Element;
    }

    @Override
    public String GetData() {
        return Data;
    }

    @Override
    public void SetData(String NewData) {
        Data = NewData;
    }
}
