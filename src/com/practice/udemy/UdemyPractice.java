package com.practice.udemy;

import java.util.HashMap;
import java.util.LinkedList;

public class UdemyPractice {
    public void callFindReoccurringNumber() {
        int[] arr1 = new int[]{2,5,1,2,3,5,1,2,4}; // should return 2
        findReoccurringNumber(arr1);
        int[] arr2 = new int[]{2,1,1,2,3,5,1,2,4}; // should return 1
        findReoccurringNumber(arr2);
        int[] arr3 = new int[]{2,3,4,5}; // should return default
        findReoccurringNumber(arr3);
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
//        for (int i = 0; i < arr.length; i++) {
//            if (hashMap.containsValue(arr[i])) {
//                foundInt = arr[i];
//                break;
//            }
//            hashMap.put(i, arr[i]);
//        }

//              \/ better solution, because .containsValue() has O(n) run-time

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
