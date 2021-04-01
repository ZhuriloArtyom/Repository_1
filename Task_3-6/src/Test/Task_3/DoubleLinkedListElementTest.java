package Test.Task_3;
import impl.Task_3.DoubleLinkedListElement;
import base.Task_3.DoubleLinkedListElement_Interface;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
public class DoubleLinkedListElementTest extends Assertions{
    @Test
    public void GetNext_Test(){
        DoubleLinkedListElement_Interface Element1 = new DoubleLinkedListElement(null, 98, null);
        DoubleLinkedListElement_Interface Element2 = new DoubleLinkedListElement(null, null, Element1);
        assertEquals(Element1, Element2.GetNext() );
    }
    @Test
    public void GetPrevious_Test(){
        DoubleLinkedListElement_Interface Element1 = new DoubleLinkedListElement(null, 98, null);
        DoubleLinkedListElement_Interface Element2 = new DoubleLinkedListElement(Element1, null, null);
        assertEquals(Element1, Element2.GetPrevious() );
    }
    @Test
    public void ChangeNext_Test(){
        DoubleLinkedListElement_Interface Element1 = new DoubleLinkedListElement(null, 98, null);
        DoubleLinkedListElement_Interface Element2 = new DoubleLinkedListElement(null, null, null);
        Element2.ChangeNext(Element1);
        assertEquals(Element1,Element2.GetNext());
    }
    @Test
    public void ChangePrevious_Test(){
        DoubleLinkedListElement_Interface Element1 = new DoubleLinkedListElement(null, 98, null);
        DoubleLinkedListElement_Interface Element2 = new DoubleLinkedListElement(null, null, null);
        Element2.ChangePrevious(Element1);
        assertEquals(Element1,Element2.GetPrevious());
    }
    @Test
    public void GetData_Test(){
        DoubleLinkedListElement_Interface Element1 = new DoubleLinkedListElement(null, 98, null);
        assertEquals(98 ,Element1.GetData());
    }
}
