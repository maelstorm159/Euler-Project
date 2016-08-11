package EulerProjectFinished;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


//We shall say that an n-digit number is pandigital if it makes use of all the digits 1 to n exactly once; 
//for example, the 5-digit number, 15234, is 1 through 5 pandigital.
//The product 7254 is unusual, as the identity, 39 × 186 = 7254, 
//containing multiplicand, multiplier, and product is 1 through 9 pandigital.
//Find the sum of all products whose multiplicand/multiplier/product 
//identity can be written as a 1 through 9 pandigital.
//HINT: Some products can be obtained in more than one way so be sure to only include it once in your sum.

public class P32PandigitalProducts {

	public static void pandigitalProducts(){
		int sum = 0;
		List<Integer> data = new ArrayList<>();

		for (int i=11;i<9999;i++){
			for (int j=1;j<9999;j++){
				int temp = i*j;
				
				if (isPandigital(i,j,temp)){
					if (data.contains(temp)){
						sum += 0;
					}else {
						data.add(temp);
						sum += temp;
					}
				}
			}
		}
		System.out.println(sum);
		
	}
	
	
	public static boolean isPandigital(int a, int b, int product){
		
		String temp = String.valueOf(a)+String.valueOf(b)+String.valueOf(product);
		if (temp.length() != 9){
			return false;
		}

		Map<Integer,Integer> countMap = new HashMap<>();
		 
		for (int i=0;i<9;i++){
			int mapKey = Character.getNumericValue((temp.charAt(i)));
			if(mapKey == 0)return false;
			if(countMap.containsKey(mapKey) == false){
			countMap.put(mapKey,1);
			}else {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		pandigitalProducts();
		
		
	}

}
