package EulerProject1To50;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

//The Fibonacci sequence is defined by the recurrence relation:
//Fn = Fn−1 + Fn−2, where F1 = 1 and F2 = 1.
//Hence the first 12 terms will be:
//F1 = 1
//F2 = 1
//F3 = 2
//F4 = 3
//F5 = 5
//F6 = 8
//F7 = 13
//F8 = 21
//F9 = 34
//F10 = 55
//F11 = 89
//F12 = 144
//The 12th term, F12, is the first term to contain three digits.
//What is the index of the first term in the Fibonacci sequence to contain 1000 digits?
		
public class P251000DigitFibonacciNumber {
	
	public static void oneThousandDigitFN(){
		List<BigInteger> data = new ArrayList<>();
		data.add(0,new BigInteger("1"));
		data.add(1,new BigInteger("1"));
		
		int j=0;
		for (int a = 2;a<=5000;a++){
			BigInteger tempA = data.get(j).add(data.get(j+1));
			data.add(a,tempA);
			j++;
			
			int length = data.get(a).toString().length();
			if(length == 1000){
				System.out.println(data.indexOf(data.get(a)));
			}
		}
	}	

	public static void main(String[] args) {
		oneThousandDigitFN();//4782, list start at index 0
		

	}

}
