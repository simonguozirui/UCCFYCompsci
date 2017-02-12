/**
*ZeroFront.java - rearrange an array with zeros at the start of the array
*@author - Simon Guo
*@since - Feb 10, 2017
*@version - 1.0
*Sample Output:
*[1,0,0,1] --> [0,0,1,1]
*[0,1,1,0,1] --> [0,0,1,1,1] 
*[1,0] --> [0,1]
*/
//import Arrays and Scanner library
import java.util.Arrays;
import java.util.Scanner;

public class ZeroFront{
    /**
    *zerofront - Rearrange the given int array with zeros at the start of the array
    *@param - nums - int array imported from the user
    *returns a int array
    */
    public static int[] zeroFront(int[] nums){
        //create a new array for returning with the same length of the input array
        int[] result = new int[nums.length];
        //set counter for zero, starting from the front of the array
        int zerocount = 0;
        //set counter for other ints, starting from the end of the array
        int othercount = result.length - 1;
        //for loop loops through individual elements of the array
        for (int i = 0; i < nums.length; i ++){
            //if the element is 0, put it in the front of the result array
            if (nums[i] == 0){
                result[zerocount] = nums[i];
                zerocount ++; //counter + 1 for the next zero element
            }//if the element is not 0, put it in the back of the result array
            else{
                result[othercount] = nums[i];
                othercount --;//counter - 1 for the next non zero element
            }
        }
        //return resultant array
        return result;
    }

    //main method
    public static void main(String[] args){
        //start scanner
        Scanner myscan = new Scanner(System.in);
        //user interface
        //ask user for the size of the array to create a new input array
        System.out.println("How many elements do you want your array to have? ");
        int[] inputarr  = new int[myscan.nextInt()]; //create input array
        //for loop loops through every element of the array
        for (int i = 0; i < inputarr.length; i ++){
            //let user set value for each element
            System.out.println("set value for element "+ i + ": ");
            inputarr[i] = myscan.nextInt();
        }
        System.out.print("The result is: ");
        //print the result, by putting user input into the method's param
        //use Arrays.toString() to convert the int array to String
        System.out.println(Arrays.toString(zeroFront(inputarr)));
    }
}
