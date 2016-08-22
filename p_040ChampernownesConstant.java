package EulerProjectFinished;

//An irrational decimal fraction is created by concatenating the positive integers:
//
//0.123456789101112131415161718192021...
//
//It can be seen that the 12th digit of the fractional part is 1.
//
//If dn represents the nth digit of the fractional part, find the value of the following expression.
//
//d1 × d10 × d100 × d1000 × d10000 × d100000 × d1000000
public class p_040ChampernownesConstant {

	public static StringBuilder cInteger(){
		
		StringBuilder str = new StringBuilder();
	
		for (int i=1;i<=250000;i++){
			str.append(i);	
		}
		return new StringBuilder(str);
	}
	
	public static void main(String[] args) {
		StringBuilder data = cInteger();
		int a = Character.getNumericValue(data.charAt(0));
		int c =	Character.getNumericValue(data.charAt(9));
		int d =	Character.getNumericValue(data.charAt(99));
		int e =	Character.getNumericValue(data.charAt(999));
		int f = Character.getNumericValue(data.charAt(9999));
		int g = Character.getNumericValue(data.charAt(99999));
		int h = Character.getNumericValue(data.charAt(999999));

		int result =a*c*d*e*f*g*h;
		
		System.out.println(result);
	}

}
