package EulerProjectFinished;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

//The following iterative sequence is defined for the set of positive integers:
//n → n/2 (n is even)
//n → 3n + 1 (n is odd)
//Using the rule above and starting with 13, we generate the following sequence:
//13 → 40 → 20 → 10 → 5 → 16 → 8 → 4 → 2 → 1
//It can be seen that this sequence (starting at 13 and finishing at 1) contains 10 terms. 
//Although it has not been proved yet (Collatz Problem), it is thought that all starting numbers finish at 1.
//
//Which starting number, under one million, produces the longest chain?
//
//NOTE: Once the chain starts the terms are allowed to go above one million.

public class P14LongestCollatzSequence{
	private static int count = 0;
	
	
	public static void LCSequence(){
		Map<Integer,Integer> data = new HashMap<>();
		
		for (int i=999999;i>1;i--){
			Method(i);
			data.put(i,count);
			count =0;
		}
		
		int maxValueInMap=(Collections.max(data.values())); 
		
        for (Entry<Integer, Integer> entry : data.entrySet()) 
            if (entry.getValue()==maxValueInMap) {
                System.out.println("the value with the most chained is "+entry.getKey()+" with "+entry.getValue() );     
            }
	}
	
	//recursive method
	//keeps calling the method until a # reaches 1
	public static void Method(long a){
			if (a == 1)return;
		
			if (a%2!=0){
				long odd = 3*a+1;
				count++;
				if (odd%2 ==0)Method(odd);
				if (odd%2!=0)Method(odd);
			}
			
			if (a%2 ==0){
				long even = a/2;
				count++;
				if(even%2!=0)Method(even);
				if(even%2==0)Method(even);
			}
	}
	
	public static void main(String[] args) {
		LCSequence();

	}

}
