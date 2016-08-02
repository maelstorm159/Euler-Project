package EulerProjectFinished;

import java.util.ArrayList;
import java.util.List;

//The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.
//Find the sum of all the primes below two million.

public class P10SummationOfPrimes {
	
	public static void PrimeSummation(){
		long startTime = System.currentTimeMillis();
		long sum = 2;
		List<Long> primeList = new ArrayList<>();
		
		for (long i=1;i<2000000;i+=2){
			if (isPrime(i)){
				sum = sum + i;	
			}
		}
		System.out.println(sum);
		long endTime = System.currentTimeMillis();
		System.out.println("Total time taken is "+ (endTime-startTime)/1000+" seconds");
	}
	
	public static boolean isPrime(long n) {
        if (n <= 1) {return false;}
        if (n == 2) {return true;}
        if (n % 2 == 0) {return false;}
        
        for (int i = 3; i <= Math.sqrt(n); i+=2) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
	
	public static void main(String []args){
		PrimeSummation();
		
	}
}
