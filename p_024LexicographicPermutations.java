package EulerProjectFinished;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//A permutation is an ordered arrangement of objects. 
//For example, 3124 is one possible permutation of the digits 1, 2, 3 and 4. 
//If all of the permutations are listed numerically or alphabetically, we call it lexicographic order. 
//The lexicographic permutations of 0, 1 and 2 are:
//012   021   102   120   201   210
//What is the millionth lexicographic permutation of the digits 0, 1, 2, 3, 4, 5, 6, 7, 8 and 9?

public class p_024LexicographicPermutations {
	
	static List<String> permuteData = new ArrayList<>();
	
	static void swapChar(char [] c,int start,int current){
		char temp = c[start];
		c[start] = c[current];
		c[current] = temp;
	}
	
	static void permute(char [] c, int start){
		
		if (start == c.length-1){
			permuteData.add(new String(c));
			return;
		}
		
		int current = start;
		for(;start<c.length;start++){
			
			swapChar(c,start,current);
			permute(c,current+1);
			swapChar(c,start,current);
		}
	}
	

	
	public static void main(String[]args){
		permute(new String("0123456789").toCharArray(),0);
		Collections.sort(permuteData);
		System.out.println(permuteData.get(999999));
	}

}
