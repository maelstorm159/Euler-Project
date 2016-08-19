package EulerProject1To50;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;



//The arithmetic sequence, 1487, 4817, 8147, in which each of the 
//terms increases by 3330, is unusual in two ways: (i) each of the 
//three terms are prime, and, (ii) each of the 4-digit numbers are 
//permutations of one another.
//
//There are no arithmetic sequences made up of three 1-, 2-, or 
//3-digit primes, exhibiting this property, but there is one other 4-digit increasing sequence.
//
//What 12-digit number do you form by concatenating the three terms in this sequence?

public class P49PrimePermutations {
	
	static List<String> permuteData = new ArrayList<>();
	static Set<Integer> primes = new HashSet<>();
	
	public static void main(String[]args){

		for (int i=1488;i<=9999;i++){
			
			permute(new String(""+i).toCharArray(),0);
			
			for (String str:permuteData){
				
				int prime = Integer.parseInt(str);
				
				if(isPrime(prime)){
					primes.add(prime);
				}
			}
			
			if (primes.size()>=3){
				int [] temp = primes.stream().mapToInt(Integer::intValue).toArray();
				Map<Integer,Integer> r = printDiffPairs(temp,3330);
				
				for(Entry<Integer,Integer> entry:r.entrySet()){
					System.out.println(entry.getKey()+" "+entry.getValue());
					System.out.println();
				}
			}
			
			permuteData.removeAll(permuteData);
			primes.removeAll(primes);
			
		}
		
		
		
	
		
	}
	
	public static void permute(char[]charArr,int start){
		
		if(start == charArr.length-1){
			permuteData.add(new String(charArr));
			return;
		}
		
		int current = start;
		for (;start<charArr.length;start++){
			
			swapChar(charArr,start,current);
			permute(charArr,current+1);
			swapChar(charArr,start,current);
		}
		
	}
	
	public static void swapChar(char [] charArr, int start, int current){
		char c = charArr[start];
		charArr[start] = charArr[current];
		charArr[current] = c;
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
	
	public static Map<Integer,Integer> printDiffPairs(int []input, int difference){
		
	    Map<Integer, Integer> pairs = new HashMap<Integer, Integer>();
	    Map<Integer,Integer> result = new HashMap<>();
	    
	    for(int i=0;i<input.length;i++){
	    	pairs.put(input[i], i);
	    }
	    
	    for(int j=0;j<input.length;j++) {
	    	int mapKey = input[j]+difference;
	    	
    	     if(pairs.containsKey(mapKey)){
    		  result.put(mapKey, input[j]);
    	  }
	    }
	    
	    return new HashMap(result);
	}

}
