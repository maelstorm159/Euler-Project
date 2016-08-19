package EulerProject1To50;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

//The prime factors of 13195 are 5, 7, 13 and 29.
//What is the largest prime factor of the number 600851475143 ?

public class P3LargestPrimeFactor {

	public static void largestPrime(){
		long timeStart = System.currentTimeMillis();
		long a = 600851475143L;
		
		System.out.println("step 1");
		for (long b = 1;b*b<a;b++){
			
			if (a%b == 0 && b > 0){
				boolean test = isPrime(b);
				if (test == true){
					System.out.println("this is a prime # "+ b);
				}
			}
		}
		long timeEnd = System.currentTimeMillis();
		System.out.println("total time is "+ (timeEnd-timeStart));
		
	}
	
	public static boolean isPrime(long a){
		int counter = 1;
		boolean isPrime = false;
		
		if( a == 1)isPrime = true;
		
		if (a%2 == 0){
			 isPrime = false;
			 }
		 
		for (int i = 3;i<a;i++){
				if (a%i == 0 && i > 0){
					counter++;
				}
				if (counter >= 3){
					isPrime = false;
				}else isPrime = true;
			 }
		 
		return isPrime;
	}
	
	public static void main(String []args){
		largestPrime();
	}

}
