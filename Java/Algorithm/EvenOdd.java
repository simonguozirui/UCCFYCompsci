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
			System.out.println("Enter a value to store in element " + 1 + ": ");
			data[i] = myscan.nextInt();
		}
		System.out.println(Arrays.toString(evenOdd(data)));
	}

}
