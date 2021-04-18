
public class BinarySearchTree_impl implements BinarySearchTree{
    BinarySearchTreeElement InitialRoot;


    @Override
    public BinarySearchTreeElement GetInitialRoot() {
        return InitialRoot;
    }

    @Override
    public void SetRoot(BinarySearchTreeElement NewRoot) {
        InitialRoot = NewRoot;
    }

    @Override
    public BinarySearchTreeElement Search(String Data) {
        return IterationOfSearch(Data, InitialRoot);
    }

    @Override
    public BinarySearchTreeElement IterationOfSearch(String Data, BinarySearchTreeElement Element) {
        if (Data == Element.GetData()) {return Element;}
        else if (Integer.parseInt(Data) > Integer.parseInt(Element.GetData()) && Element.GetRight()!= null){return IterationOfSearch(Data,Element.GetRight());}
        else if (Integer.parseInt(Data) < Integer.parseInt(Element.GetData()) && Element.GetLeft()!= null){return IterationOfSearch(Data,Element.GetLeft());}
        else return null;
    }


    @Override
    public void Insert(String Data) {

    }

    @Override
    public BinarySearchTreeElement Min() {
        return null;
    }

    @Override
    public BinarySearchTreeElement Max() {
        return null;
    }

    @Override
    public void Delete(BinarySearchTreeElement Element) {

    }
}
