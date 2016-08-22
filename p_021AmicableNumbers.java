package EulerProjectFinished;

import java.util.ArrayList;
import java.util.List;

//Let d(n) be defined as the sum of proper divisors of n 
//(numbers less than n which divide evenly into n).
//If d(a) = b and d(b) = a, where a ≠ b, then a and 
//b are an amicable pair and each of a and b are called amicable numbers.
//
//For example, the proper divisors of 220 are 1, 2, 4, 5, 
//10, 11, 20, 22, 44, 55 and 110; therefore d(220) = 284. 
//The proper divisors of 284 are 1, 2, 4, 71 and 142; so d(284) = 220.

//Evaluate the sum of all the amicable numbers under 10000.

public class p_021AmicableNumbers {
	
	static int [] isAmicable(int one){
		
		int sum =0;
		int [] amicablePairs = null;
		
		for (int i=1;i<=one/2;i++){
			
			if(one%i==0){
				sum += i;
			}
		}
		
		int sumTwo = 0;
		for (int j=1;j<=sum/2;j++){
			if (sum%j == 0){
				sumTwo += j;
			}
		}
		
		if (sumTwo == one && sumTwo != sum ){
			amicablePairs = new int []{one,sum};
		}
		
		return amicablePairs;
	}

	public static void main(String[] args) {
		int sum = 0;
		
		for (int i=1;i<=9999;i++){
			int [] temp = isAmicable(i);
			
			if (temp != null){
				
				for (int j=0;j<temp.length;j++){
					
					sum+= temp[j];
					
				}
			}
		}
		System.out.println(sum/2);
	}

}
