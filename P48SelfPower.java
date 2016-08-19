package EulerProject1To50;

import java.math.BigInteger;

//The series, 1^1 + 2^2 + 3^3 + ... + 10^10 = 10405071317.
//Find the last ten digits of the series, 1^1 + 2^2 + 3^3 + ... + 1000^1000.

public class P48SelfPower {
	
	public static void SelfPower(){
		
		BigInteger sum = BigInteger.valueOf(0);
		
		for (int i=1;i<=1000;i++){
			BigInteger value = BigInteger.valueOf(i);
			value = value.pow(i);
			sum = sum.add(value);
		}
		System.out.println(sum);
	}
	
	public static void main(String[]args){
		SelfPower();//9110846700
	}
}
