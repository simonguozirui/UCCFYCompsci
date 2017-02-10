/**
*WorldEnd.java
*@author - simonguo
*@since - feb9,2017
*@version - 1.0
*<a>http://codingbat.com/prob/p147538</a>
*Given a string and a non-empty word string, return a string made of each char
*just before and just after every appearance of the word in the string. Ignore
*cases where there is no char before or after the word, and a char may be
*included twice if it is between two words.
*
*wordEnds("abcXY123XYijk", "XY") → "c13i"
*wordEnds("XY123XY", "XY") → "13"
*wordEnds("XY1XY", "XY") → "11"
*/

import java.util.Scanner;

public class WordEnds{
	/**
	*deldel-removes
	*@param - str - full string to substring
	*@param - word - word to find in the string
    */
	public static String wordEnds(String str, String word){
        String result = "";
        for (int i =0; i < str.length() +1- word.length(); i ++){
            if (str.substring(i,i+word.length()).equals(word)){
                if(i!=0) result += str.substring(i-1,i);
                if(i+word.length() < str.length())result += str.substring(i+2,i+3);
            }
        }
        return result;
    }
    
	public static void main(String[] args) {
        Scanner myscan = new Scanner(System.in);
		System.out.println("Enter a string to process: ");
		String mystr = myscan.nextLine();
		System.out.println("Enter a word to process: ");
        String myword = myscan.nextLine();
        System.out.println(wordEnds(mystr,myword));
	}

}
