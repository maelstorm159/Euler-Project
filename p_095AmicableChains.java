package EulerProjectFinished;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

//The proper divisors of a number are all the divisors excluding 
//the number itself. For example, the proper divisors of 28 are 
//1, 2, 4, 7, and 14. As the sum of these divisors is equal to 28, we call it a perfect number.
//
//Interestingly the sum of the proper divisors of 220 is 284 and 
//the sum of the proper divisors of 284 is 220, forming a chain of 
//two numbers. For this reason, 220 and 284 are called an amicable pair.
//
//Perhaps less well known are longer chains. For example, starting 
//with 12496, we form a chain of five numbers:
//
//12496 → 14288 → 15472 → 14536 → 14264 (→ 12496 → ...)
//
//Since this chain returns to its starting point, it is called an amicable chain.
//
//Find the smallest member of the longest amicable chain with no element exceeding one million.

public class p_095AmicableChains {
	static List<Integer> amicableChains = new ArrayList<>();
	static Map<Integer,Integer> dataMap = new HashMap<>();
	static int count = 0;
	
	public static void main(String[] args) {

		for (int i=12496;i<=999999;i++){

			if (amicableChainsV1(i)){
				dataMap.put(amicableChains.get(0), amicableChains.size());
				amicableChains.removeAll(amicableChains);
				}else {
					amicableChains.remove(amicableChains);
			}
		}
		
		int maxValue = Collections.max(dataMap.values());
		for (Entry<Integer,Integer>entry:dataMap.entrySet()){
			if (entry.getValue() == maxValue){
				System.out.println(entry.getKey());
			}
		}
		
	}
	
	static boolean amicableChainsV1(int n){
		count++;
		int newAmicaNum = 1;
		
		if (amicableChains.contains(n)){
			if (n == amicableChains.get(0)){
				return true;
			}else{
			count = 0;
			amicableChains.removeAll(amicableChains);
			return false;
			}
		}
		
		if (count == 1){
			amicableChains.add(n);
		}
		
		if (isPrime(n)){
			amicableChains.removeAll(amicableChains);
			count = 0;
			return false;
		}
			
		if (n <= 1 || n > 1000000){
			amicableChains.removeAll(amicableChains);
			count = 0;
			return false;
		}
		
		for (int i = 2; i <= Math.sqrt(n); i++){
			
	        if(n % i == 0)
	        {
	           newAmicaNum += i;
	           int d = n/i;
	           if(d!=i)
	              newAmicaNum+=d;
	        }
		}
		
		amicableChains.add(n);
		
		return amicableChainsV1(newAmicaNum);
		
	}
	
	public static boolean isPrime(int a){
		if (a<=1)return false;
		else if (a<4 )return true;
		else if (a%2 ==0)return false;
		else if (a<9)return true;
		else if (a%3==0)return false;
		
		else {
			int r = (int) Math.floor(Math.sqrt(a));
			int f =5;
			while(f<=r){
				if (a%f==0){
					return false;
				}
				if (a%(f+2)==0){
					return false;
				}
				f = f+6;
			}
		}
		return true;
	}

}

//the difficult part here is to figure out how to write a 
//recursive function properly, got a lot of stackoverflow error
//in the process.

// couple main issues i need to solve here
//1) the code needs to recongize the start of the chain
//and the end of the chain, which is the same # as the 
//starting number

//2)code needs to know when it encounters an amicable # pairs
//and exit the function
//
//3)set other conditions to end the function as soon as possible

//using a list to store the starting # and store other 
//#s as a result of the recursive call, clears the list as soon as 
//an exit condition is met and if it returns true, put the starting # 
//and the size of the list into a map, whether be true or false. 
//so I've an empty list for next starting #.
