package impl;
import base.*;
import base.DoubleLinkedListElement_Interface;
import java.util.Scanner;

import java.lang.reflect.UndeclaredThrowableException;

public class DoubleLinkedList<T> implements DoubleLinkedList_Interface {
    int Size;
    private DoubleLinkedListElement_Interface Head;
    private DoubleLinkedListElement_Interface Tail;
    private DoubleLinkedListElement_Interface Dummy;

    @Override
    public void  CreateDummy() {
        Dummy = new DoubleLinkedListElement( Dummy, null, Dummy);
        Head = Dummy;
        Tail = Dummy;
    }

    @Override
    public DoubleLinkedList_Interface CreateList(int Size) {
        DoubleLinkedList_Interface List = new DoubleLinkedList();
        List.CreateDummy();
        DoubleLinkedListElement_Interface CurrentElement = Dummy;
        Scanner scanner = new Scanner(System.in);
        for(int i = 0; i<Size; i++){
            List.AddElement(scanner.next(), CurrentElement);
            CurrentElement = CurrentElement.GetNext();
        }
        return List;
    }

    @Override
    public DoubleLinkedListElement_Interface ReturnTail() {
        return Tail;
    }

    @Override
    public DoubleLinkedListElement_Interface ReturnHead() {
        return Head;
    }


    @Override
    public DoubleLinkedListElement_Interface ReturnNext(DoubleLinkedListElement_Interface CurrentElement) {
        return CurrentElement.GetNext();
    }

    @Override
    public DoubleLinkedListElement_Interface ReturnPrev(DoubleLinkedListElement_Interface CurrentElement) {
        return CurrentElement.GetPrevious();
    }

    @Override
    public void AddElement(Object Data, DoubleLinkedListElement_Interface CurrentElement) {
        DoubleLinkedListElement AddedElement = new DoubleLinkedListElement(CurrentElement, Data, CurrentElement.GetNext());
        CurrentElement.GetNext().ChangePrevious(AddedElement);
        CurrentElement.ChangeNext(AddedElement);
        if (AddedElement.GetNext() == Head){
            Head = AddedElement;
        }
        if (AddedElement.GetPrevious() == Tail){
            Tail = AddedElement;
        }
        Size++;
    }

    @Override
    public void DeleteElement(DoubleLinkedListElement_Interface CurrentElement) {
        CurrentElement.GetNext().ChangePrevious((DoubleLinkedListElement) CurrentElement.GetPrevious());
        CurrentElement.GetPrevious().ChangeNext((DoubleLinkedListElement) CurrentElement.GetNext());
        if (CurrentElement == Tail) {
            Tail = CurrentElement.GetPrevious();
        }
        if (CurrentElement == Head) {
            Head = CurrentElement.GetPrevious();
        }
        Size--;
    }

    @Override
    public DoubleLinkedListElement_Interface FindFromHead(int Steps) {
        if (Steps>Size){
            try {
                throw new Exception();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        DoubleLinkedListElement_Interface CurrentElement = Head;
        for (int i= 0; i < Steps; i++){
            CurrentElement = CurrentElement.GetNext();
        }
        return CurrentElement;
    }

    @Override
    public DoubleLinkedListElement_Interface FindFromTail(int Steps) {
        if (Steps>Size){
            try {
                throw new Exception();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        DoubleLinkedListElement_Interface CurrentElement = Tail;
        for (int i= 0; i < Steps; i++){
            CurrentElement = CurrentElement.GetPrevious();
        }
        return CurrentElement;
    }

    @Override
    public DoubleLinkedListElement_Interface FindFromHeadByData(Object InputData) {
        DoubleLinkedListElement_Interface CurrentElement = Head;
        for(int i= 0; i<Size; i++){
            if (CurrentElement.GetData() == InputData){return CurrentElement;}
            CurrentElement = CurrentElement.GetNext();
        }
        return null;
    }

    @Override
    public DoubleLinkedListElement_Interface FindFromTailByData(Object InputData) {

        DoubleLinkedListElement_Interface CurrentElement = Tail;
        for(int i= 0; i<Size; i++){
            if (CurrentElement.GetData() == InputData){return CurrentElement;}
            CurrentElement = CurrentElement.GetPrevious();
        }
        return null;
    }

    @Override
    public void ChangeData(DoubleLinkedListElement_Interface CurrentElement, Object NewData) {
        AddElement(NewData, CurrentElement);
        DeleteElement(CurrentElement);
    }

    @Override
    public int ReturnSize() {
        return Size;
    }

}
