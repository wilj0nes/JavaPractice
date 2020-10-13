package com.practice;// IMPORT LIBRARY PACKAGES NEEDED BY YOUR PROGRAM
import java.util.ArrayList;
import java.util.List;
// SOME CLASSES WITHIN A PACKAGE MAY BE RESTRICTED
// DEFINE ANY CLASS AND METHOD NEEDED
// CLASS BEGINS, THIS CLASS IS REQUIRED
public class Stuff
{
    public static List<Integer> cellCompete(int[] states, int days) {
        List<Integer> newStates = new ArrayList<>(states.length);

        for (int i = 0; i < states.length; i++) {

            if (i == 0 && states[1] == 0) {
                //newStates[i] = 0;
                newStates.add(i, 0);
            }
            else if (i == 0 && states[1] == 1) {
                //newStates[i] = 1;
                newStates.add(i, 1);
            }
            else if (states[i-1] == states[i+1]) {
                //newStates[i] = 0;
                newStates.add(i, 0);
            }
            else if (states[i-1] != states[i+1]) {
                //newStates[1] =1;
                newStates.add(i, 1);
            }
            else if (i == states.length-1 && states[i-1] == 0) {
                //newStates[i] = 0;
                newStates.add(i, 0);
            }
            else if (i == states.length-1 && states[i-1] == 1) {
                //newStates[i] = 1;
                newStates.add(i, 1);
            }

        }
        return newStates;



    }
    // METHOD SIGNATURE ENDS

    public static void testCellComplete() {
        int[] intArray = new int[]{1,0,0,0,0,1,0,0};
        System.out.println(cellCompete(intArray, 1));
        int[] intArray1 = new int[]{1,1,1,0,1,1,1,1};
        System.out.println(cellCompete(intArray1, 2));
    }
}
