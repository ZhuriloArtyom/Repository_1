package Task_10;
import Task_9.BinarySearchTreeElement;
import Task_9.BinarySearchTree_impl;

public class AVLTree_impl extends BinarySearchTree_impl implements AVLTree{
    private BinarySearchTreeElement InitialRoot;

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
                    break;
                }
                else Element = Element.GetRight();
            }
            else{
                if (Element.GetLeft() == null){
                    NewElement.SetIsRight(false);
                    Element.SetLeft(NewElement);
                    Element.GetLeft().SetRoot(Element);
                    break;
                }
                else Element = Element.GetLeft();
            }
        }
        HeightDifferenceAdjustments((AVLElement) Element, true);
        HeightDifferenceCorrection((AVLElement) Element);
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
            if(Element.IsRight()){Element.GetRoot().SetRight(A); }
            else{Element.GetRoot().SetLeft(A);}
            A.SetRoot(Element.GetRoot());
            A.GetLeft().SetRoot(Element);
            Element.SetRight(A.GetLeft());
            A.SetLeft(Element);
            Element.SetRoot(A);
            A.GetRight().SetRoot(A);
        }
        else{
            AVLElement A = (AVLElement) Element.GetLeft();
            if(Element.IsRight()){Element.GetRoot().SetRight(A); }
            else{Element.GetRoot().SetLeft(A);}
            A.SetRoot(Element.GetRoot());
            A.GetRight().SetRoot(Element);
            Element.SetLeft(A.GetRight());
            A.SetRight(Element);
            Element.SetRoot(A);
            A.GetLeft().SetRoot(A);
        }
    }

    @Override
    public void ComplexTurn(AVLElement Element) {
        if(Element.GetHeight()>0){
            AVLElement A = (AVLElement) Element.GetRight();
            AVLElement B = (AVLElement) Element.GetRight().GetLeft();
            if(Element.IsRight()){Element.GetRoot().SetRight(B); }
            else{Element.GetRoot().SetLeft(B);}
            B.SetRoot(Element.GetRoot());
            B.GetLeft().SetRoot(A);
            A.SetRight(B.GetLeft());
            B.GetRight().SetRoot(Element);
            Element.SetLeft(B.GetRight());
            B.SetRight(Element);
            Element.SetRoot(B);
            B.SetLeft(A);
            A.SetRoot(B);
            A.GetLeft().SetRoot(A);
            Element.GetRight().SetRoot(Element);
        }
        else{
            {
                AVLElement A = (AVLElement) Element.GetLeft();
                AVLElement B = (AVLElement) Element.GetLeft().GetRight();
                if(Element.IsRight()){Element.GetRoot().SetRight(B); }
                else{Element.GetRoot().SetLeft(B);}
                B.SetRoot(Element.GetRoot());
                B.GetRight().SetRoot(A);
                A.SetLeft(B.GetRight());
                B.GetLeft().SetRoot(Element);
                Element.SetRight(B.GetLeft());
                B.SetLeft(Element);
                Element.SetRoot(B);
                B.SetRight(A);
                A.SetRoot(B);
                A.GetRight().SetRoot(A);
                Element.GetLeft().SetRoot(Element);
            }
        }
    }


}
