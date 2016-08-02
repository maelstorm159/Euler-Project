package EulerProjectFinished;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//A palindromic number reads the same both ways.
//The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 × 99.
//Find the largest palindrome made from the product of two 3-digit numbers.

public class P4LargestPalindromeProduct {
	
	public static void LargestPP(){
		int i = 0;
		int j = 1;
		int sum = 0;
		
		for (i = 100;i<1000;i++){
			for (j = 100;j<1000;j++){
				sum = i*j;
				isPalindromic(sum);
			}
		}
	}
	
	public static void isPalindromic(int sum){

		if (sum > 900000){
			List<Character> compare = new ArrayList<>();
			List<Character> reverse = new ArrayList<>();
			String a = String.valueOf(sum);
	
			for (int e = 0; e<a.length();e++){
				compare.add(a.charAt(e));
				reverse.add(a.charAt(e));
			}
			Collections.reverse(reverse);
		
			if (compare.equals(reverse))System.out.println(sum+" is a palidromic #");
			}
		}
	
	public static void main(String[]args){
		LargestPP();
	}
}
