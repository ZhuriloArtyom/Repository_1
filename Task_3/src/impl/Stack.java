package impl;

import base.DoubleLinkedList_Interface;
import base.Stack_Interface;

public class Stack implements Stack_Interface {
    boolean IsEmpty;
    DoubleLinkedList_Interface List;

    @Override
    public void CreateStack() {
        DoubleLinkedList_Interface EmptyStack = new DoubleLinkedList();
        List = EmptyStack.CreateList(0);
        IsEmpty = true;
    }

    @Override
    public void push(Object Data) {
        List.AddElement(Data, List.ReturnTail());
        if (IsEmpty){IsEmpty=false;}
    }

    @Override
    public Object pop() throws Exception {
        if(IsEmpty){
            Object Data = List.ReturnTail().GetData();
            List.DeleteElement(List.ReturnTail());
            if (List.ReturnTail() ==  List.GetDummy()){IsEmpty= true;}
            return Data;
        }
        else { throw new Exception();}

    }

    @Override
    public Object peek() {
        return List.ReturnTail().GetData();
    }
}
