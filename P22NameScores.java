package EulerProject1To50;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;


//begin by sorting it into alphabetical order. Then working out the 
//alphabetical value for each name, multiply this value by its alphabetical 
//position in the list to obtain a name score.
//
//For example, when the list is sorted into alphabetical order, COLIN, 
//which is worth 3 + 15 + 12 + 9 + 14 = 53, is the 938th name in the list. So, 
//COLIN would obtain a score of 938 × 53 = 49714.
//
//What is the total of all the name scores in the file?
public class P22NameScores {
	private static BufferedReader reader;
	
	public static void nameScore() throws IOException{
		Path path = Paths.get("c:\\Users\\lz\\workspace\\lz\\src\\P22.txt");
		
		try {
			reader = Files.newBufferedReader(path); 
		} catch (IOException e) {
				System.err.println("Error opening file, terminating");
				System.exit(1);
		}
		
		String [] data = null;
		while (reader.ready()) {
			String line = reader.readLine();
			data = line.split(",");
		}
		
		ArrayList<String> list = new ArrayList<>(Arrays.asList(data));
		Collections.sort(list);
		String [] sortedData = new String[list.size()];
		sortedData = list.toArray(sortedData);
		
		Map<Character,Integer> charValue = new HashMap<>();
		int g = 1;
		for (char i='A';i<='Z';i++){
			charValue.put(i, g);
			g++;
		}
		
		int totalSum =0;
		int tempSum = 0;
		for (int i=0;i<sortedData.length;i++){
			String a = sortedData[i].replace("\"", "");
			for (int j=0;j<a.length();j++){
				int value = charValue.get(a.charAt(j));
				tempSum += value;
			}
			tempSum *= i+1; 
			totalSum+=tempSum;
			tempSum = 0;
		}
		System.out.println(totalSum);
	}

	public static void main(String[] args) throws IOException {
		nameScore();
		
		

	}

}
