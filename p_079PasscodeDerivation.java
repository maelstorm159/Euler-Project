package EulerProjectFinished;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Stream;

//A common security method used for online banking is to ask the 
//user for three random characters from a passcode. 
//For example, if the passcode was 531278, they may ask for the 
//2nd, 3rd, and 5th characters; the expected reply would be: 317.
//
//The text file, keylog.txt, contains fifty successful login attempts.
//
//Given that the three characters are always asked for in order, 
//analyse the file so as to determine the shortest possible secret passcode of unknown length.

public class p_079PasscodeDerivation {
	
	public static void main(String[] args) {
		String fileName = "C:\\Users\\lz\\workspace\\lz\\src\\P79.txt";
		List<Integer> data = readFile(fileName);
		List<Integer> uniqueNums = new ArrayList<>();
		HashSet<Integer> orderSet = new HashSet<>();
		Map<Integer,Integer> finalAnswer = new HashMap<>();
		
		//adds unique number to a new list, so i get all the numbers that 
		//appeared in file
		for (int x:data){
			String temp = String.valueOf(x);
			int length = String.valueOf(x).length();
			
			for (int i=0;i<length;i++){
				int c = Character.getNumericValue(temp.charAt(i));
				
				if(!uniqueNums.contains(c)){
					uniqueNums.add(c);
				}
			}
		}
		
		//sorts the list, serves no other purpose other than visual preference
		//unique #s display in an ascending order
		Collections.sort(uniqueNums);
		
		//for each unique #, find out the 3digit code that contains them
		// and add numbers other than unique # to a set
		for (int singleDigit:uniqueNums){
			
			for (int number:data){
				char [] temp = (""+number).toCharArray();
				boolean isFound= false;
				int position = 0;
				
				for (int i=0;i<temp.length;i++){
					int compareValue = Character.getNumericValue(temp[i]);
					
					if (compareValue == singleDigit){
						isFound = true;
						position = i;
						break;
					}
				}
				
				if (isFound == true){
					for (int j=0;j<position;j++){
						orderSet.add(Character.getNumericValue(temp[j]));
					}
				}
				
			}
			
			finalAnswer.put(orderSet.size()+1,singleDigit);
			orderSet.clear();
		}
		
		for (Entry<Integer,Integer>entry:finalAnswer.entrySet()){
			System.out.printf("%d",entry.getValue());
		}
	}
	
	

	
	static List<Integer> readFile(String filename){
		BufferedReader reader = null;
		String nextLine;
		List<Integer> data = new ArrayList<>();
		
		try {
			reader = new BufferedReader(new FileReader(filename));
			while ((nextLine = reader.readLine()) != null){
					int temp = Integer.parseInt(nextLine);
					if (!data.contains(temp)){
						data.add(temp);
					}
					
			}
		}catch(IOException e){
			System.err.println("problem reading file");
			e.printStackTrace();
		}
		
		return new ArrayList<>(data);
	}

}

//1)the length of the secert code is unknown
//2)looking for the shorest possible
//3)that means each number should be unqiue and does not repeat
//4)analyze the file to find out all numbers that appeared in the file and remove duplicate entries
//5)once i got the length of this unknown code,which is 8. now i need to determine the ordering of each #
//6)one thing to keep in mind is that the order are always asked for in order

//unique numbers are 0,1,2,3,6,7,8,9
//let say for 0, 680 contains 0, and 0 is at position 2
//I found out all the 3digit codes that contains 0 and 0's position 
//in that code. the more # is found before 0, the further behind 0
//is placed in the final result. if there are 7 #s found before 0. 
//0 will be the last digit. 
