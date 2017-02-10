/**
*<a>http://codingbat.com/prob/p196976</a>
*@author -  Simon Guo
*@since - Feb 9, 2017
*@version - 1.0
*Return a version of the given array where all the 10's have been removed. The
*remaining elements should shift left towards the start of the array as needed,
*and the empty spaces a the end of the array should be 0. So {1, 10, 10, 2}
*yields {1, 2, 0, 0}. You may modify and return the given array or make a new
*array.
*
*withoutTen([1, 10, 10, 2]) → [1, 2, 0, 0]
*withoutTen([10, 2, 10]) → [2, 0, 0]
*withoutTen([1, 99, 10]) → [1, 99, 0]
*/

import java.util.Scanner;
import java.util.Arrays;
public class WithoutTen{
    /**
    *remove 10 from the input and move elemnts left
    *@param - nums - int array from input
    */
    public static int[] withoutTen(int[] nums){
        int[] result = new int[nums.length];
        int counter = 0;
        for (int i = 0; i < nums.length; i ++){
            if (nums[i] != 10){
                result[counter] = nums[i];
                counter ++;
            }
        }
        return result;
    }
    public static void main (String[] args){
        Scanner myscan = new Scanner(System.in);
        System.out.println("Type in the length of your array: ");
        int[] input = new int[myscan.nextInt()];
        for (int i = 0; i < input.length; i ++){
            System.out.println("Type in value for element " + i);
            input[i] = myscan.nextInt();
        }
        System.out.println("The result is: "+ Arrays.toString(withoutTen(input)));
   }


}
