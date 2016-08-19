package EulerProject1To50;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//The nth term of the sequence of triangle numbers is given by, 
//tn = ½n(n+1); so the first ten triangle numbers are:
//
//1, 3, 6, 10, 15, 21, 28, 36, 45, 55, ...
//
//By converting each letter in a word to a number corresponding to 
//its alphabetical position and adding these values we form a word value.
//For example, the word value for SKY is 19 + 11 + 25 = 55 = t10. If the 
//word value is a triangle number then we shall call the word a triangle word.
//
//Using words.txt (right click and 'Save Link/Target As...'), a 16K text 
//file containing nearly two-thousand common English words, how many are triangle words?

public class P42CodedTriangleNumbers {

	public static void main(String[] args) {
		String p42 = "C:\\Users\\lz\\workspace\\lz\\src\\P42.txt";
		String []data = readFile(p42);
		List<Long> triNums = generatedTriNum(100);
		Map<Character,Integer> wordMap = wordToLetterMap();
		int count = 0;
		
		for (int i=0;i<data.length;i++){
			data[i] = data[i].replaceAll("\"", "");
			int sum = 0;
			char temp = 0;
			
			for (int j=0;j<data[i].length();j++){
				temp = data[i].charAt(j);
			
				sum += wordMap.get(temp);
			
			}
			System.out.printf(" %s || sum is %d\n",data[i],sum);
			if (triNums.contains((long)sum)){
				count++;
			}
			
		}
		System.out.println(count);
	}
	
	public static Map<Character, Integer> wordToLetterMap(){
		Map<Character,Integer> wordToLetterMap = new HashMap<>();
		int value = 1;
		
		for(char c = 'A';c<='Z';c++){
			wordToLetterMap.put(c, value);
			value++;
		}
		return new HashMap<>(wordToLetterMap);
	}

	
	public static List<Long> generatedTriNum(int size){
		 
		List<Long> triNum = new ArrayList<>();
		triNum.add(0,(long) 1);
		triNum.add(1,(long) 3);
		
		for (int i=2;i<size;i++){
		long diff = triNum.get(triNum.size()-1)-triNum.get(triNum.size()-2);
		long newTri = triNum.get(triNum.size()-1)+diff+1;
		triNum.add(i,newTri);
		}
		
		return new ArrayList<>(triNum);
	}
	
	public static String [] readFile(String filename){
		BufferedReader reader = null;
		String [] temp = null;
		
		try{
			String nextLine;
			reader = new BufferedReader(new FileReader(filename));
			if ((nextLine = reader.readLine()) != null) {
				temp = nextLine.split(",");
			}
			
		}catch(IOException e) {
            System.err.println("Problem loading maze file: " + filename);
            e.printStackTrace();
		}
		
		return temp;
	}

}
