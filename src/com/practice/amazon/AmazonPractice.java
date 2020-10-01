package com.practice.amazon;

import java.util.*;

public class AmazonPractice {


    public void callLengthEachScene() {
        lengthEachScene(Arrays.asList('a', 'b', 'a', 'b','c','b','a','c','a' ,'d','e','f','e','g','d','e','h','i','j','h','k','l','i','j'));
        lengthEachScene(Arrays.asList('a','b','c','d','a','e','f','g','h','i','j','e'));
        lengthEachScene(Arrays.asList('z','z','c','b','z','c','h','f','i','h','i'));
    }

    public void lengthEachScene(List<Character> inputList) {
        List<Integer> resultList = new ArrayList<>();
        List<Character> temp = new ArrayList<>(); // ArrayList preserves insertion order

        for (int i = 0; i < inputList.size(); i++) {
            List<Character> subList = inputList.subList(i+1, inputList.size());
            System.out.println(subList);
            System.out.println("temp: " + temp + " ==> " + inputList.get(i) + " : " + i);

            if (!temp.contains(inputList.get(i))) {
                temp.add(inputList.get(i));
            }
            else if (temp.contains(inputList.get(i))) {
                boolean found = false;
                for (Character c: temp) {            // nested for loop -->  O(n^2)
                    if (subList.contains(c)) {
                        found = true;
                        break;
                    }
                }

                temp.add(inputList.get(i));
                if (!found) {
                    resultList.add(temp.size());
                    System.out.println(inputList.get(i) + " : " + i + " ==> Adding " + temp.size() + " to resultList");
                    temp.clear();
                }
            }

        }
        System.out.println("resultList: " + resultList);
    }

    public void callGeneralizedGCD() {
        int n;
        n = generalizedGCD(5, new int[]{2,3,4,5,6});
        System.out.println("answer: " + n);
        n = generalizedGCD(5, new int[]{2,4,6,8,10}); // should return 2
        System.out.println("answer: " + n);
    }

    // the greatest common divisor (GCD) is also called highest common factor of N numbers is
    // the largest positive integer that divides all number without giving a remainder
    // write an algorithm to determine the GCD of N positive integers
    public int generalizedGCD(int num, int[] arr) {
        if (arr == null) {
            return 1;
        }

        int dividend = 1;
        int[] tempArr = new int[num];

        while (true) {
            for (int i = 0; i < num; i++) {
                System.out.println(arr[i] + " > " + arr[i] % dividend);
                tempArr[i] = arr[i] % dividend;
            }
            for (int i = 0; i < num; i++){
                if (tempArr[i] != 0) {
                    dividend--;
                    return dividend;
                }
            }
            dividend++;
        }
    }


    List<PairInt> closestLocations(int totalCrates, List<PairInt> allLocations, int truckCapacity) {

        List<PairInt> result = new ArrayList<>();
        TreeMap<Double, PairInt> treeMap = new TreeMap<>(); // TreeMap keys are sorted by default

        for (PairInt pairInt : allLocations) {
            System.out.println("--> " + findDistance(pairInt.first, pairInt.second));
            treeMap.put(findDistance(pairInt.first, pairInt.second), pairInt);
        }

        for (Map.Entry<Double, PairInt> entry: treeMap.entrySet()) {
            if (result.size() < truckCapacity) {
                result.add(entry.getValue());                   // O(logn)
            }
        }


        return result;
    }

    public double findDistance(int x, int y) {
        return Math.sqrt(x*x + y*y);
    }

    public void testClosestLocations() {
        List<PairInt> pairIntList = new ArrayList<>();
        pairIntList.add(new PairInt(1, 2));
        pairIntList.add(new PairInt(3, 4));
        pairIntList.add(new PairInt(1, -1));

        System.out.println("Final result: " + closestLocations(3, pairIntList, 2).toString());

        pairIntList.clear();
        pairIntList.add(new PairInt(1, -3));
        pairIntList.add(new PairInt(1, 2));
        pairIntList.add(new PairInt(3, 4));

        System.out.println("Final result: " + closestLocations(3, pairIntList, 1).toString());

        pairIntList.clear();
        pairIntList.add(new PairInt(3, 6));
        pairIntList.add(new PairInt(2, 4));
        pairIntList.add(new PairInt(5, 3));
        pairIntList.add(new PairInt(2, 7));
        pairIntList.add(new PairInt(1, 8));
        pairIntList.add(new PairInt(7, 9));
        System.out.println("Final result: " + closestLocations(6, pairIntList, 3).toString());
    }
}

class PairInt {
    int first, second;
    PairInt(){};
    PairInt (int first, int second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public String toString() {
        return "{" + first + ", " + second +'}';
    }
}
