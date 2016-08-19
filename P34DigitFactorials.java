package EulerProject1To50;

//145 is a curious number, as 1! + 4! + 5! = 1 + 24 + 120 = 145.
//
//Find the sum of all numbers which are equal to the sum of the factorial of their digits.
//
//Note: as 1! = 1 and 2! = 2 are not sums they are not included.

public class P34DigitFactorials {
	
	static long factorial(int n){
		
		if (n==0){
			return 1;
		}else {
			return n*factorial(n-1);
		}
	}

	public static void main(String[] args) {
		int answer = 0;
		
		for (int i=3;i<500000;i++){
			String a = String.valueOf(i);
			int length = a.length();
			int check = 0;
			
			
			for (int j=0;j<length;j++){
				char temp = a.charAt(j);
				int var = Character.getNumericValue(temp);
				long value = factorial(var);
				
				check += value;
			}
			if (check == i){
				answer += i;
			}
			
		}
		
		System.out.println(answer);
		
	}

}
