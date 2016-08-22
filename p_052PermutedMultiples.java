package EulerProjectFinished;

import java.util.ArrayList;
import java.util.Collections;

//It can be seen that the number, 125874, and its double, 251748, 
//contain exactly the same digits, but in a different order.
//
//Find the smallest positive integer, x, such that 2x, 3x, 4x, 5x, and 6x, contain the same digits.

public class p_052PermutedMultiples {
	
	static boolean isSameDigit(char []a,char[]b){
		
		if(a.length == b.length){
			
			ArrayList<Integer> data1 = new ArrayList<>();
			for (int i=0;i<a.length;i++){
				data1.add(Character.getNumericValue(a[i]));
			}
			Collections.sort(data1);
			
			ArrayList<Integer> data2 = new ArrayList<>();
			for (int i=0;i<a.length;i++){
				data2.add(Character.getNumericValue(b[i]));
			}
			Collections.sort(data2);
			
			if (data1.equals(data2)){
				return true;
			}
		}	
			
		return false;
	}

	public static void main(String[] args) {
		
		for (int i=1;i<999999;i++){
			char [] temp = new String(""+i).toCharArray();
			int count = 0;
			
			for (int j=2;j<=6;j++){
				char [] compare = new String(""+i*j).toCharArray();
				
				boolean isTrue = isSameDigit(temp,compare);
				
				if (isTrue){
					count++;
					if (count == 5){
						System.out.println(i);
					}
				}else {
					break;
				}
			}
			
		}
		
	}

}
