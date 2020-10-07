package com.practice;

import com.practice.amazon.AmazonPractice;
import com.practice.leetcode.Challenges;
import com.practice.other.Other;
import com.practice.udemy.UdemyPractice;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        AmazonPractice amazonPractice = new AmazonPractice();
        UdemyPractice udemyPractice = new UdemyPractice();
        Other other = new Other();
        Challenges challenges = new Challenges();

//        amazonPractice.testClosestLocations();
//        udemyPractice.callFindReoccurringNumber();
//        udemyPractice.reverseLinkedList();
//        int n = udemyPractice.fibonacciRecursive(6);
//        System.out.println("result: " + n);
//        String str = udemyPractice.reverseStringRecursion("yoyo mastery");
//        System.out.println("yoyo mastery --> " + str);*/

//        amazonPractice.callLengthEachScene();
//        amazonPractice.callGeneralizedGCD();

//        other.callLengthOfLongestSubstring();


//        challenges.callLetterCombinations();
//        challenges.callReverseInteger();
//        challenges.callIsValid();
//        challenges.callLengthOfLastWord();

        challenges.callMajorityElement();

    }



}
