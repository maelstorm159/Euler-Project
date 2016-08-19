package EulerProject1To50;

//The number, 197, is called a circular prime because 
//all rotations of the digits: 197, 971, and 719, are themselves prime.
//There are thirteen such primes below 100: 2, 3, 5, 7, 11, 13, 17, 31, 37, 71, 73, 79, and 97.
//How many circular primes are there below one million?

public class P35CircularPrimes {
	
	public static boolean rotation(int a){
		StringBuilder temp = new StringBuilder(String.valueOf(a));
		int length = temp.length();
		int count = 0;
		
		for (int i=0;i<length;i++){
			String firstChar = ""+temp.charAt(0);
			temp.replace(0, 1, "");
			temp.append(firstChar);
			temp.substring(1, length);
			
			int check = Integer.parseInt(temp.toString());
			
			if (isPrime(check)){
				count++;
			}
			
			if (count == length){
				return true;
			}
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

	public static void main(String[] args) {
		int count = 1;
		for (int i=1;i<1000000;i+=2){
			if(isPrime(i)){
				if (rotation(i)){
					count++;
					System.out.println(i);
				}	
			}
		}
		System.out.println(count);
	}
}
