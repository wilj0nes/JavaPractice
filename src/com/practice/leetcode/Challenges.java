package com.practice.leetcode;

import java.math.BigInteger;
import java.util.*;

public class Challenges {

    public void callIsValid() {
        System.out.println("() --> " + isValid("()")); // true
        System.out.println(")) --> " + isValid("))")); // false
        System.out.println("()) --> " + isValid("())")); // false
        System.out.println("()[]{} --> " + isValid("()[]{}")); // true
        System.out.println("([)] --> " + isValid("([)]")); // false
        System.out.println("{ { ( { } ) } } --> " + isValid("{{({})}}")); // true
        System.out.println("[ --> " + isValid("[")); // false
    }

    // Given a string s containing just the characters '(', ')', '{', '}', '[' and ']',
    // determine if the input string is valid.
    public boolean isValid(String s) {
        if (s.length() <= 1) {
            return false;
        }
        if (s.startsWith(")") || s.startsWith("]") || s.startsWith("}") ||
            s.endsWith("(") || s.endsWith("[") || s.endsWith("{")) {

            return false;
        }
        if (!(s.length() % 2 == 0)) {
            return false;
        }

        String str = removeProperty(s);
//        System.out.println("Final String ====>  " + str);

        if (str.length() > 0) {
            return false;
        }
        return true;
    }

    public String removeProperty(String str) {
//        System.out.println("Calling... removeProperty: " + str);
        ArrayList<String> openerList = new ArrayList<>(Arrays.asList("(", "[", "{"));
        ArrayList<String> closerList = new ArrayList<>(Arrays.asList(")", "]", "}"));

        String[] arr = str.split("");

        for (int i = 0; i < arr.length-1; i++) {
            if (openerList.indexOf(arr[i]) == closerList.indexOf(arr[i+1]) && openerList.indexOf(arr[i]) > -1 && closerList.indexOf(arr[i+1]) > -1) {
                str = str.replace(arr[i]+arr[i+1], "");
//                System.out.println("str is now: " + str);
                return removeProperty(str);
            }
        }
        return str;
    }


    public void callReverseInteger() {
        long x;
        x = reverseInteger(123); // output: 321
        System.out.println("reversed int: " + x);

        x = reverseInteger(-123); // output: 321
        System.out.println("reversed int: " + x);

        // 9,646,324,351 --> 1,534,236,469
//        x = reverse(9646324351); // 9646324351 --> 1534236469

    }

    public int reverse(int x) {
        long reverseNum=0;
        do {
            long remainder = x % 10;
            x = x/10;
            reverseNum = reverseNum*10 + remainder;
        }
        while (x!=0);

        if (reverseNum >= Integer.MIN_VALUE && reverseNum <= Integer.MAX_VALUE) {
            return (int) reverseNum;
        }
        return 0;
    }


    // Given a 32-bit signed integer, reverse digits of an integer.
    public int reverseInteger(int x) {
        System.out.println("reverseInteger( " + x + " )");

        String str = String.valueOf(x);
        if (str.length() == 1) {
            return x;
        }

        char[] charArray = str.toCharArray();
        String newStr = "";

        for (int i = charArray.length - 1; i >= 0; i--) {
            newStr = newStr + ""+charArray[i];
        }

        if (newStr.contains("-")) {
            newStr = newStr.replaceAll("-", "");
            newStr = "-" + newStr;
        }

        return Integer.parseInt(newStr);
    }


    public void callLetterCombinations() { // not finished
        List<String> str;
        str = letterCombinations("23"); //Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"]
        System.out.println("answer: " + str);

        str = letterCombinations("234"); // ["adg","adh","adi","aeg","aeh","aei","afg","afh","afi","bdg","bdh","bdi","beg","beh","bei","bfg","bfh","bfi","cdg","cdh","cdi","ceg","ceh","cei","cfg","cfh","cfi"]
        System.out.println("answer: " + str);
    }

    //    Given a string containing digits from 2-9 inclusive,
    //    return all possible letter combinations that the number could represent.
    public List<String> letterCombinations(String digits) {
        System.out.println("Calling... letterCombinations( " + digits + " )");
        HashMap<Integer, ArrayList<String>> hashMap = new HashMap<>();
        hashMap.put(2, new ArrayList(Arrays.asList("a", "b", "c")));
        hashMap.put(3, new ArrayList(Arrays.asList("d", "e", "f")));
        hashMap.put(4, new ArrayList(Arrays.asList("g", "h","i")));
        hashMap.put(5, new ArrayList(Arrays.asList("j", "k","l")));
        hashMap.put(6, new ArrayList(Arrays.asList("m", "n", "o")));
        hashMap.put(7, new ArrayList(Arrays.asList("p", "q", "r", "s")));
        hashMap.put(8, new ArrayList(Arrays.asList("t", "u", "v")));
        hashMap.put(9, new ArrayList(Arrays.asList("w", "x", "y", "z")));

        ArrayList<String> firstLetterList = new ArrayList<>();
        ArrayList<String> answer = new ArrayList<>();

        if (digits == null || digits.equals("") || digits.equals(" ")) {
            return answer;
        }
        else if (digits.length() == 1) {
            return hashMap.get(Integer.parseInt(digits));
        }

        ArrayList<Integer> nums = new ArrayList<>();
        for (int i = 0; i < digits.length(); i++) {
            nums.add(Integer.parseInt(""+digits.charAt(i)));
        }

        firstLetterList.addAll(hashMap.get(nums.get(0)));
        nums.remove(nums.get(0));



        for (Integer i : nums) { // "2", "3"
            System.out.println(hashMap.get(i));
            for (String firstChar : firstLetterList) { // [a, b, c]

                for (String str : hashMap.get(i)) {
                    System.out.println(firstChar + " + " + str);
//                    answer.add(tempStr + str);

                    if (answer.size() > 0) {
                        answer.add(firstChar + str);

                        for (String ans : answer) {
                            if (!ans.contains(str) && ans.length() < digits.length()) {
                                System.out.println("ans : " + ans + " + " + str);
//                                answer.get(answer.indexOf(ans))
                                answer.set(answer.indexOf(ans), ans + str);
                            }
                            else {
                                // check "str" in each "ans"
//                                System.out.println(" -->" + firstChar + str);
//                                for ()
                            }
                        }

                    }
                    else {
                        answer.add(firstChar + str);
                    }
                    System.out.println(answer);

                }
            }
        }

        return answer;
    }

}
