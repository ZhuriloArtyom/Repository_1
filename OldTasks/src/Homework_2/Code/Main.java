package Homework_2.Code;

import kotlin.coroutines.Continuation;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner_1 = new Scanner(System.in);
        System.out.println("Input the initial size of the array.");
        int[] Array = CreateArray(scanner_1.nextInt());
        boolean Continuation = true;
        while (Continuation){
            Scanner scanner = new Scanner(System.in);
            System.out.println("Input directions. Options: 'create [Array length]', 'add [index] [number]', 'resize [length]', 'delete [index]' 'view [index]', 'exit'.");
            switch (scanner.next().charAt(0)) {
                case 'a' -> {
                    Array = AddToArray(scanner.nextInt(), scanner.nextInt(), Array);

                }
                case 'c' -> {
                    Array = CreateArray(scanner.nextInt());

                }
                case 'r' -> {
                    Array = ResizeArray(scanner.nextInt(), Array);

                }
                case 'v' -> {
                    System.out.println(Array[scanner.nextInt()]);
                }
                case 'e' -> {
                    Continuation = false;
                }
                case 'd' -> {
                    Array = RemoveFromArray(scanner.nextInt(), Array);
                }
            }
        }
    }
    public static int[] CreateArray(int length) {
        return new int[length];
    }
    public static int[] AddToArray(int index, int element, int[] Array) {
        int[] ProvisionalArray = new int[Array.length+1];
        if (Array.length - index >= 0)
            System.arraycopy(Array, index, ProvisionalArray, index + 1, Array.length - index);
        ProvisionalArray[index] = element;
        return ProvisionalArray;
    }
    public static int[] ResizeArray(int length, int[] OldArray) {
        int[] NewArray = CreateArray(length);
        if (OldArray.length < length){
            System.arraycopy(OldArray, 0, NewArray, 0, OldArray.length);
        }
        else {
            if (length >= 0) System.arraycopy(OldArray, 0, NewArray, 0, length);
        }
        return NewArray;
    }
    public static int[] RemoveFromArray(int index, int[] Array) {
        int[] ProvisionalArray = new int[Array.length-1];
        if (Array.length - 1 - index >= 0)
            System.arraycopy(Array, index + 1, ProvisionalArray, index, Array.length - 1 - index);
        return ProvisionalArray;
    }
}


