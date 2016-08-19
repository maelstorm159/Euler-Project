package EulerProject1To50;

import java.util.ArrayList;
import java.util.List;

//2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.
//What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?

public class P5SmallestMultiple {
	
	public static long Lcm(long n) {
	    long multiple = 1;

	    for ( long i = 2; i <= n; i++ ) {
	        multiple = multiple* (i / Gcd(i, multiple));
	    }
	    return multiple;
	}
	
	public static long Gcd(long a,long b){
		    return ( 0 == b ) ? a : Gcd(b, a%b);
	}
	
	public static void main(String[]args){
		System.out.println(Lcm(20));
	}
}
