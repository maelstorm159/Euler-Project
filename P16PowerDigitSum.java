package EulerProjectFinished;

import java.math.BigInteger;
import java.util.Scanner;

//2^15 = 32768 and the sum of its digits is 3 + 2 + 7 + 6 + 8 = 26.
//What is the sum of the digits of the number 2^1000?
public class P16PowerDigitSum {

	public static void PdigitSum(){
		int sum =0;
		BigInteger value = BigInteger.valueOf(2);
		value = value.pow(1000);
		String a2 = String.valueOf(value);
		char[] a3 = new char [a2.length()];
		int [] a4 = new int [a3.length];
		
		for (int i=0;i<a3.length;i++){
			a3[i]= a2.charAt(i);
		}
		
		for (int i=0;i<a3.length;i++){
			a4[i] = Integer.parseInt(String.valueOf(a3[i]));
		}
		
		for (int i=0;i<a4.length;i++){
			sum += a4[i];
		}
		System.out.println(sum);
		
	}
	
	
	public static void main(String[]args){
		PdigitSum();
	}
}
