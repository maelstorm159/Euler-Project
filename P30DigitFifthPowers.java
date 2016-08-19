package EulerProject1To50;

//Surprisingly there are only three numbers that can be written as the sum of fourth powers of their digits:
//
//1634 = 1^4 + 6^4 + 3^4 + 4^4
//8208 = 8^4 + 2^4 + 0^4 + 8^4
//9474 = 9^4 + 4^4 + 7^4 + 4^4
//As 1 = 1^4 is not a sum it is not included.
//
//The sum of these numbers is 1634 + 8208 + 9474 = 19316.
//
//Find the sum of all the numbers that can be written as the sum of fifth powers of their digits.

public class P30DigitFifthPowers {
	
	static int fifPower(int n){
		String temp = String.valueOf(n);
		int length = temp.length();
		int sum = 0;
		
		for (int i=0;i<length;i++){
			char c = temp.charAt(i);
			int value = (int) Math.pow(Character.getNumericValue(c),5);
			sum += value;
		}
		
		if (sum == n){
			return n;
		}else {
			return 0;
		}
		
	}
	
	public static void main(String[] args) {
		int sum = 0;
		for (int i=10;i<=999999;i++){
			int fifp = fifPower(i);
			sum += fifp;
		}
		System.out.println(sum);
	}

}
