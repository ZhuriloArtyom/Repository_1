package Task_11;

import Task_9.BinarySearchTreeElement;
import Task_9.BinarySearchTree_impl;

public class RBTree_impl extends BinarySearchTree_impl implements RBTree{
    public  RBTreeElement dummy;
    public RBTree_impl(RBTreeElement Element) {
        dummy = new RBTreeElement_impl(null);
        dummy.TurnBlack();
        SetRoot(Element);
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
        if(Element.IsRed() && (Y).IsRed()) {
            if ((Y).IsRight())
            {
                RBTreeElement Z = (RBTreeElement) Y.GetRoot();
                RBTreeElement X = (RBTreeElement) Z.GetLeft();
                if((X).IsRed()){
                    Y.TurnBlack();
                    X.TurnBlack();
                    if(Z != InitialRoot) {Z.TurnRed();
                    ColourCorrection(Z);}
                }

            else if (!Element.IsRight()){
                RBTreeElement Er  = (RBTreeElement) Element.GetRight();
                Element.SetRoot(Z);
                Er.SetRoot(Y);
                Y.SetLeft(Er);
                Element.SetRight(Y);
                Y.SetRoot(Element);
                Z.SetRight(Element);
                ColourCorrection(Y);
                Er.SetIsRight(false);
                Element.SetIsRight(true);
                Y.SetIsRight(true);
            }
            else {
                        Y.TurnBlack();
                        Z.TurnRed();
                        if (Z== InitialRoot){
                            InitialRoot = Y;
                        }
                        if(Z.IsRight()){Z.GetRoot().SetRight(Y);}
                     else{Z.GetRoot().SetLeft(Y);}
                        RBTreeElement Yl  = (RBTreeElement) Y.GetLeft();
                        Z.SetRight(Yl);
                        Y.SetRoot(Z.GetRoot());
                        Yl.SetRoot(Z);
                        Z.SetRoot(Y);
                        Y.SetLeft(Z);
                        Yl.SetIsRight(true);
                        Z.SetIsRight(false);

                    }
                }
            else{
                RBTreeElement Z = (RBTreeElement) Y.GetRoot();
                RBTreeElement X = (RBTreeElement) Z.GetRight();
                if((X).IsRed()){
                    Y.TurnBlack();
                    X.TurnBlack();
                    if(Z != InitialRoot) {Z.TurnRed();
                        ColourCorrection(Z);}
                }

                else if (Element.IsRight()){
                    RBTreeElement El  = (RBTreeElement) Element.GetLeft();
                    Element.SetRoot(Z);
                    Y.SetRight(El);
                    El.SetRoot(Y);
                    Element.SetLeft(Y);
                    Y.SetRoot(Element);
                    Z.SetLeft(Element);
                    ColourCorrection(Y);
                    El.SetIsRight(true);
                    Element.SetIsRight(false);
                    Y.SetIsRight(false);
                }
                else {
                        Y.TurnBlack();
                        Z.TurnRed();
                        RBTreeElement Yr  = (RBTreeElement) Y.GetRight();
                        if (Z== InitialRoot){InitialRoot = Y;}
                        if(Z.IsRight()){Z.GetRoot().SetRight(Y);}
                        else{Z.GetRoot().SetLeft(Y);}
                        Z.SetLeft(Yr);
                        Yr.SetRoot(Z);
                        Y.SetRoot(Z.GetRoot());
                        Z.SetRoot(Y);
                        Y.SetRight(Z);

                        Yr.SetIsRight(false);
                        Z.SetIsRight(true);

                }



            }

        }
    DummyReset();
    }

    @Override
    public void ColourCorrection2(RBTreeElement Element) {
        if(Element.IsRight()) {
            RBTreeElement Y = (RBTreeElement) Element.GetRoot();
            RBTreeElement X = (RBTreeElement) Y.GetLeft();
            RBTreeElement Xl = (RBTreeElement) X.GetRight();
            RBTreeElement Xr = (RBTreeElement) X.GetLeft();
            if (X.IsRed()){
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
                X.TurnBlack();
                Y.TurnRed();
                X.SetIsRight(Y.IsRight());
                Xr.SetIsRight(false);
                Y.SetIsRight(true);
                ColourCorrection2(Element);
            }
            else{

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
                    Xr.SetIsRight(false);
                    X.SetIsRight(Y.IsRight());
                    Y.SetIsRight(true);
                }
                else if(Xr.IsRed()){
                    RBTreeElement Xrl = (RBTreeElement) Xr.GetLeft();
                    Xr.SetRoot(Y);
                    Y.SetLeft(Xr);
                    X.SetRoot(Xr);
                    Xrl.SetRoot(X);
                    X.SetRight(Xrl);
                    Xr.SetLeft(X);
                    Xr.TurnBlack();
                    X.TurnRed();
                    Xrl.SetIsRight(true);
                    X.SetIsRight(false);
                    Xr.SetIsRight(false);
                    ColourCorrection2(Element);
                }
            }
        }
        else {
            RBTreeElement Y = (RBTreeElement) Element.GetRoot();
            RBTreeElement X = (RBTreeElement) Y.GetRight();
            RBTreeElement Xl = (RBTreeElement) X.GetRight();
            RBTreeElement Xr = (RBTreeElement) X.GetLeft();
            if (X.IsRed()){
                if(Y.IsRight()){
                    Y.GetRoot().SetRight(X);
                }
                else {
                    Y.GetRoot().SetLeft(X);
                }
                X.SetRoot(Y.GetRoot());
                Y.SetRight(Xl);
                Xl.SetRoot(Y);
                X.SetLeft(Y);
                Y.SetRoot(X);
                X.TurnBlack();
                Y.TurnRed();
                X.SetIsRight(Y.IsRight());
                Xl.SetIsRight(true);
                Y.SetIsRight(false);
                ColourCorrection2(Element);
            }
            else{

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
                    Xl.SetIsRight(true);
                    X.SetIsRight(Y.IsRight());
                    Y.SetIsRight(false);
                }
                else if(Xl.IsRed()){
                    RBTreeElement Xlr = (RBTreeElement) Xr.GetRight();
                    Xr.SetRoot(Y);
                    Y.SetRight(Xl);
                    X.SetRoot(Xl);
                    Xlr.SetRoot(X);
                    X.SetLeft(Xlr);
                    Xl.SetRight(X);
                    Xr.TurnBlack();
                    X.TurnRed();
                    Xlr.SetIsRight(false);
                    Xl.SetIsRight(true);
                    X.SetIsRight(true);
                    ColourCorrection2(Element);
                }
            }
        }
        DummyReset();
    }

    @Override
    public void DummyReset() {
        dummy.SetRoot(null);
        dummy.SetLeft(null);
        dummy.SetRight(null);
    }

    @Override
    public void Insert(String Data) {
        RBTreeElement Element = (RBTreeElement) InitialRoot;
        RBTreeElement NewElement =  new RBTreeElement_impl(Data);
        while (true){
            if (Integer.parseInt(Data) >= Integer.parseInt(Element.GetData())){
                if (Element.GetRight() == dummy){
                    Element.SetRight(NewElement);
                    NewElement.SetRoot(Element);
                    break;
                }
                else Element = (RBTreeElement) Element.GetRight();
            }
            else{
                if (Element.GetLeft() == dummy){
                    Element.SetLeft(NewElement);
                    NewElement.SetRoot(Element);
                    break;
                }
                else Element = (RBTreeElement) Element.GetLeft();
            }
        }
        NewElement.SetIsRight(Element.GetRight()==NewElement);
        NewElement.SetRight(dummy);
        NewElement.SetLeft(dummy);
        ColourCorrection(NewElement);
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
            Ell2 = (RBTreeElement) CurrentElement.GetRight();
            while(CurrentElement.GetLeft()!= dummy){
                CurrentElement = (RBTreeElement) CurrentElement.GetLeft();
                Ell2 = (RBTreeElement) CurrentElement.GetRight();
            }
            if(CurrentElement!=Ell.GetRight()){
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
            Ell2 = (RBTreeElement) CurrentElement.GetLeft();
            while(CurrentElement.GetRight()!= dummy){
                CurrentElement = (RBTreeElement) CurrentElement.GetRight();
                Ell2 = (RBTreeElement) CurrentElement.GetLeft();
            }
            if(CurrentElement!=Ell.GetLeft()){
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
        CurrentElement.CopyColour(Ell);
        if(!CurrentElement.IsRed()){
            if(Ell2.IsRed()){
                Ell2.TurnBlack();
            }
            else{
                 DoubleBlack = Ell2;
            }
        }
        DummyReset();
    }
    else{
        if(Element.GetRight()!=dummy){
            Ell2 = (RBTreeElement) Ell.GetRight();
            if (Ell.IsRight()){Element.GetRoot().SetRight(Ell2);}
            else {Element.GetRoot().SetLeft(Ell2);}
            Ell2.SetIsRight(Ell.IsRight());
            if (!(Ell.IsRed())){

                if (Ell2.IsRed()){
                    Ell2.TurnBlack();
                }
                else{
                     DoubleBlack = Ell2;
                }
            }
        }
        else{
            Ell2 = (RBTreeElement) Ell.GetLeft();
            if (Ell.IsRight()){Element.GetRoot().SetRight(Ell2);}
            else {Element.GetRoot().SetLeft(Ell2);}
            Ell2.SetIsRight(Ell.IsRight());
            if (!(Ell.IsRed())){
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
    }}
    @Override
    public BinarySearchTreeElement IterationOfSearch(String Data, BinarySearchTreeElement Element) {
         if (Data.equals(Element.GetData())) {return Element;}
        else if (Integer.parseInt(Data) > Integer.parseInt(Element.GetData()) && Element.GetRight()!= dummy){return IterationOfSearch(Data,Element.GetRight());}
        else if (Integer.parseInt(Data) < Integer.parseInt(Element.GetData()) && Element.GetLeft()!= dummy){return IterationOfSearch(Data,Element.GetLeft());}
         else return null;
        }
    @Override
    public BinarySearchTreeElement Min() {
        BinarySearchTreeElement Element = InitialRoot;
        while (true){
            if (Element.GetLeft() == dummy){return Element;}
            Element = Element.GetLeft();
        }
    }

    @Override
    public BinarySearchTreeElement Max() {
        BinarySearchTreeElement Element = InitialRoot;
        while (true){
            if (Element.GetRight() == dummy){return Element;}
            Element = Element.GetRight();
        }    }
}
