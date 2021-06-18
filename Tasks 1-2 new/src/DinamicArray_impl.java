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

    @Override
    public int findFirst(int Value) {
        for(int i = 0; i< size; i++){
            if (Array[i]==Value){ return i;}
        }
        return -1;
    }

    @Override
    public int findLast(int Value) {
        for(int i = size -1 ; i>= 0; i--){
            if (Array[i]==Value){ return i;}
        }
        return -1;
    }

    @Override
    public void add(int Value) {
        Array[size-1] = Value;
    }

    @Override
    public void insert(int Index, int Value) {
        resize(size+1);
        for(int i = Index+1; i < size; i++ ){
            Array[i] = Array[i-1];
        }
        Array[Index] = Value;
    }

    @Override
    public void removed(int Index) {
        for(int i = Index+1; i < size; i++ ){
            Array[i-1] = Array[i];
        }
        resize(size-1);
    }

}
