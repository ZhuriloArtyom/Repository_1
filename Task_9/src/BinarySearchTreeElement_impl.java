public class BinarySearchTreeElement_impl implements BinarySearchTreeElement{
    private BinarySearchTreeElement Root;
    private BinarySearchTreeElement Left;
    private BinarySearchTreeElement Right;
    private String Data;

    public BinarySearchTreeElement_impl(BinarySearchTreeElement Root, BinarySearchTreeElement Left, BinarySearchTreeElement Right, String Data){
        this.Root = Root;
        this.Data = Data;
        this.Left = Left;
        this.Right = Right;
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
