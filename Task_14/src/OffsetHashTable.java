public interface OffsetHashTable {
    void Add(int key, String value);
    String GetValue(int key);
    void Delete(int key);
}
