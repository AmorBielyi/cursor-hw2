/*
This is my answer for the question from HW2: Why arrays in java initialize with fixed size and can't be dynamic?

In my opinion it's because size of the array is immutable (fixed) by the nature of the JVM.

In short just because we want to keep things simpler, but the full answer is:
when you create an array in java for instance,
the computer reserves five consecutive spaces in memory for the data to be contained in that array,
and when we want to resize array the data contained in it must be moved somewhere else in order for get array bigger.
That's a lot of ops that we don't want to deal with,
so JVM architects disallow array resizing to keep things simpler and invented ArrayList to deal with it.

In another side to compare with C++ it's because Java hasn't pointer that points to the memory allocated for the object and tracks its movement,
instead of this Java has mechanism that called "reference".

 */

package org.romanbielyi;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Main {

     private static void printArr(Integer[] arr){
        for (int i = 0; i < arr.length; i++)
            System.out.printf("arr[%d] %d\n", i, arr[i]);
    }

    private static int calcArrPositiveSum(Integer[] arr){
         int sum = 0;
         for(int elem : arr)
             if (elem > 0)
                 sum += elem;

         return sum;
    }

    private static float calcArrAvg(Integer[] arr){
         int sum = calcArrPositiveSum(arr);
         return  (float)sum / (float) arr.length;
    }

    private static void zeroesDuplicatedValues(Integer[] arr){
        Set<Integer> duplicated = new HashSet<>();

         for (int i = 0; i < arr.length; i++){
             if (duplicated.contains(arr[i]))
                 arr[i] = 0;
             else
                 duplicated.add(arr[i]);
         }
    }

    public static void main(String[] args) {
	    // Task 1
        System.out.println("*** Task 1 ***");

        Integer[] A = new Integer[]{2,3,1,7,11};

        System.out.println("Array before reverse order sort");
        printArr(A);

        System.out.println("Array after reverse order sort");
        Arrays.sort(A, Collections.reverseOrder());
        printArr(A);

        // Task 2
        System.out.println("*** Task 2 ***");

        Integer[] B = new Integer[]{-1,5,11,515,33,-12,6,9,0,-3,-600};
        System.out.println("Array with integers to sum");
        printArr(B);
        System.out.printf("Sum of all positive elements of it: %d\n", calcArrPositiveSum(B));

        // Task 3
        System.out.println("*** Task 3 ***");
        System.out.println("Array with integers to avg");
        printArr(A);
        System.out.printf("Average of array is: %f\n", calcArrAvg(A));

        // Task 4
        Integer[] C = new Integer[]{3,2,3,1,4,2,8,3};
        System.out.println("*** Task 4 ***");
        System.out.println("Array with integers to zeroes duplicated values");
        printArr(C);
        zeroesDuplicatedValues(C);
        System.out.println("Array after zeroes duplicated values");
        printArr(C);
    }
}
