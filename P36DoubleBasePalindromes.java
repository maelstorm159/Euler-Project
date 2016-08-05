package EulerProjectFinished;

import java.util.ArrayList;
import java.util.List;

//The decimal number, 585 = 10010010012 (binary), is palindromic in both bases.
//Find the sum of all numbers, less than one million, which are palindromic in base 10 and base 2.
//(Please note that the palindromic number, in either base, may not include leading zeros.)
public class P36DoubleBasePalindromes {
	
	public static void doubleBasePalindromes(){
		int sum = 0;
		List<Integer> data = new ArrayList<>();
		for (int i=0;i<999999;i++){
			if (isDoubleBassedPalindromic(i)){
				sum+= i;
			}	
		}
		System.out.println(sum);
	}
	
	public static boolean isDoubleBassedPalindromic(int num){
		StringBuilder checkBase10 = new StringBuilder();
		int intBase10 = Integer.parseInt((checkBase10.append(num).reverse().toString()));
		
		StringBuilder checkBinary = new StringBuilder();
		String binary = Integer.toBinaryString(num);
		String intBinary = (checkBinary.append(binary).reverse().toString());
		
		if (num == intBase10 && binary.equals(intBinary) )return true;
		else return false;
	}
	
	public static void main(String[] args) {
		doubleBasePalindromes();

	}

}
