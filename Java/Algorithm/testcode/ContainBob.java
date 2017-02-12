/**
*ContainBob.java - Return true if the given string contains a "bob" string, but
*where the middle 'o' char can be any char.
*@author - Simon Guo
*@since - Feb 10, 2017
*@version - 1.0
*Sample Output:
*abcbob --> true
*b9b --> true
*bac --> falsee
*/
//import Scanner library
import java.util.Scanner;

public class ContainBob{
    /**
    *bobThere - return true if string contains "bob" while 'o' could be anything
    *@param - str - String imported from the user
    *returns a boolean value
    */
    public static boolean bobThere(String str){
        //set a boolean variable/flag to decide if "bob" exists
        //false at default
        boolean bobExist = false;
        //for loop loops through the entire string
        for (int i = 0; i < str.length()-2;i++){
            //check if a letter equals b and the letter 2 indexes away is also b
            //use substring to split the string to individual letters
            if (str.substring(i,i+1).equals("b") &&
            str.substring(i+2,i+3).equals("b")){
                //bob exists, set flag/variable = true;
                bobExist = true;
            }
        }
        //return value(boolean)
        return bobExist;
    }

    //main method
    public static void main(String[] args){
        //start scanner
        Scanner myscan = new Scanner(System.in);
        //user interface
        System.out.println("Type a String to process: ");
        String inputstr = myscan.next();
        //print the result, by putting user input into the method's param
        System.out.print("Your string contains bob: ");
        System.out.println(bobThere(inputstr));
    }
}
