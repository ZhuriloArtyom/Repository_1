import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input the initial size of the array.");
        int[] Array = CreateArray(scanner.nextInt());
        while (true){
            System.out.println("Input directions. Options: 'create *', 'add * *', 'resize *', 'view *', 'exit'. '*' stands in for an integer.");

        }
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
