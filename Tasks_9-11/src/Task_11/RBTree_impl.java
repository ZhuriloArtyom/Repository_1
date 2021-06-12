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
    public void ColourCorrection(RBTreeElement Element) {
        RBTreeElement Y = (RBTreeElement) Element.GetRoot();
        if(Element.IsRed() && ( Y).IsRed()) {
            if ((Y).IsRight())
            {
                RBTreeElement Z = (RBTreeElement) Y.GetRoot();
                RBTreeElement X = (RBTreeElement) Y.GetRoot().GetLeft();
                if((X).IsRed()){
                    Y.TurnBlack();
                    X.TurnBlack();
                    if(Z != InitialRoot) {Z.TurnRed();
                    ColourCorrection(Z);}
                }

            else if (!Element.IsRight()){
                Element.SetRoot(Z);
                Y.SetLeft(Element.GetRight());
                Element.SetRight(Y);
                Y.SetRoot(Element);
                Z.SetRight(Element);
                ColourCorrection(Y);
            }
            else {
                    if ((X).IsRed()) {
                        Y.TurnBlack();
                        X.TurnBlack();
                        Z.TurnRed();
                        if (Z== InitialRoot){InitialRoot = Y;}
                        Z.SetRight(Y.GetLeft());
                        Z.GetRight().SetRoot(Z);
                        Z.SetRoot(Y);
                        Y.SetLeft(Z);
                        Y.SetRoot(dummy);
                        }
                    }
                }
            else{
                RBTreeElement Z = (RBTreeElement) Y.GetRoot();
                RBTreeElement X = (RBTreeElement) Y.GetRoot().GetRight();
                if((X).IsRed()){
                    Y.TurnBlack();
                    X.TurnBlack();
                    if(Z != InitialRoot) {Z.TurnRed();
                        ColourCorrection(Z);}
                }

                else if (Element.IsRight()){
                    Element.SetRoot(Z);
                    Y.SetRight(Element.GetLeft());
                    Element.SetLeft(Y);
                    Y.SetRoot(Element);
                    Z.SetLeft(Element);
                    ColourCorrection(Y);
                }
                else {
                    if ((X).IsRed()) {
                        Y.TurnBlack();
                        X.TurnBlack();
                        Z.TurnRed();
                        if (Z== InitialRoot){InitialRoot = Y;}
                        Z.SetLeft(Y.GetRight());
                        Z.GetLeft().SetRoot(Z);
                        Z.SetRoot(Y);
                        Y.SetRight(Z);
                        Y.SetRoot(dummy);
                    }
                }



            }

        }

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
        Element.SetIsRight(Element.GetRoot().GetRight()==Element);
        Element.SetRight(dummy);
        Element.SetLeft(dummy);
        ColourCorrection(Element);
    }
}
