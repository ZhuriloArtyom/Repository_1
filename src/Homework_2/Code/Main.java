package Homework_2.Code;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input the initial size of the array.");
        int[] Array = CreateArray(scanner.nextInt());
        while (true){
            System.out.println("Input directions. Options: 'create [Array length]', 'add [index] [number]', 'resize [length]', 'view [index]', 'exit'.");
            switch (scanner.next().charAt(1)){
                case 'a':{
                    Array =  AddToArray(scanner.nextInt(), scanner.nextInt(), Array);
                }
                case 'c':{
                    Array = CreateArray(scanner.nextInt());
                }
                case 'r':{
                    Array = ResizeArray(scanner.nextInt(), Array);

                }
                case 'v':{
                    System.out.println(Array[scanner.nextInt()]);
                }
                case 'e':{
                    break;
                }
            }
        }
    }
    public static int[] CreateArray(int length) {
        return new int[length];
    }
    public static int[] AddToArray(int index, int element, int[] Array) {
        int[] ProvisionalArray = new int[Array.length+1];
        for(int i = index; i < Array.length; i++){
            ProvisionalArray[i+1] = Array[i];
        }
        ProvisionalArray[index] = element;
        return ProvisionalArray;
    }
    public static int[] ResizeArray(int length, int[] OldArray) {
        int[] NewArray = CreateArray(length);
        if (OldArray.length < length){
            for(int i = 0; i< OldArray.length;i++){
                NewArray[i] = OldArray[i];
            }}
        else {
            for(int i = 0; i < length;i++){
                NewArray[i] = OldArray[i];
            }
        }
        return NewArray;
    }
}


