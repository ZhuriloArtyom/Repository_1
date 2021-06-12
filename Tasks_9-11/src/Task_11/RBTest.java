package Task_11;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RBTest extends Assertions{

    @Test
    public void MinAndMaxTest(){
        RBTree Tree = new RBTree_impl(new RBTreeElement_impl("5"));
        Tree.Insert("45");
        Tree.Insert("22");
        Tree.Insert("1");
        Tree.Insert("0");
        Tree.Insert("53");
        Tree.Insert("777");
        Tree.Max();
        assertEquals(Tree.Max().GetData(),"777" );
        assertEquals(Tree.Min().GetData(),"0" );
    }
    @Test
    public void DeleteTest1(){
        RBTree Tree = new RBTree_impl(new RBTreeElement_impl("5"));
        Tree.Insert("33");
        Tree.Insert("22");
        Tree.Insert("1");
        Tree.Insert("2");
        Tree.Insert("0");
        Tree.Insert("24");
        Tree.Insert("53");
        Tree.Insert("777");
        Tree.Delete(Tree.Max());
        Tree.Delete(Tree.Min());
        assertEquals(Tree.Min().GetData(),"1" );
        assertEquals(Tree.Max().GetData(),"53" );

    }
}
