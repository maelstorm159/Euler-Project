package EulerProjectFinished;

import java.util.HashSet;
import java.util.Set;

//The 5-digit number, 16807=7^5, is also a fifth power. Similarly, 
//the 9-digit number, 134217728=8^9, is a ninth power.
//
//How many n-digit positive integers exist which are also an nth power?

public class p_063PowerfulDigitCounts {

	public static void main(String[] args) {
		Set<Long> uniqueNums = new HashSet<>();
		
		for (int i=0;i<99;i++){
			
			for (int j=1;j<=99;j++){
				
				long temp = (long)Math.pow(i, j);
				int length = String.valueOf(temp).length();
				
				if (length == j){
					System.out.printf("i %d || j %d || temp %d\n",i,j,temp);
					uniqueNums.add(temp);
				}
			}
		}
		System.out.println(uniqueNums.size());
	}
}

//the question gave out most of the answer already
//

//1)length of the # is determine by x ^ y power, so it y =5,then the # must
//have 5 digits, else it is false

// used nested loop to do it. thankfully it is not much iteration, otherwise the
//compute time is gonig to hurt