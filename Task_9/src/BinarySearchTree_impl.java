
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
        BinarySearchTreeElement Element = InitialRoot;
        while (true){
            if (Integer.parseInt(Data) >= Integer.parseInt(Element.GetData())){
                if (Element.GetRight() == null){Element.SetRight(new BinarySearchTreeElement_impl(Data));}
                else Element = Element.GetRight();
            }
            else{
                if (Element.GetLeft() == null){Element.SetLeft(new BinarySearchTreeElement_impl(Data));}
                else Element = Element.GetLeft();
            }
        }
    }

    @Override
    public BinarySearchTreeElement Min() {
        BinarySearchTreeElement Element = InitialRoot;
        while (true){
            if (Element.GetLeft() == null){return Element;}
            Element = Element.GetLeft();
        }
    }

    @Override
    public BinarySearchTreeElement Max() {
        BinarySearchTreeElement Element = InitialRoot;
        while (true){
            if (Element.GetRight() == null){return Element;}
            Element = Element.GetRight();
        }    }

    @Override
    public void Delete(BinarySearchTreeElement Element) {

    }
}
