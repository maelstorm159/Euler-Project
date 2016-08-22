package EulerProjectFinished;

//It was proposed by Christian Goldbach that every odd composite number
//can be written as the sum of a prime and twice a square.
//9 = 7 + 2×1^2
//15 = 7 + 2×2^2
//21 = 3 + 2×3^2
//25 = 7 + 2×3^2
//27 = 19 + 2×2^2
//33 = 31 + 2×1^2
//It turns out that the conjecture was false.
//What is the smallest odd composite that cannot be 
//written as the sum of a prime and twice a square?

public class p_046GoldbachsOtherConjecture {
	
	public static void otherConjeccture(){
		for (int i=1;i<6000;i+=2){
			if(isPrime((long) i) == false){
				if (isTrue((long) i)== false){
					System.out.println(i);
				}
			}
		}
	}
	
	public static boolean isTrue(Long n){
		for (int i=1;i<n;i++){
			int temp = (int) (2*(Math.pow(i, 2)));
			for (int j=1;j<n;j+=2){
				if(isPrime(j)){
					if (n == j+temp){
						return true;
					}
				}
					
			}
		}
		return false;
	}

	public static boolean isPrime(long a){
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
		otherConjeccture();

	}

}
