package Task_10;

import Task_9.BinarySearchTree;
import Task_9.BinarySearchTreeElement_impl;
import Task_9.BinarySearchTree_impl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AVLETest extends Assertions{

    @Test
    public void MinAndMaxTest(){
        AVLTree Tree = new AVLTree_impl();
        Tree.SetRoot(new AVLElement_impl("5"));
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
        AVLTree Tree = new AVLTree_impl();
        Tree.SetRoot(new AVLElement_impl("5"));
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
        AVLTree Tree = new AVLTree_impl();
        Tree.SetRoot(new AVLElement_impl("5"));
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
