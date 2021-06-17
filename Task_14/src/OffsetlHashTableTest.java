import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class OffsetlHashTableTest extends Assertions{
    @Test
    public void Test(){
        OffsetHashTable HashTable = new OffsetHashTable_impl(16, 2);
        HashTable.Add(4,"ww");
        HashTable.Add(65,"wtw");
        HashTable.Add(11,"wqw");
        HashTable.Add(8,"wiw");
        HashTable.Add(24,"wpw");
        HashTable.Add(45,"wfw");
        HashTable.Delete(8);
        assertEquals(HashTable.GetValue(24),"wpw" );
        assertEquals(HashTable.GetValue(45),"wfw" );
    }





}
