/*
 * Alexander Florendo
 * CS 310 - 01
 * Professor Healey
 * Project 3: N-_Grams and Frequency Counts
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Random;
public class FrequencyCount {
	
	ArrayList<String> stringGram = new ArrayList<>();
	ArrayList<Integer> hashValues;
	HashMap <String, Integer> freqWordCount = new HashMap<>();

	String s = "";
	int value = 0;
	int counter = 0;
	
	//constructor for given text and degree
	public FrequencyCount(List<String> text, int degree) {
		//for loop to store text from arguments into single string variable
		//one word = one degree; two words = two degree, etc
		for (int i = 0; i < text.size() - degree + 1; i++) {
			for (int j = i; j < i + degree; j++) {
				counter++;
				s += text.get(j) + " ";
			}//end inner
			//after n degree, the gram is stored into an arraylist
			stringGram.add(s);
			//string reset to nothing
			s = "";
		}//end outer
		
		//for loop to store arraylist elements into hashmap
		//preparing to use hashmap as a word counter
		for (int i = 0; i < stringGram.size(); i++) {
			String word = stringGram.get(i);
			
			//if hashmap contains existing word, increment value
			if(freqWordCount.containsKey(word))
				freqWordCount.put(word, freqWordCount.get(word) + 1);
			//else store word into new key with starting val 1
			else
				freqWordCount.put(word, 1);
		}//end for
	}//end constructor
	
	//method that returns list from MOST occurrences to LEAST occurrences
	public List<Entry<String, Integer>> head(){
		//add hashmap entries into linkedlist to allow program to iterate through values
		List<Entry<String, Integer>> sortedList = new LinkedList<Entry<String,Integer>>(freqWordCount.entrySet());
		
		//sorts list from most to least occurrences
		Collections.sort(sortedList, new Comparator<Entry<String,Integer>>(){
			public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
				return o2.getValue().compareTo(o1.getValue());
			}
		});
		
		return sortedList;
	}//end head
	
	//method that returns list from LEAST occurrences to MOST occurrences
	public List<Entry<String, Integer>> tail(){
		//add hashmap entries into linkedlist to allow program to iterate through values
		List<Entry<String, Integer>> sortedList = new LinkedList<Entry<String,Integer>>(freqWordCount.entrySet());
		
		//sorts list from least to most occurrences
		Collections.sort(sortedList, new Comparator<Entry<String,Integer>>(){
			public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
				return o1.getValue().compareTo(o2.getValue());
			}
		});
		return sortedList;
	}//end tail
	
	//returns a random string from the list
	public String randomToken() {
		Random rand = new Random();
		int randNum = rand.nextInt(stringGram.size());
		return stringGram.get(randNum);
	}//end randomToken
	
	//returns the frequency count of a string
	public int count (String token) {
		int num;
		//if statement to check if token exists in list
		if (!freqWordCount.containsKey(token))
			num = 0;
		else
		//returns the VALUE of the key <k, V> : <String, Integer>
			num = freqWordCount.get(token);
		return num;
	}//end count
	
	//returns the percentage of original text of token's appearance
	public double percent(String token){
		double tokenCount;
		//if statement to check if token exists in list
		if (!freqWordCount.containsKey(token))
			tokenCount = 0;
		else 
		
		{
			 //token's value * 100 / list's size
			tokenCount = freqWordCount.get(token);
			tokenCount = (tokenCount * 100) / counter;
		}
		return tokenCount;
	}//end percent
	
	//adds a word to existing frequencyCount Object
	public int add(String token) {
		stringGram.add(token);
		//if token exists, add token to list and +1 to occurrence
		if(freqWordCount.containsKey(token))
			freqWordCount.put(token, freqWordCount.get(token) + 1);
		else
		//else add new word to list and start count at 1
			freqWordCount.put(token, 1);
		return 0;
	}//end add
}//end class
