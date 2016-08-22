package EulerProjectFinished;

//By listing the first six prime numbers: 2, 3, 5, 7, 11, 
//and 13, we can see that the 6th prime is 13.
//What is the 10001st prime number?

public class p_007_10001PrimeNum {

	public static void PrimeNum(){
		int a =1;
		int counter =1;
		
		while (counter <= 10001){
			a+= 1;
			if (isPrime(a)){
				System.out.println("counter is "+counter+" and a is "+a);
				counter++;
			}
		}
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
		PrimeNum();
	}
}
