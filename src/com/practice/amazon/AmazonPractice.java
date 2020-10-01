package com.practice.amazon;

import java.util.*;

public class AmazonPractice {


    public void callLengthEachScene() {
        ArrayList<Character> inputList;
        inputList = new ArrayList(Arrays.asList('a', 'b', 'a', 'b','c','b','a','c','a' ,'d','e','f','e','g','d','e','h','i','j','h','k','l','i','j'));
        List<Integer> result = lengthEachScene(inputList);
        result = lengthEachScene(Arrays.asList('a','b','c','d','a','e','f','g','h','i','j','e'));
        result = lengthEachScene(Arrays.asList('z','z','c','b','z','c','h','f','i','h','i'));
    }

    List<Integer> lengthEachScene(List<Character> inputList) {
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
        return resultList;
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
