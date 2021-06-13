import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ListHashTableTest extends Assertions{
    @Test
    public void Test(){
        ListHashTable HashTable = new ListHashTable_impl(7);
        HashTable.Add(4,"ww");
        HashTable.Add(5,"wtw");
        HashTable.Add(11,"wqw");
        HashTable.Add(8,"wiw");
        HashTable.Add(23,"wpw");
        HashTable.Add(45,"wfw");
        assertEquals(HashTable.GetValue(11),"wqw" );
        assertEquals(HashTable.GetValue(45),"wfw" );
    }


    


}
