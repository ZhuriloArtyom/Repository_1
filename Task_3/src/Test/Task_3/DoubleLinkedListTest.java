package Test.Task_3;
import base.Task_3.DoubleLinkedListElement_Interface;
import impl.Task_3.DoubleLinkedListElement;

import impl.Task_3.DoubleLinkedList;
import base.Task_3.DoubleLinkedList_Interface;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;


public class DoubleLinkedListTest extends Assertions{



    @Test
    public void CreateListTest(){
        String data = "5" ;
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        DoubleLinkedList_Interface List = new DoubleLinkedList();
        List = List.CreateList(1);

        assertEquals(List.FindFromHead(1).GetData(), "5");
    }
    @Test
    public void FindByDataTest() {
        DoubleLinkedList_Interface List_1 = new DoubleLinkedList();
        List_1 = List_1.CreateList(0);
        List_1.AddElement(7, List_1.ReturnHead());
        List_1.AddElement(8, List_1.ReturnTail());
        List_1.AddElement(7, List_1.ReturnTail());
        DoubleLinkedListElement_Interface Element = new DoubleLinkedListElement<>(List_1.ReturnHead(), 8, List_1.ReturnTail());
        assertEquals(List_1.FindFromHeadByData(8).GetData(), Element.GetData());
        assertEquals(List_1.FindFromHeadByData(8).GetNext(), Element.GetNext());
        assertEquals(List_1.FindFromHeadByData(8).GetPrevious(), Element.GetPrevious());
        DoubleLinkedList_Interface List_2 = new DoubleLinkedList();
        List_2 = List_2.CreateList(0);
        List_2.AddElement(7, List_2.ReturnHead());
        List_2.AddElement(8, List_2.ReturnTail());
        List_2.AddElement(7, List_2.ReturnTail());
        DoubleLinkedListElement_Interface Element_2 = new DoubleLinkedListElement<>(List_2.ReturnHead(), 8, List_2.ReturnTail());
        assertEquals(List_2.FindFromTailByData(8).GetData(), Element_2.GetData());
        assertEquals(List_2.FindFromTailByData(8).GetNext(), Element_2.GetNext());
        assertEquals(List_2.FindFromTailByData(8).GetPrevious(), Element_2.GetPrevious());
    }
    @Test
    public void ChangeDataTest() {
        DoubleLinkedList_Interface List_1 = new DoubleLinkedList();
        List_1 = List_1.CreateList(0);
        List_1.AddElement(7, List_1.ReturnHead());
        List_1.AddElement(8, List_1.ReturnTail());
        List_1.AddElement(7, List_1.ReturnTail());
        List_1.ChangeData(List_1.FindFromTail(1), 9);
        assertEquals(List_1.FindFromTail(1).GetData(), 9);
    }
}
