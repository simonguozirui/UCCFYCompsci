import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

//search for "TTATT" DNA sequence


public class Salmonella {
	public static boolean findpattern(String pattern, Scanner scanner){
		boolean returnValue = false;
		while (scanner.hasNext()){
			if(scanner.nextLine().indexOf(pattern) > -1){
				returnValue = true;
			}
		}
		return returnValue;
	}

	public static void main(String[] args) {
		final long startTime = System.currentTimeMillis();
		try{
			Scanner myscan = new Scanner(new File("data/salmonella-test.txt"));
			boolean result = findpattern("TTATT",myscan);
			System.out.println(result);
		} catch(FileNotFoundException e){
			System.out.println("Bioformatics data not avaliable");
		}
		final long endTime = System.currentTimeMillis();
		System.out.println("Total execution time: " + (endTime - startTime) + " ms");
	}
}
