package Task_10;
import Task_9.BinarySearchTree;
import Task_9.BinarySearchTreeElement;
import Task_9.BinarySearchTree_impl;

public class AVLTree_impl extends BinarySearchTree_impl implements AVLTree{
 //   private BinarySearchTreeElement InitialRoot;

    @Override
    public AVLElement Min() {
        AVLElement Element = (AVLElement) InitialRoot;
        while (true){
            if (Element.GetLeft() == null){return Element;}
            Element = (AVLElement) Element.GetLeft();
        }
    }

    @Override
    public AVLElement Max() {
        AVLElement Element = (AVLElement) InitialRoot;
        while (true){
            if (Element.GetRight() == null){return Element;}
            Element = (AVLElement) Element.GetRight();
        }    }

    @Override
    public void SetRoot(AVLElement NewRoot) {
        InitialRoot = NewRoot;
    }
    @Override
    public void Insert(String Data) {
        AVLElement NewElement = new AVLElement_impl(Data);
        BinarySearchTreeElement Element = InitialRoot;
        while (true){
            if (Integer.parseInt(Data) >= Integer.parseInt(Element.GetData())){
                if (Element.GetRight() == null){
                    NewElement.SetIsRight(true);
                    Element.SetRight(NewElement);
                    Element.GetRight().SetRoot(Element);
                    HeightDifferenceAdjustments((AVLElement) Element, true);
                    HeightDifferenceCorrection((AVLElement) Element);
                    break;
                }
                else Element = Element.GetRight();
            }
            else{
                if (Element.GetLeft() == null){
                    NewElement.SetIsRight(false);
                    Element.SetLeft(NewElement);
                    Element.GetLeft().SetRoot(Element);
                    HeightDifferenceAdjustments((AVLElement) Element, false);
                    HeightDifferenceCorrection((AVLElement) Element);
                    break;
                }
                else Element = Element.GetLeft();
            }
        }

    }

    @Override
    public void HeightDifferenceAdjustments(AVLElement Element, boolean Change) {
        boolean WasZero = false;
        if (Element.GetHeight() == 0) {
            WasZero = true;
        }
        Element.ChangeHeight(Change);
        if (WasZero && Element!= InitialRoot){
            HeightDifferenceAdjustments((AVLElement) Element.GetRoot(), Element.IsRight());
        }
    }

    @Override
    public void HeightDifferenceCorrection(AVLElement Element) {
        if(Element.GetHeight()<=1&& Element.GetHeight()>=-1){
            if(Element!= InitialRoot) {
                HeightDifferenceCorrection((AVLElement) Element.GetRoot());
            }
        }
        else{
            if(SimpleTurnCheck(Element)){SimpleTurn(Element);}
            else{ComplexTurn(Element);}
        }
    }

    @Override
    public boolean SimpleTurnCheck(AVLElement Element) {
        if(Element.GetHeight()>0){
            AVLElement T = (AVLElement) Element.GetRight();
            return(T.GetHeight()>=1);
        }
        else{AVLElement T = (AVLElement) Element.GetLeft();
            return(T.GetHeight()<=1); }
    }

    @Override
    public void SimpleTurn(AVLElement Element) {
        if(Element.GetHeight()>0){
            AVLElement A = (AVLElement) Element.GetRight();
            if(Element.IsRight()){if(Element.GetRoot()!= null){Element.GetRoot().SetRight(A);
            A.SetIsRight(true);}}
            else{if(Element.GetRoot()!= null){Element.GetRoot().SetLeft(A);
                A.SetIsRight(false);}}
            A.SetRoot(Element.GetRoot());
            if(A.GetLeft()!= null)A.GetLeft().SetRoot(Element);
            Element.SetRight(A.GetLeft());
            ((AVLElement) Element.GetRight()).SetIsRight(true);
            A.SetLeft(Element);
            Element.SetIsRight(false);
            Element.SetRoot(A);
            if(A.GetRight()!=null)A.GetRight().SetRoot(A);
            Element.SetHeight(0);
            A.SetHeight(0);
            if (InitialRoot==Element){InitialRoot=A;}
        }
        else{
            AVLElement A = (AVLElement) Element.GetLeft();
            if(Element.IsRight()){if(Element.GetRoot()!= null)Element.GetRoot().SetRight(A); }
            else{if(Element.GetRoot()!= null)Element.GetRoot().SetLeft(A);}
            A.SetRoot(Element.GetRoot());
            if(A.GetRight()!= null)A.GetRight().SetRoot(Element);
            Element.SetLeft(A.GetRight());
            A.SetRight(Element);
            Element.SetRoot(A);
            if(A.GetLeft()!= null)A.GetLeft().SetRoot(A);
            Element.SetHeight(0);
            A.SetHeight(0);
            if (InitialRoot==Element){InitialRoot=A;}
        }
    }

    @Override
    public void ComplexTurn(AVLElement Element) {
        if(Element.GetHeight()>0){
            AVLElement A = (AVLElement) Element.GetRight();
            AVLElement B = (AVLElement) Element.GetRight().GetLeft();
            boolean Condition;
            if(B.GetHeight()>0){Condition= true ;}
            else{Condition= false;}
            if(Element.IsRight()){if(Element.GetRoot()!= null) Element.GetRoot().SetRight(B); }
            else{ if(Element.GetRoot()!= null) Element.GetRoot().SetLeft(B);}
            B.SetRoot(Element.GetRoot());
            if(B.GetRight()!= null){B.GetRight().SetRoot(A);}
            A.SetLeft(B.GetRight());
            if(B.GetLeft()!= null){B.GetLeft().SetRoot(Element);}
            Element.SetRight(B.GetLeft());
            B.SetLeft(Element);
            Element.SetRoot(B);
            B.SetRight(A);
            A.SetRoot(B);
            if(A.GetLeft()!=null) A.GetLeft().SetRoot(A);
            if(Element.GetRight()!=null)Element.GetRight().SetRoot(Element);
            if(Condition){
                A.SetHeight(-1);
                Element.SetHeight(1);
            }
            else{
                A.SetHeight(0);
                Element.SetHeight(0);
            }
            if (InitialRoot==Element){InitialRoot=B;}
        }
        else{
            {

                AVLElement A = (AVLElement) Element.GetLeft();
                AVLElement B = (AVLElement) Element.GetLeft().GetRight();
                boolean Condition;
                if(B.GetHeight()>0){Condition= true ;}
                else{Condition= false;}
                if(Element.IsRight()){if(Element.GetRoot()!= null)Element.GetRoot().SetRight(B); }
                else{if(Element.GetRoot()!= null)Element.GetRoot().SetLeft(B);}
                B.SetRoot(Element.GetRoot());
                if(B.GetRight()!= null)B.GetRight().SetRoot(A);
                A.SetRight(B.GetLeft());
                if(B.GetLeft()!= null)B.GetLeft().SetRoot(Element);
                Element.SetLeft(B.GetRight());
                B.SetRight(Element);
                Element.SetRoot(B);
                B.SetLeft(A);
                A.SetRoot(B);
                if(A.GetRight()!= null)A.GetRight().SetRoot(A);
                if(Element.GetLeft()!= null)Element.GetLeft().SetRoot(Element);
                if(Condition){
                    A.SetHeight(0);
                    Element.SetHeight(0);
                }
                else{
                    A.SetHeight(1);
                    Element.SetHeight(-1);
                }
                if (InitialRoot==Element){InitialRoot=B;}

            }
        }
    }


    @Override
    public void Delete(BinarySearchTreeElement Element) {
        AVLElement Ell = (AVLElement) Element;
        if (Ell.GetLeft() == null && Ell.GetRight() == null){

            if (!Ell.IsRight()){
                boolean Y = Ell.IsRight();
                Ell.GetRoot().SetLeft(null);
                HeightDifferenceAdjustments((AVLElement) Ell.GetRoot(), true);
                HeightDifferenceCorrection((AVLElement) Ell.GetRoot());
            }
            else {
                Ell.GetRoot().SetRight(null);
                HeightDifferenceAdjustments((AVLElement) Ell.GetRoot(), false);
                HeightDifferenceCorrection((AVLElement) Ell.GetRoot());
            }

        }
        else if(Ell.GetLeft() == null){
            if (Ell.GetRoot().GetLeft() == Ell){
                AVLElement A = (AVLElement)Ell.GetRight();
                A.SetHeight(Ell.GetHeight());
                Ell.GetRoot().SetLeft(A);
                HeightDifferenceAdjustments(A, false);
                HeightDifferenceCorrection(A);
            }
            else {
                AVLElement A = (AVLElement)Element.GetRight();
                A.SetHeight(Ell.GetHeight());
                Ell.GetRoot().SetRight(A);
                HeightDifferenceAdjustments(A, false);
                HeightDifferenceCorrection(A);
            }
            Ell.GetRight().SetRoot(Element.GetRoot());
        }
        else if(Ell.GetRight() == null){
            if (Ell.GetRoot().GetLeft() == Ell){
                AVLElement A = (AVLElement)Ell.GetLeft();
                A.SetHeight(Ell.GetHeight());
                Ell.GetRoot().SetLeft(A);
                HeightDifferenceAdjustments(A, true);
                HeightDifferenceCorrection(A);
            }
            else {
                AVLElement A = (AVLElement)Ell.GetLeft();
                A.SetHeight(Ell.GetHeight());
                Ell.GetRoot().SetRight(A);
                HeightDifferenceAdjustments(A, true);
                HeightDifferenceCorrection(A);
            }
            Ell.GetLeft().SetRoot(Ell.GetRoot());
        }
        else{
            AVLElement CurrentElement = (AVLElement)Successor(Ell);
            while (true){
                if (Predecessor(CurrentElement) == null){
                    AVLElement B = (AVLElement) CurrentElement.GetRoot();
                    boolean Change = !CurrentElement.IsRight();
                    if (Successor(CurrentElement) != null){
                        Successor(CurrentElement).SetRoot(CurrentElement.GetRoot());}
                      if (CurrentElement.IsRight()){
                          CurrentElement.GetRoot().SetLeft(Successor(CurrentElement));
                     }
                        else CurrentElement.GetRoot().SetRight(Successor(CurrentElement));
                        Ell.GetRight().SetRoot(CurrentElement);
                        Ell.GetLeft().SetRoot(CurrentElement);
                        CurrentElement.SetLeft(Ell.GetLeft());
                        CurrentElement.SetRight(Ell.GetRight());
                     if (Integer.parseInt(InitialRoot.GetData()) > Integer.parseInt(CurrentElement.GetData())){
                         Element.GetRoot().SetLeft(CurrentElement);
                     }
                    else Element.GetRoot().SetRight(CurrentElement);
                    CurrentElement.SetRoot(Element.GetRoot());
                    HeightDifferenceAdjustments(B, Change);
                    HeightDifferenceCorrection(B);
                    break;
                }
                else CurrentElement = (AVLElement) Predecessor(CurrentElement);
            }
        }
    }


}
