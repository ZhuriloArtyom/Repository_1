package Task_10;
import Task_9.BinarySearchTreeElement;
import Task_9.BinarySearchTree_impl;

public class AVLTree_impl extends BinarySearchTree_impl implements AVLTree{
    private BinarySearchTreeElement InitialRoot;

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
            return(T.GetHeight()>1);
        }
        else{AVLElement T = (AVLElement) Element.GetLeft();
            return(T.GetHeight()<1); }
    }

    @Override
    public void SimpleTurn(AVLElement Element) {
        if(Element.GetHeight()>0){
            AVLElement A = (AVLElement) Element.GetRight();
            if(Element.IsRight()){if(Element.GetRoot()!= null)Element.GetRoot().SetRight(A); }
            else{if(Element.GetRoot()!= null)Element.GetRoot().SetLeft(A);}
            A.SetRoot(Element.GetRoot());
            A.GetLeft().SetRoot(Element);
            Element.SetRight(A.GetLeft());
            A.SetLeft(Element);
            Element.SetRoot(A);
            A.GetRight().SetRoot(A);
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
            if (InitialRoot==Element){InitialRoot=A;}
        }
    }

    @Override
    public void ComplexTurn(AVLElement Element) {
        if(Element.GetHeight()>0){
            AVLElement A = (AVLElement) Element.GetRight();
            AVLElement B = (AVLElement) Element.GetRight().GetLeft();
            if(Element.IsRight()){if(Element.GetRoot()!= null) Element.GetRoot().SetRight(B); }
            else{ if(Element.GetRoot()!= null) Element.GetRoot().SetLeft(B);}
            B.SetRoot(Element.GetRoot());
            if(B.GetRight()!= null){B.GetRight().SetRoot(A);}
            A.SetLeft(B.GetRight());
            if(B.GetLeft()!= null){B.GetLeft().SetRoot(Element);}
            Element.SetRight(B.GetLeft());
            B.SetRight(Element);
            Element.SetRoot(B);
            B.SetLeft(A);
            A.SetRoot(B);
            if(A.GetLeft()!=null) A.GetLeft().SetRoot(A);
            if(Element.GetRight()!=null)Element.GetRight().SetRoot(Element);
            if (InitialRoot==Element){InitialRoot=A;}
        }
        else{
            {
                AVLElement A = (AVLElement) Element.GetLeft();
                AVLElement B = (AVLElement) Element.GetLeft().GetRight();
                if(Element.IsRight()){if(Element.GetRoot()!= null)Element.GetRoot().SetRight(B); }
                else{if(Element.GetRoot()!= null)Element.GetRoot().SetLeft(B);}
                B.SetRoot(Element.GetRoot());
                if(B.GetRight()!= null)B.GetRight().SetRoot(A);
                A.SetRight(B.GetLeft());
                if(B.GetLeft()!= null)B.GetLeft().SetRoot(Element);
                Element.SetLeft(B.GetRight());
                B.SetLeft(Element);
                Element.SetRoot(B);
                B.SetRight(A);
                A.SetRoot(B);
                if(A.GetRight()!= null)A.GetRight().SetRoot(A);
                if(Element.GetLeft()!= null)Element.GetLeft().SetRoot(Element);
                if (InitialRoot==Element){InitialRoot=A;}

            }
        }
    }

    @Override
    public void Delete(AVLElement Element) {
        if (Element.GetLeft() == null && Element.GetRight() == null){
            if (!Element.IsRight()){
                boolean Y = Element.IsRight();
                Element.GetRoot().SetLeft(null);
                HeightDifferenceAdjustments((AVLElement) Element.GetRoot(), true);
                HeightDifferenceCorrection((AVLElement) Element.GetRoot());
            }
            else {
                Element.GetRoot().SetRight(null);
                HeightDifferenceAdjustments((AVLElement) Element.GetRoot(), false);
                HeightDifferenceCorrection((AVLElement) Element.GetRoot());
            }

        }
        else if(Element.GetLeft() == null){
            if (Element.GetRoot().GetLeft() == Element){
                AVLElement A = (AVLElement)Element.GetRight();
                A.SetHeight(Element.GetHeight());
                Element.GetRoot().SetLeft(A);
                HeightDifferenceAdjustments(A, false);
                HeightDifferenceCorrection(A);
            }
            else {
                AVLElement A = (AVLElement)Element.GetRight();
                A.SetHeight(Element.GetHeight());
                Element.GetRoot().SetRight(A);
                HeightDifferenceAdjustments(A, false);
                HeightDifferenceCorrection(A);
            }
            Element.GetRight().SetRoot(Element.GetRoot());
        }
        else if(Element.GetRight() == null){
            if (Element.GetRoot().GetLeft() == Element){
                AVLElement A = (AVLElement)Element.GetLeft();
                A.SetHeight(Element.GetHeight());
                Element.GetRoot().SetLeft(A);
                HeightDifferenceAdjustments(A, true);
                HeightDifferenceCorrection(A);
            }
            else {
                AVLElement A = (AVLElement)Element.GetLeft();
                A.SetHeight(Element.GetHeight());
                Element.GetRoot().SetRight(A);
                HeightDifferenceAdjustments(A, true);
                HeightDifferenceCorrection(A);
            }
            Element.GetLeft().SetRoot(Element.GetRoot());
        }
        else{
            AVLElement CurrentElement = (AVLElement)Successor(Element);
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
                        Element.GetRight().SetRoot(CurrentElement);
                        Element.GetLeft().SetRoot(CurrentElement);
                        CurrentElement.SetLeft(Element.GetLeft());
                        CurrentElement.SetRight(Element.GetRight());
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
