//import libraries
import java.util.Scanner;
import java.io.PrintWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.lang.*;

/**
*DNAReverse.java - access a DNA sequence from the database, complement it and reverse it, output result into a txt file
*@author - Simon Guo
*@since - Feb 20, 2017
*@version - 1.0
*Download a sample DNA sequence at <a>ftp://ftp.ncbi.nlm.nih.gov/genomes/Bacteria/Salmonella_enterica_serovar_Typhimur ium_LT2_uid57799/NC_003197.fna</a>
*Description of the Program:
*a. Reads in the DNA file
*b. Complement each letter (conditionals) – ex. A<->G C<->G
*c. Reverse the letters of each line
*d. Write out the reverse complement file
*e. Code should be efficient (e.g., no memory leaks)
*f. Employ good coding practices throughout
*g. Add a timer to your program to print out processing time
*h. Your output file should be 69393 lines with 4926947 characters
*you can check your result with this website <a>http://arep.med.harvard.edu/labgc/adnan/projects/Utilities/revcomp.html</a>
*/
public class DNAReverse {
	/**
	*reverse - access salmonella's DNA from the database, complement it and reverse it, store the result in an arraylist
	*@param - scanner - Scanner that scans the txt file
	*/
	public static ArrayList<String> reverse (Scanner scanner){
		//create a arraylist to store all the complemented and reversed data
		//use arraylist because the number of lines of data is unknown
		ArrayList<String> data = new ArrayList<String>(); 
		String header = ""; //create a string variable for header
		String resultString = ""; //create a string variable to store static element value of the result array
		while (scanner.hasNext()){
			//use Stringbuilder class to create a variable that store the static value of one line
			StringBuilder currentString = new StringBuilder(scanner.nextLine());
			//use indexof method to check if the line is header, header starts with "<"
			if(currentString.indexOf(">") == 0){ 
				//use toString() method turn StringBuilder class element into String
				header = currentString.toString();
				//add header to the resultand array list
				data.add(header);
			}else{
				//use .reverse() method under StringBuilder class to reverse the line
				currentString.reverse();
				//loop through individual character in the line
				for (int i = 0; i < currentString.length(); i ++){
					/*
					use substring to compare each character
					append resultString with complemented character
					A <-> T, C <-> G
					*/
					if (currentString.substring(i,i+1).equals("A")){
						resultString += "T";
					}else if (currentString.substring(i,i+1).equals("T")){
						resultString += "A";
					}else if (currentString.substring(i,i+1).equals("C")){
						resultString += "G";
					}else if (currentString.substring(i,i+1).equals("G")){
						resultString += "C";
					}
				}
				data.add(resultString); //add resultant line (reversed and complemented) to resultant arraylist
				resultString = ""; //clear resultString, ready for operation for next line
			}
		}
		scanner.close(); //close scanner in case of memory leak
		return data; //return the resultant arraylist
	}

	/**
	*write - write complemented and reversed data into a new file auto-created
	*@param - list - resultant arraylist with complemented and reversed data
	*/
	public static void write (ArrayList<String> list){
		//try to create and write to a file
		try{
			//create new PrintWriter object called writer, write to result.txt in UTF-8
		    PrintWriter writer = new PrintWriter("result.txt", "UTF-8");
		    //print out individual line by looping through all the element in the array list
		    for (int i =0; i < list.size(); i++){
		    	writer.println(list.get(i));
		    }
		    writer.close(); //close writer in case of memory leak
		    System.out.println("Operation succeed! Please check result.txt."); //tell user to check the result
		} catch (IOException e) {
			//if output is broken, tell user the error
			System.out.println("IOException, Failed to output data");
		}
	}

	/**
	*main - main method - call the reverse and write method
	*/
	public static void main(String[] args) {
		//start timer, count in milliseconds
		final long startTime = System.currentTimeMillis();
		try{
			//create new Scanner object called myscan, scan the DNA sequence file
			//put your file directory here
			Scanner myscan = new Scanner(new File("data/salmonella-complete.txt"));
			//call reverse and write methods
			write(reverse(myscan));
		} catch(FileNotFoundException e){
			//tell user that input data is not found
			System.out.println("Bioformatics data not avaliable");
		}
		//close timer, count in milliseconds
		final long endTime = System.currentTimeMillis();
		//print out execution time by calculating the difference between endTime and stratTime, in milliseconds
		System.out.println("Total execution time: " + (endTime - startTime) + " milliseconds");
	}
}