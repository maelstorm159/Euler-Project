package EulerProjectFinished;

import java.math.BigInteger;

//The first known prime found to exceed one million digits was 
//discovered in 1999, and is a Mersenne prime of the form 26972593−1; 
//it contains exactly 2,098,960 digits. Subsequently other Mersenne primes, 
//of the form 2p−1, have been found which contain more digits.
//
//However, in 2004 there was found a massive non-Mersenne prime 
//which contains 2,357,207 digits: 28433×2^7830457+1.
//
//Find the last ten digits of this prime number.

public class p_097LargeNonMersennePrime {

	public static void main(String[] args) {
		BigInteger num1 = BigInteger.valueOf(2);
		BigInteger num2 = BigInteger.valueOf(28433);
		
		num1 = num2.multiply(num1.pow(7830457));
		num1= num1.add(BigInteger.valueOf(1));
		int leng = num1.toString().length();
		String r = num1.toString().substring(leng-10, leng);
		System.out.println(r);
		

	}

}
//this one is easy with bigInteger, it pretty much did everything for me