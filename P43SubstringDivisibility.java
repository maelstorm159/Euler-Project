package EulerProjectFinished;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

//The number, 1406357289, is a 0 to 9 pandigital number because it is made 
//up of each of the digits 0 to 9 in some order, but it also has a rather
//interesting sub-string divisibility property.
//
//Let d1 be the 1st digit, d2 be the 2nd digit, and so on. In this way, we note the following:
//
//d2d3d4=406 is divisible by 2
//d3d4d5=063 is divisible by 3
//d4d5d6=635 is divisible by 5
//d5d6d7=357 is divisible by 7
//d6d7d8=572 is divisible by 11
//d7d8d9=728 is divisible by 13
//d8d9d10=289 is divisible by 17
//Find the sum of all 0 to 9 pandigital numbers with this property.

public class P43SubstringDivisibility {
	
	
	public static boolean isDivisible(Long n){
		
		int d17 = Integer.parseInt((String.valueOf(n).substring(7,10)));
		if (d17%17 == 0){
			int d13 = Integer.parseInt((String.valueOf(n).substring(6,9)));
			if (d13%13 == 0){
				int d11 = Integer.parseInt((String.valueOf(n).substring(5,8)));
				if (d11%11 == 0){
					int d7 = Integer.parseInt((String.valueOf(n).substring(4,7)));
					if (d7%7 == 0){
						int d5 = Integer.parseInt((String.valueOf(n).substring(3,6)));
						if (d5%5== 0){
							int d3 = Integer.parseInt((String.valueOf(n).substring(2,5)));
							if (d3%3 == 0){
								int d2 = Integer.parseInt((String.valueOf(n).substring(1,4)));
								if (d2%2 == 0){
									return true;
								}		
							}
						}
					}
				}
			}
		}
		return false;
	}
	
	public static boolean isPandigital(Long a){
		
		String temp = String.valueOf(a);
	
		Map<Integer,Integer> countMap = new HashMap<>();
		 
		for (int i=0;i<10;i++){
			int mapKey = Character.getNumericValue((temp.charAt(i)));
			if(countMap.containsKey(mapKey) == false){
			countMap.put(mapKey,1);
			}else {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		long sum = 0;
		
		for (long i = (long) (1*Math.pow(10, 9));i<1*Math.pow(10, 10);i++){
			
			if (isDivisible(i)){
				if (isPandigital(i)){
					sum += i;
				}
			}
		}
		System.out.println(sum);
		

	}

}
