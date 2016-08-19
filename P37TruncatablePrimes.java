package EulerProject1To50;

//The number 3797 has an interesting property. Being prime itself, 
//it is possible to continuously remove digits from left to right, 
//and remain prime at each stage: 3797, 797, 97, and 7. Similarly we can work from right to left: 3797, 379, 37, and 3.
//Find the sum of the only eleven primes that are both truncatable from left to right and right to left.
//NOTE: 2, 3, 5, and 7 are not considered to be truncatable primes.

public class P37TruncatablePrimes {
	
	public static void speicalPrimes(){
		int sum = 0;
		for (int i=0;i<1000000;i++){
			if (isPrime(i)){
				if (isTruncatableFromRight(i)&&isTruncatableFromLeft(i)){
					sum += i;					
				}
			}
			
		}
		System.out.println(sum);
	}
	
	public static boolean isTruncatableFromRight(int num){
		int length = String.valueOf(num).length();
		String str = String.valueOf(num);
		
		int begIndex = 1;
		while (begIndex < length){
			String temp = str.substring(begIndex,length);
			int tempPrime = Integer.parseInt(temp);
			
			if (isPrime(tempPrime)){
				begIndex++;
			}else {
				return false;
			}
			
			if (begIndex == length)return true;
		}
		return false;
	}
	
	public static boolean isTruncatableFromLeft(int num){
		int length = String.valueOf(num).length();
		String str = String.valueOf(num);
		
		int endIndex = length-1;
		while (endIndex > 0){
			String temp = str.substring(0,endIndex);
			int tempPrime = Integer.parseInt(temp);
			
			if (isPrime(tempPrime)){
				endIndex--;
			}else {
				return false;
			}
			
			if (endIndex == 0)return true;
		}
		return false;
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
	
	public static void main(String[]args){
		speicalPrimes();
		
		
	}
}
