package EulerProjectFinished;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

//If the numbers 1 to 5 are written out in words: 
//one, two, three, four, five, then there are 3 + 3 + 5 + 4 + 4 = 19 letters used in total.
//
//If all the numbers from 1 to 1000 (one thousand) inclusive were written out in words, how many letters would be used?
//
//NOTE: Do not count spaces or hyphens. For example, 342 (three hundred and forty-two) contains 23 letters 
//and 115 (one hundred and fifteen) contains 20 letters. 
//The use of "and" when writing out numbers is in compliance with British usage.
public class P17NumberLetterCounts {
	
	public static Map<Integer,String> NumToLetter(){
		
		HashMap <Integer,String> oneMap = new HashMap<>();
		
		String [] oneTo19 = {"zero","one","two","three","four","five","six","seven","eight","nine","ten",
				"eleven","twelve","thirteen","fourteen","fifteen","sixteen","seventeen","eighteen","nineteen"};
		String [] tys = {"twenty","thirty","forty","fifty","sixty","seventy","eighty","ninety"};
		String [] hundreds = {"one hundred","two hundred","three hundred","four hundred","five hundred",
				"six hundred","seven hundred","eight hundred","nine hundred","one thousand"};
		
		//insert #s from 0-19 to hashmap
		for (int i=0;i<oneTo19.length;i++){
			oneMap.put(i, oneTo19[i]);
		}
				
		//insert #s like 20,30-90 to hashmap
		int p=0;
		for (int i =20;i<=90;i+=10){
			oneMap.put(i, tys[p]);
			p++;
			if (p == tys.length+1){
				break;
			}
		}
		
		//inserts #s like 100,200,300 - 1000 to hashmap
		int w=0;
		for (int i =100;i<=1000;i+=100){
			oneMap.put(i, hundreds[w]);
			w++;
			if (w == hundreds.length+1){
				break;
			}
		}
		
		//insert #s from 21 to 99, except for 30,40 and so on, until 90 to hashmap
		int index = 20;
		int h =1;
		for (int i=21;i<=99;i++){
			if(oneMap.containsKey(i) == false){
				oneMap.put(i,oneMap.get(index)+" "+oneTo19[h]);
				h++;
				if (h==10)h=1;
			}else {
				index+=10;
			}
		}
		
		//insert #s from 101 to 999, except for 100,200 and so on, until 1000 to hashmap
		int sIndex = 100;
		int u =1;
		for (int i=101;i<=999;i++){
			if(oneMap.containsKey(i) == false){
				oneMap.put(i,oneMap.get(sIndex)+" and "+oneMap.get(u));
				u++;
			}else {
				sIndex+=100;
				u = 1;
			}	
		}
			
		int sum = 0;
		for (Entry<Integer, String> entry : oneMap.entrySet()) {
	        sum += entry.getValue().replace(" ", "").length();
	    }
		
		HashMap <Integer,String> oneMapClone = new HashMap<>();
		oneMapClone = (HashMap<Integer, String>) oneMap.clone();
		
		return oneMapClone; 
	
	}
	
	public static void NumToLetterConverter(int a){
		NumToLetter();
		Map<Integer,String> lookUpMap = NumToLetter();

		if (lookUpMap.containsKey(a)){
			System.out.println(lookUpMap.get(a));
		}else{
			System.out.println("does not match");
		}
	}
	
	public static void main(String[] args) {
		NumToLetter();// 21124, only ask for 1 to 1000 and i included zero.
		NumToLetterConverter(1002);
	}

}
