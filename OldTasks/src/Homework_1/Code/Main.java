package Homework_1.Code;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner_1 = new Scanner(System.in);
        System.out.println("Input the initial size of the array.");
        int[] Array = CreateArray(scanner_1.nextInt());
        boolean Continuation = true;
        while (Continuation){
            Scanner scanner = new Scanner(System.in);
            System.out.println("Input directions. Options: 'create [Array length]', 'add [index] [number]', 'resize [length]', 'view [index]', 'exit'.");
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
                }
            }
        }

    public static int[] CreateArray(int length) {
        return new int[length];
    }
    public static int[] AddToArray(int index, int element, int[] Array) {
        Array[index] = element;
        return Array;
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
}
