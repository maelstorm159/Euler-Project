package EulerProject1To50;

import java.util.ArrayList;
import java.util.List;

//A Pythagorean triplet is a set of three natural numbers, a < b < c, for which,
//a^2 + b^2 = c^2
//For example, 3^2 + 4^2 = 9 + 16 = 25 = 5^2.
//There exists exactly one Pythagorean triplet for which a + b + c = 1000.
//Find the product abc.
public class P9SpecialPythagoreanTriplet {
	
	
	public static void SpecialTriplet(){
		int [] data = new int [1000];
		int a = 1;
		for (int i=0;i<1000;i++){
			data[i]= (int)Math.pow(a, 2);
			a++;
		}
		
		for (int j=0;j<data.length;j++){
			for (int e =0;e<data.length;e++){
				int g = data[j]+data[e];
				
				int tempA = (int) Math.sqrt(data[j]);
				int tempB = (int) Math.sqrt(data[e]);
				int tempG = (int) Math.sqrt(g);

				
				if (Math.pow(tempG, 2) == Math.pow(tempA, 2)+Math.pow(tempB,2)){
					if (tempA+tempB+tempG == 1000){
						System.out.printf("%d\t%d\t%d\t",tempA,tempB,tempG);
					}
				}
				
			}
		}
		System.out.println(200*375*425);

	}
	
	
	
	public static void main(String[]args){
		SpecialTriplet();
	}
}
