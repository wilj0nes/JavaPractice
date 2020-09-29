package com.practice.amazon;

import java.util.*;

public class AmazonPractice {
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
