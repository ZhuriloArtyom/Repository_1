package Task_1;
public class DinamicArray_impl implements DinamicArray{
    int[] Array;
    int size;
    public DinamicArray_impl(int size){
        this.size = size;
        this.Array = new int[size];
    }


    @Override
    public int get(int Index) {
        return Array[Index];
    }

    @Override
    public void set(int Index, int Value) {
        Array[Index] = Value;
    }

    @Override
    public void resize(int NewSize) {
        int[] NewArray = new int[NewSize];
        if(NewSize>size){
            for(int i = 0; i < size; i++){
                NewArray[i] = Array[i];
            }}
        else {for(int i = 0; i < NewSize; i++){
            NewArray[i] = Array[i];
        }}

        Array = NewArray;
        size = NewSize;
    }

    @Override
    public int Size() {
        return size;
    }
}
