/*
http://codingbat.com/prob/p125185
Given two strings, a and b, create a bigger string made of the first char of a, the first char of b, the second char of a, the second char of b, and so on. Any leftover chars go at the end of the result.

mixString("abc", "xyz") → "axbycz"
mixString("Hi", "There") → "HTihere"
mixString("xxxx", "There") → "xTxhxexre"
*/

import java.util.Scanner;

public class MixString {
	public static String mixString(String a, String b) {
		String newString = "";
		if (a.length() ==  b.length()){
			for (int i = 0; i < a.length();i++){
			  newString += a.substring(i,i+1);
			  newString += b.substring(i,i+1);
			}
		}else if (a.length() > b.length()){
			for (int i = 0; i < b.length();i++){
			  newString += a.substring(i,i+1);
			  newString += b.substring(i,i+1);
			}
			newString += a.substring(b.length());
		}else{
			for (int i = 0; i < a.length();i++){
			  newString += a.substring(i,i+1);
			  newString += b.substring(i,i+1);
			}
			newString += b.substring(a.length());
		}
		return newString;
	}

	public static void main(String[] args) {
		Scanner myscan = new Scanner(System.in);
		System.out.println("Enter the first string to process: ");
		String mystr1 = myscan.next();
		System.out.println("Enter the second string to process: ");
		String mystr2 = myscan.next();
		System.out.println("the result is "+mixString(mystr1,mystr2));
	}

}

