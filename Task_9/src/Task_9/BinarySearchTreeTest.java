package Task_9;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BinarySearchTreeTest extends Assertions{
    @Test
    public void MinAndMaxTest(){
        BinarySearchTree Tree = new BinarySearchTree_impl();
        Tree.SetRoot(new BinarySearchTreeElement_impl("5"));
        Tree.Insert("45");
        Tree.Insert("22");
        Tree.Insert("1");
        Tree.Insert("0");
        Tree.Insert("53");
        Tree.Insert("777");
        assertEquals(Tree.Max().GetData(),"777" );
        assertEquals(Tree.Min().GetData(),"0" );
    }
    @Test
    public void DeleteTest1(){
        BinarySearchTree Tree = new BinarySearchTree_impl();
        Tree.SetRoot(new BinarySearchTreeElement_impl("5"));
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
        assertEquals(Tree.Max().GetData(),"53" );
        assertEquals(Tree.Min().GetData(),"1" );
    }
    @Test
    public void DeleteTest2(){
        BinarySearchTree Tree = new BinarySearchTree_impl();
        Tree.SetRoot(new BinarySearchTreeElement_impl("88"));
        Tree.Insert("66");
        Tree.Insert("50");
        Tree.Insert("78");
        Tree.Insert("40");
        Tree.Insert("57");
        Tree.Insert("72");
        Tree.Insert("80");
        Tree.Delete(Tree.Search("66"));
        assertEquals(Tree.GetInitialRoot().GetLeft().GetData(),"57" );
    }


    
}
