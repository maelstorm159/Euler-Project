package EulerProjectFinished;

import java.util.HashMap;
import java.util.Map;

//Take the number 192 and multiply it by each of 1, 2, and 3:
//
//192 × 1 = 192
//192 × 2 = 384
//192 × 3 = 576
//By concatenating each product we get the 1 to 9 pandigital, 192384576. 
//We will call 192384576 the concatenated product of 192 and (1,2,3)
//
//The same can be achieved by starting with 9 and multiplying by 1, 2, 3, 4, 
//and 5, giving the pandigital, 918273645, which is the concatenated product of 9 and (1,2,3,4,5).
//
//What is the largest 1 to 9 pandigital 9-digit number that can be formed as the 
//concatenated product of an integer with (1,2, ... , n) where n > 1?

public class P38PandigitalMultiples {

	public static void main(String[] args) {

		for (int i=1;i<20000;i++){
			StringBuilder check = new StringBuilder();
			int length = 0;
			int multi = 1;
			
			while (length < 10){
				
				int temp = i*multi;
				check.append(String.valueOf(temp));
				length = check.length();
				String str = (check.toString());
				
				if (length < 9){
					multi++;
				}
				
				if (length == 9){
					if(isPandigital(str)){
						System.out.println("i is "+i+" "+str);
					}
				}
				
				if (length > 9){
					break;
				}	
			}
		}
	}
	
	public static boolean isPandigital(String str){
		
		Map<Integer,Integer> countMap = new HashMap<>();
		 
		for (int i=0;i<9;i++){
			int mapKey = Character.getNumericValue((str.charAt(i)));
			if(mapKey == 0)return false;
			if(countMap.containsKey(mapKey) == false){
			countMap.put(mapKey,1);
			}else {
				return false;
			}
		}
		return true;
	}

}
