package EulerProject1To50;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9. 
//The sum of these multiples is 23. Find the sum of all the multiples of 3 or 5 below 1000.
public class P1MultiplesOf3and5 {
	
	public static void main(String []args){
		int sum = 0;
		
		List<Integer> x = new ArrayList<>();
		
		for (int i = 0; i< 1000; i++){
			
			if (i % 3 == 0 || i % 5 == 0){
				x.add(i);
				sum += i;
			}
		}
		for (int a:x)System.out.println(a);
		System.out.println("The sum is "+sum);
	}
	
}
