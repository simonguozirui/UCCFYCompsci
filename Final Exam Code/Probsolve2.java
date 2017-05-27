import java.util.Scanner;

public class Probsolve2 {

	public static String  myMethod (int[] input) {
	    int sum = 0;
        String returnstr = "";
        for (int i = 0; i < input.length; i ++){
            if (input[i]%2 == 0){
                sum = sum+input[i];
            }else{
                sum = sum-input[i];
            }
        }
        if (sum > 0){
            returnstr = "Even";
        }else if (sum < 0){
            returnstr = "Odd";
        }
        return returnstr;
	}

	public static void main(String args[]) {
		Scanner myscan = new Scanner(System.in);
		//System.out.println("Please enter an string value");
		//String input = myscan.nextLine();

		//if you have to get input into an array
			int[] a1 = new int[5]; 
			for (int i = 0; i < 5; i++) {
				System.out.println("Please enter an int value");
				int input = myscan.nextInt();
				a1[i] = input;
			}
		 

		System.out.println(myMethod(a1));
	}

}
