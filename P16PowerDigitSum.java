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
		String strValue = String.valueOf(value);

		int [] data = new int [strValue.length()];
		
		for (int i=0;i<data.length;i++){
			data[i] = Integer.parseInt((""+strValue.charAt(i)).toString());
			sum += data[i];
		}
		
		System.out.println(sum);
	}
	
	
	public static void main(String[]args){
		PdigitSum();
	}
}
