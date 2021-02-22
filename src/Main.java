public class Main {
    public static void main(String[] args) {




    }
    private static int[] CreateArray(int length) {
        return new int[length];
    }
    private static int[] AddToArray(int index, int element, int[] Array) {
        Array[index] = element;
        return Array;
    }
    private static int[] ResizeArray(int length, int[] OldArray) {
        int[] NewArray = CreateArray(length);
        if (OldArray.length < length){
            for(int i = 0; i<length;i++){
                NewArray[i] = OldArray[i];
            }}
        else {
            for(int i = 0; i < OldArray.length;i++){
                NewArray[i] = OldArray[i];
            }
        }
        return NewArray;
    }
}
