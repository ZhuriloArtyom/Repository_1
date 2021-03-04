package Test;
import base.DoubleLinkedListElement_Interface;
import impl.DoubleLinkedListElement;

import impl.DoubleLinkedList;
import base.DoubleLinkedList_Interface;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.lang.model.element.Element;
import java.io.ByteArrayInputStream;
import java.io.LineNumberInputStream;
import java.util.List;

public class DoubleLinkedListTest extends Assertions{



    @Test
    public void CreateListTest(){
        String data = "5" ;
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        DoubleLinkedList_Interface List = new DoubleLinkedList();
        List = List.CreateList(1);

        assertEquals(List.FindFromHead(1).GetData(), "5");
    }

}
