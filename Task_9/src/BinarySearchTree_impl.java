
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
        if (Data.equals(Element.GetData())) {return Element;}
        else if (Integer.parseInt(Data) > Integer.parseInt(Element.GetData()) && Element.GetRight()!= null){return IterationOfSearch(Data,Element.GetRight());}
        else if (Integer.parseInt(Data) < Integer.parseInt(Element.GetData()) && Element.GetLeft()!= null){return IterationOfSearch(Data,Element.GetLeft());}
        else return null;
    }


    @Override
    public void Insert(String Data) {
        BinarySearchTreeElement Element = InitialRoot;
        while (true){
            if (Integer.parseInt(Data) >= Integer.parseInt(Element.GetData())){
                if (Element.GetRight() == null){
                    Element.SetRight(new BinarySearchTreeElement_impl(Data));
                    Element.GetRight().SetRoot(Element);
                    break;
                }
                else Element = Element.GetRight();
            }
            else{
                if (Element.GetLeft() == null){
                    Element.SetLeft(new BinarySearchTreeElement_impl(Data));
                    Element.GetLeft().SetRoot(Element);
                    break;
                }
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
        if (Element.GetLeft() == null && Element.GetRight() == null){
            if (Element.GetRoot().GetLeft() == Element){
                Element.GetRoot().SetLeft(null);
            }
            else {
                Element.GetRoot().SetRight(null);
            }

        }
        else if(Element.GetLeft() == null){
            if (Element.GetRoot().GetLeft() == Element){
                Element.GetRoot().SetLeft(Element.GetRight());
            }
            else {
                Element.GetRoot().SetRight(Element.GetRight());
            }
            Element.GetRight().SetRoot(Element.GetRoot());
        }
        else if(Element.GetRight() == null){
            if (Element.GetRoot().GetLeft() == Element){
                Element.GetRoot().SetLeft(Element.GetLeft());
            }
            else {
                Element.GetRoot().SetRight(Element.GetLeft());
            }
            Element.GetLeft().SetRoot(Element.GetRoot());
        }
        else{
            BinarySearchTreeElement CurrentElement = Successor(Element);
            while (true){
                if (Predecessor(CurrentElement) == null){
                    if (Successor(CurrentElement) != null){
                        Successor(CurrentElement).SetRoot(CurrentElement.GetRoot());}
                    if (Integer.parseInt(InitialRoot.GetData()) > Integer.parseInt(CurrentElement.GetData())){
                        CurrentElement.GetRoot().SetLeft(Successor(CurrentElement));
                    }
                    else CurrentElement.GetRoot().SetRight(Successor(CurrentElement));
                    Element.GetRight().SetRoot(CurrentElement);
                    Element.GetLeft().SetRoot(CurrentElement);
                    CurrentElement.SetLeft(Element.GetLeft());
                    CurrentElement.SetRight(Element.GetRight());
                    if (Integer.parseInt(InitialRoot.GetData()) > Integer.parseInt(CurrentElement.GetData())){
                        Element.GetRoot().SetLeft(CurrentElement);
                    }
                    else Element.GetRoot().SetRight(CurrentElement);
                    CurrentElement.SetRoot(Element.GetRoot());
                    break;
                }
                else CurrentElement = Predecessor(CurrentElement);
            }
        }
    }

    @Override
    public BinarySearchTreeElement Successor(BinarySearchTreeElement Element) {
        if (Integer.parseInt(InitialRoot.GetData()) > Integer.parseInt(Element.GetData())){
            return Element.GetLeft();
        }
        else return Element.GetRight();
    }
    @Override
    public BinarySearchTreeElement Predecessor(BinarySearchTreeElement Element) {
        if (Integer.parseInt(InitialRoot.GetData()) > Integer.parseInt(Element.GetData())){
            return Element.GetRight();
        }
        else return Element.GetLeft();
    }
}
