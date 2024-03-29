package com.practice.udemy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class UdemyPractice {

    // Given a number N return the index value of the Fibonacci sequence, where the sequence is:

    // 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144 ...
    //                   ^6
    // the pattern of the sequence is that each value is the sum of the 2 previous values, that means that for N=5 → 2+3

    // For example: fibonacciRecursive(6) should return 8

    public int fibonacciRecursive(int num) {                // O(2^n) exponential runtime
        System.out.println("fibonacciRecursive: " + num);
        if (num < 2) { //  base case
            return num;
        }
        return fibonacciRecursive(num - 1) + fibonacciRecursive(num - 2);
    }

    public String reverseStringRecursion(String str) {
        if (str.length() == 1) {
            return str;
        }

        return str.substring(str.length()-1) + reverseStringRecursion(str.substring(0, str.length()-1));
    }

    public void reverseLinkedList() {
        LinkedList<Integer> linkedList = new LinkedList<Integer>();
        linkedList.add(1);
        linkedList.add(10);
        linkedList.add(16);
        linkedList.add(88);

        System.out.println("LinkedList: " + linkedList);

        LinkedList<Integer> newLinkedList = new LinkedList<>();
        for (int i = linkedList.size() - 1; i >= 0; i--) {
            newLinkedList.add(linkedList.get(i));
        }
        System.out.println("reversed: " + newLinkedList);
    }

    // google question
    public static void findReoccurringNumber(int[] arr) {
        int foundInt = 0;
        HashMap<Integer, Integer> hashMap = new HashMap<>();

//              \/ original solution
        for (int i = 0; i < arr.length; i++) {
            if (hashMap.containsValue(arr[i])) {
                foundInt = arr[i];
                break;
            }
            hashMap.put(i, arr[i]);
        }

//              \/ better solution, because .containsValue() has O(n) run-time, so it's O(n^2)
        for (int i = 0; i < arr.length; i++) {
            if (hashMap.get(arr[i]) != null) {
                foundInt = arr[i];
                break;
            }
            else {
                hashMap.put(arr[i], i);
            }
        }

        System.out.println("--> " + foundInt);
    }

}
