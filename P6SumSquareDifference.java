package EulerProjectFinished;

//The sum of the squares of the first ten natural numbers is, 12 + 22 + ... + 102 = 385
//The square of the sum of the first ten natural numbers is, (1 + 2 + ... + 10)2 = 552 = 3025
//Hence the difference between the sum of the squares of the first ten natural numbers 
//and the square of the sum is 3025 − 385 = 2640.
//Find the difference between the sum of the squares of the first one hundred natural numbers and the square of the sum.
public class P6SumSquareDifference {
	
	public static double SumOfSquare(){
		double sqSum = 0;
		
		for (int i =1;i<=100;i++){
			sqSum += Math.pow(i, 2);
		}
		return sqSum;
	}
	
	public static double SquareOfSum(){
		double SqSum = 0;
		
		for (int i=1;i<=100;i++){
			SqSum+=i;
		}
	
		SqSum = Math.pow(SqSum, 2);
		return SqSum;
	}
	
	
	public static void main(String[]args){
		double differences = SquareOfSum() - SumOfSquare();
		System.out.printf("The differences is %.0f",differences);
	}
}
