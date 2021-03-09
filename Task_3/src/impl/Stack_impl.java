package impl;

import base.DoubleLinkedList_Interface;
import base.Stack;

public class Stack_impl<T> implements Stack {
    DoubleLinkedList_Interface List;
    boolean IsEmpty;

    @Override
    public void CreateStack() {
        List = List.CreateList(0);
        IsEmpty = true;
    }

    @Override
    public void Push(Object Data) {
        if (IsEmpty){IsEmpty = false;}
        List.AddElement(Data, List.ReturnTail());
    }

    @Override
    public Object Pop() {
        if(IsEmpty){
            try {
                throw new Exception();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }
        else {
            Object Data = List.ReturnTail().GetData();
            List.DeleteElement(List.ReturnTail());
            if (List.ReturnTail() == List.ReturnDummy()){IsEmpty = true;}
            return Data;
        }
    }

    @Override
    public Object Peek() {
        return List.ReturnTail().GetData();
    }
}
