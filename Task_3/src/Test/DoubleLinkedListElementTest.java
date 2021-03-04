package Test;
import impl.DoubleLinkedListElement;
import base.DoubleLinkedListElement_Interface;
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
}
