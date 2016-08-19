package EulerProject1To50;

import java.math.BigInteger;

//n! means n × (n − 1) × ... × 3 × 2 × 1
//
//For example, 10! = 10 × 9 × ... × 3 × 2 × 1 = 3628800,
//and the sum of the digits in the number 10! is 3 + 6 + 2 + 8 + 8 + 0 + 0 = 27.
//
//Find the sum of the digits in the number 100!
public class P20FactorialDigitSum {
	
	public static void main(String[] args) {
		
		int sum = 0;
		BigInteger x = new BigInteger("1");
		
		for (int i=2;i<=100;i++){
			x = x.multiply(BigInteger.valueOf(i));
		}
		
		String a = x.toString();
		
		for (int i=0;i<a.length();i++){
			sum += Character.getNumericValue(a.charAt(i));
		}
		
		System.out.println(sum);
		
	}
}


