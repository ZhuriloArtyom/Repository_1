package Task_11;

import Task_9.BinarySearchTreeElement;
import Task_9.BinarySearchTreeElement_impl;
import Task_9.BinarySearchTree_impl;

public class RBTree_impl extends BinarySearchTree_impl implements RBTree{
    public  RBTreeElement dummy;
    public RBTree_impl() {
        RBTreeElement dummy = new RBTreeElement_impl(null);
        dummy.TurnBlack();
    }
    @Override
    public void SetRoot(RBTreeElement NewRoot){
        NewRoot.SetLeft(dummy);
        NewRoot.SetRight(dummy);
        NewRoot.SetRoot(dummy);
        NewRoot.TurnBlack();
        InitialRoot = NewRoot;
    }
    @Override
    public void Insert(String Data) {
        RBTreeElement Element = (RBTreeElement) InitialRoot;
        while (true){
            if (Integer.parseInt(Data) >= Integer.parseInt(Element.GetData())){
                if (Element.GetRight() == null){
                    Element.SetRight(new BinarySearchTreeElement_impl(Data));
                    Element.GetRight().SetRoot(Element);
                    break;
                }
                else Element = (RBTreeElement) Element.GetRight();
            }
            else{
                if (Element.GetLeft() == null){
                    Element.SetLeft(new BinarySearchTreeElement_impl(Data));
                    Element.GetLeft().SetRoot(Element);
                    break;
                }
                else Element = (RBTreeElement) Element.GetLeft();
            }
        }
        Element.SetRight(dummy);
        Element.SetLeft(dummy);
    }
}
