package EulerProjectFinished;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

//We shall say that an n-digit number is pandigital if it makes use of 
//all the digits 1 to n exactly once. For example, 2143 is a 4-digit pandigital and is also prime.
//What is the largest n-digit pandigital prime that exists?

public class p_041PandigitalPrime {
	
	public static void pandigitalPrime(){

		for (int i=0;i<10000000;i++){
			if(isPrime(i)){
				if(isPandigital(i)){
					System.out.println(i);
				}
			}
		}
	}
	
	public static boolean isPandigital(int num){
		String temp = String.valueOf(num);
		Map<Integer,Integer> countMap = new HashMap<>();
		
		for (int i=0;i<temp.length();i++){
			int mapKey = Character.getNumericValue((temp.charAt(i)));
			if (mapKey == 0) return false;
			if(countMap.containsKey(mapKey) == false){
			countMap.put(mapKey,1);
		}else {
			return false;}
		}
		
		int count = 0;
		for (int i=1;i<=temp.length();i++){
			if (countMap.containsKey(i)){
				count++;
			}
		}
		if (count == temp.length())return true;
		else {
			return false;
		}
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
	
	public static void main(String[]args){
		pandigitalPrime();

	}
}
