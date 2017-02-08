/*
http://codingbat.com/prob/p105771

Return an array that contains the exact same numbers as the given array, 
but rearranged so that all the even numbers come before all the odd numbers. 
Other than that, the numbers can be in any order. 
You may modify and return the given array, 
or make a new array.

evenOdd([1, 0, 1, 0, 0, 1, 1]) → [0, 0, 0, 1, 1, 1, 1]
evenOdd([3, 3, 2]) → [2, 3, 3]
evenOdd([2, 2, 2]) → [2, 2, 2]

*/

import java.util.Scanner;
import java.util.Arrays;

public class EvenOdd{
	public static int[] evenOdd(int[] nums){
		int [] newarray = new int[nums.length];
		int evencount = 0;
		int oddcount = nums.length -1;
		for (int i = 0; i < nums.length; i++){
			if (nums[i]%2 == 0){
				newarray[evencount] = nums[i];
				evencount = evencount + 1;
			}else{
				newarray[oddcount] = nums[i];
				oddcount = oddcount -1;
			}		

		}	

		return newarray;
	}	 

	
	public static void main(String[] args){
		Scanner myscan = new Scanner(System.in);
		System.out.println("How many elements should be in the array?: ");
		int numElements = myscan.nextInt();
		int[] data = new int[numElements];
		for (int i = 0; i < numElements; i ++){
			System.out.println("Enter a value to store in element " + i + ": ");
			data[i] = myscan.nextInt();
		}
		System.out.println(Arrays.toString(evenOdd(data)));
	}

}
