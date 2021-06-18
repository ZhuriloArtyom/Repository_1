public interface DinamicArray {
    int get(int Index);
    void set(int Index, int Value);
    void resize(int NewSize);
    int Size();
    int findFirst(int Value);
    int findLast(int Value);
    void add(int Value);
    void insert(int Index, int Value);
    void removed(int Index);
}
