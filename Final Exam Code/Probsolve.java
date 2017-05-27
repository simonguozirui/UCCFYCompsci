import java.util.Scanner;

public class Probsolve {

	public static int  myMethod (String input) {
		int count = 0;
        String firstChar = input.substring(0,1);
        for (int i = 0; i < input.length(); i++){
            if (input.substring(i,i+1).equals(firstChar)){
                count++;
           }
        }
        return count;
	}

	public static void main(String args[]) {
		Scanner myscan = new Scanner(System.in);
		System.out.println("Please enter an string value");
		String input = myscan.nextLine();

		/* if you have to get input into an array
			String[] a1 = new String[5]; 
			for (int i = 0; i < 6; i++) {
				System.out.println("Please enter an string value");
				String input = myscan.nextLine();
				a1[i] = input;
			}
		*/ 

		System.out.println(myMethod(input));
	}

}
