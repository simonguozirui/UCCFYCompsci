/*
http://codingbat.com/prob/p100905
Given a string, if the string "del" appears starting at index 1, 
return a string where that "del" has been deleted. 
Otherwise, return the string unchanged.

delDel("adelbc") → "abc"
delDel("adelHello") → "aHello"
delDel("adedbc") → "adedbc"
*/

import java.util.Scanner;

public class DelDel {
	public static String delDel(String str){
		if (str.indexOf("del") == 1){
			return str.substring(0,1) + str.substring(4);
		}else{
			return str;
		}
	}

	public static void main(String[] args) {
		System.out.print("Enter a string to process: ");
		Scanner myscan = new Scanner(System.in);
		String mystr = myscan.next();
		System.out.println(delDel(mystr));
	}

}
