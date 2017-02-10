/**
*<a>http://codingbat.com/prob/p186672</a>
*@author -  Simon Guo
*@since - Feb 9, 2017
*@version - 1.0
*Given an array of ints, return true if every element is a 1 or a 4.
*Sample input:
*only14([1, 4, 1, 4]) → true
*only14([1, 4, 2, 4]) → false
*only14([1, 1]) → true
*/

import java.util.Scanner;
public class Only14{
    /**
    *return true if arrays only contain 1 and 4
    *@param - nums - int array from input
    */
    public static boolean only14(int[] nums){
        boolean flag = true;//create a flag
        for (int i = 0; i < nums.length; i ++){
            if (nums[i] != 1 && nums[i] != 4) flag = false;
        }
        return flag;
    }
    public static void main (String[] args){
        Scanner myscan = new Scanner(System.in);
        System.out.println("Type in the length of your array: ");
        int[] input = new int[myscan.nextInt()];
        for (int i = 0; i < input.length; i ++){
            System.out.println("Type in value for element " + i);
            input[i] = myscan.nextInt();
        }
        System.out.println("The result is: "+ only14(input));
   }


}
