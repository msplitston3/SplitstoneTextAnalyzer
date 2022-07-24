//Author Name: Michelle Splitstone
//Date: 5/24/2022
//Program Name: SplitstoneTextAnalyzer
//Purpose: Counts all words in text selection from a file and 
//outputs pairs of words and frequency count. 

import static java.lang.System.out;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class SplitstoneTextAnalyzer {

	public static void main(String[] args) {
		System.out.println(textAnalyzer());
	}
		public static String textAnalyzer() {	
			//Declaring file location of play
			File newFile = new File("Macbeth.txt");
			
			//Declaring new scanner followed by a try and catch
			//block to import the play file.
			Scanner play = null;
			try {
				play = new Scanner(newFile);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			Map<String, Integer> wordMap = new HashMap<String, Integer>();

			while (play.hasNext()) {
				//Assign each word to wordOne variable and use replace filters to remove
				//punctuation from each word to truly count each word.
				String wordOne = play.next().replace(',', ' ').replace(';', ' ')
						.replace('.', ' ').replace('!', ' ').replace('?', ' ').replace("'", "")
						.replace(':', ' ').replace('[', ' ').trim().toLowerCase();

				//Assign word count
				int count = 0;
				
				//This will check to see if the word exists in map currently
				//if it does then the count is copied to the count variable.
				for (Map.Entry<String, Integer> word : wordMap.entrySet()) {
					if (wordOne.equals(word.getKey())) {
						count = word.getValue();
					}
				}
				
				//Add word to map. Count + 1 to include current addition in count.
				wordMap.put(wordOne, count + 1);
				}
				
				//Create a list from the map and then sort the list.
				//Outside resource used: https://www.delftstack.com/howto/java/how-to-sort-a-map-by-value-in-java/
				List<Entry<String, Integer>> wordList = new ArrayList<>(wordMap.entrySet());
				wordList.sort(Entry.comparingByValue());
				
				//Loop through all entries and create a ranked list to output.
				int count = wordList.size();
				String output = "";
				for (int i = 0; i < wordList.size(); i++) {
					output = "#" + count-- + " " + wordList.get(i).getKey()  + " = " + wordList.get(i).getValue() +  output + "\n";
				}
				
				//Final output of sorted and ranked word frequency.
				return output;
		}
		public int testA() {
			return 0;
		}
}

