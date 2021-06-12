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
    public void ColourCorrection2(RBTreeElement Element) {
        if(Element.IsRight()) {
            RBTreeElement Y = (RBTreeElement) Element.GetRoot();
            RBTreeElement X = (RBTreeElement) Y.GetLeft();
            if (X.IsRed()){
                if(Y.IsRight()){
                    Y.GetRoot().SetRight(X);
                }
                else {
                    Y.GetRoot().SetLeft(X);
                }
                X.SetRoot(Y.GetRoot());
                Y.SetLeft(X.GetRight());
                X.GetRight().SetRoot(Y);
                X.SetRight(Y);
                Y.SetRoot(X);
                X.TurnBlack();
                Y.TurnRed();
                ColourCorrection2(Element);
            }
            else{
                RBTreeElement Xl = (RBTreeElement) X.GetRight();
                RBTreeElement Xr = (RBTreeElement) X.GetLeft();
                if(!Xl.IsRed()&& !Xr.IsRed()){
                    X.TurnRed();
                    if(!Y.IsRed()&&Y!=InitialRoot){ColourCorrection2(Y);}
                    else{Y.TurnBlack();}
                }
                else if(Xl.IsRed()){
                    if(Y.IsRight()){
                        Y.GetRoot().SetRight(X);
                    }
                    else {
                        Y.GetRoot().SetLeft(X);
                    }
                    X.SetRoot(Y.GetRoot());
                    Y.SetLeft(Xr);
                    Xr.SetRoot(Y);
                    X.SetRight(Y);
                    Y.SetRoot(X);
                    X.CopyColour(Y);
                    Y.TurnBlack();
                    Xl.TurnBlack();
                }
                else if(Xr.IsRed()){
                    Xr.SetRoot(Y);
                    Y.SetLeft(Xr);
                    X.SetRoot(Xr);
                    Xr.GetLeft().SetRoot(X);
                    X.SetRight(Xr.GetLeft());
                    Xr.SetLeft(X);
                    Xr.TurnBlack();
                    X.TurnRed();
                    ColourCorrection2(Element);
                }
            }
        }
        else {
            RBTreeElement Y = (RBTreeElement) Element.GetRoot();
            RBTreeElement X = (RBTreeElement) Y.GetRight();
            if (X.IsRed()){
                if(Y.IsRight()){
                    Y.GetRoot().SetRight(X);
                }
                else {
                    Y.GetRoot().SetLeft(X);
                }
                X.SetRoot(Y.GetRoot());
                Y.SetRight(X.GetLeft());
                X.GetLeft().SetRoot(Y);
                X.SetLeft(Y);
                Y.SetRoot(X);
                X.TurnBlack();
                Y.TurnRed();
                ColourCorrection2(Element);
            }
            else{
                RBTreeElement Xl = (RBTreeElement) X.GetRight();
                RBTreeElement Xr = (RBTreeElement) X.GetLeft();
                if(!Xl.IsRed()&& !Xr.IsRed()){
                    X.TurnRed();
                    if(!Y.IsRed()&&Y!=InitialRoot){ColourCorrection2(Y);}
                    else{Y.TurnBlack();}
                }
                else if(Xr.IsRed()){
                    if(Y.IsRight()){
                        Y.GetRoot().SetLeft(X);
                    }
                    else {
                        Y.GetRoot().SetRight(X);
                    }
                    X.SetRoot(Y.GetRoot());
                    Y.SetRight(Xl);
                    Xl.SetRoot(Y);
                    X.SetLeft(Y);
                    Y.SetRoot(X);
                    X.CopyColour(Y);
                    Y.TurnBlack();
                    Xl.TurnBlack();
                }
                else if(Xl.IsRed()){
                    Xr.SetRoot(Y);
                    Y.SetRight(Xl);
                    X.SetRoot(Xl);
                    Xr.GetRight().SetRoot(X);
                    X.SetLeft(Xl.GetRight());
                    Xl.SetRight(X);
                    Xr.TurnBlack();
                    X.TurnRed();
                    ColourCorrection2(Element);
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
    @Override
    public void Delete(BinarySearchTreeElement Element){
    RBTreeElement Ell = (RBTreeElement) Element;
    RBTreeElement Ell2 = null;
    RBTreeElement DoubleBlack = null;
    if (Element.GetLeft() == dummy && Element.GetRight() ==dummy){
        if (Ell.IsRight()){Element.GetRoot().SetRight(dummy);}
        else {Element.GetRoot().SetLeft(dummy);}
        if (!(Ell.IsRed())){
            DoubleBlack = Ell;
        }
    }
    else if(Element.GetLeft() != dummy && Element.GetRight() !=dummy){
        RBTreeElement CurrentElement;
        if(Ell.IsRight()){
            CurrentElement = (RBTreeElement) Ell.GetRight();
            while(CurrentElement.GetLeft()!= dummy){
                CurrentElement = (RBTreeElement) CurrentElement.GetLeft();
            }
            if(CurrentElement!=Ell.GetRight()){
                Ell2 = (RBTreeElement) CurrentElement.GetRight();
                CurrentElement.GetRoot().SetLeft(Ell2);
                Ell2.SetRoot(CurrentElement.GetRoot());
                Ell.GetRight().SetRoot(CurrentElement);
                CurrentElement.SetRight(Ell.GetRight());
            }
            CurrentElement.SetRoot(Ell.GetRoot());
            CurrentElement.SetLeft(Ell.GetLeft());
            Ell.GetRoot().SetRight(CurrentElement);
            Ell.GetLeft().SetRoot(CurrentElement);

        }
        else{
            CurrentElement = (RBTreeElement) Ell.GetLeft();
            while(CurrentElement.GetRight()!= dummy){
                CurrentElement = (RBTreeElement) CurrentElement.GetRight();
            }
            if(CurrentElement!=Ell.GetLeft()){
                Ell2 = (RBTreeElement) CurrentElement.GetLeft();
                CurrentElement.GetRoot().SetLeft(Ell2);
                Ell2.SetRoot(CurrentElement.GetRoot());
                Ell.GetLeft().SetRoot(CurrentElement);
                CurrentElement.SetLeft(Ell.GetRight());
            }
            CurrentElement.SetRoot(Ell.GetRoot());
            CurrentElement.SetRight(Ell.GetRight());
            Ell.GetRoot().SetLeft(CurrentElement);
            Ell.GetRight().SetRoot(CurrentElement);
        }
        if(!CurrentElement.IsRed()){
            if(Ell2.IsRed()){
                Ell2.TurnRed();
            }
            else{
                 DoubleBlack = Ell2;
            }
        }
        CurrentElement.CopyColour(Ell);
    }
    else{
        if(Element.GetRight()!=dummy){
            if (Ell.IsRight()){Element.GetRoot().SetRight(Element.GetRight());}
            else {Element.GetRoot().SetLeft(Element.GetRight());}
            if (!(Ell.IsRed())){
                Ell2 = (RBTreeElement) Ell.GetRight();
                if (Ell2.IsRed()){
                    Ell2.TurnBlack();
                }
                else{
                     DoubleBlack = Ell2;
                }
            }
        }
        else{if (Ell.IsRight()){Element.GetRoot().SetRight(Element.GetLeft());}
        else {Element.GetRoot().SetLeft(Element.GetLeft());}
            if (!(Ell.IsRed())){
                Ell2 = (RBTreeElement) Ell.GetLeft();
                if (Ell2.IsRed()){
                    Ell2.TurnBlack();
                }
                else{
                     DoubleBlack = Ell2;
                }}
    }
    }
    if (DoubleBlack!=null){
        ColourCorrection2(DoubleBlack);
    }
}}
