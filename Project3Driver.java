/*
 * Alexander Florendo
 * CS 310 - 01
 * Professor Healey
 * Project 3: N-_Grams and Frequency Counts
 */
import java.util.*;
import java.util.Map.Entry;
import java.io.File;
import java.io.FileNotFoundException;
public class Project3Driver {

	public static void main(String[] args) throws FileNotFoundException {
		//declare variables and scanner 
		ArrayList<String> tokenizedFile = new ArrayList<>();
		String inputText;
		String insideText ="";
		Scanner userFileInput = new Scanner (System.in);
		
		//run as --> run configurations --> arguments
		//format examples:
		//C:\Users\alexf\\Desktop\pg2591-0(Grimm).txt
		//C:\Users\alexf\\Desktop\310File.txt
		inputText = args[0];
		System.out.println("The file you've entered is: " + inputText + "\n"); 
		
		//using file class and scanner to read user's .txt file 
		File file = new File(inputText);
		//display error if file not found
		if(!file.exists()) {
			System.out.println("Error: File not found.");
			System.out.println("Right click on project3Driver.java");
			System.out.println("Run as --> Run Configurations --> arguments --> enter file directory");
			System.out.print("Please enter directory of your file as follows: ");
			System.out.println("C:\\Users\\alexf\\Desktop\\310File.txt");
			System.exit(0);
		}
		
		userFileInput = new Scanner (file);
		
		//reading the file and adding text to string
		while(userFileInput.hasNext()) {
			insideText += " " + userFileInput.nextLine();
		}
		
		//change string to all lower case
		insideText = insideText.toLowerCase();

		StringTokenizer tokens = new StringTokenizer(insideText);
		
		//storing each token into an arraylist
		while(tokens.hasMoreTokens()) {
			tokenizedFile.add(tokens.nextToken());
		}
		
		userFileInput.close();
		
		//creating Frequency object with degree 1
		FrequencyCount wordsDegOne = new FrequencyCount (tokenizedFile, 1);
		
		//display output
		System.out.println("Frequency Object, Degree 1");
		System.out.println("--------------------------");
		
		//displaying head method results
		System.out.println("---Head method---");
		List<Entry<String, Integer>> sortedList = new LinkedList<Entry<String,Integer>>(wordsDegOne.head());
		int counter = 0;
		//while loop to only print 20 of most values
		while (counter < 20) {
			System.out.println(sortedList.get(counter));
			counter++;
		}
		
		//display tail method results
		System.out.println();
		System.out.println("---Tail Method---");
		sortedList = new LinkedList<Entry<String,Integer>>(wordsDegOne.tail());
		counter = 0;
		//while loop to only print 20 of least values
		while (counter < 20) {
			System.out.println(sortedList.get(counter));
			counter++;
		}
		
		//display results of randomToken Method -- degree 1
		System.out.println();
		System.out.println("---Random Method---");
		System.out.println("Your random word is: " + wordsDegOne.randomToken());
		
		//display count method -- degree 1
		System.out.println();
		String randWord = wordsDegOne.randomToken();
		System.out.println("---Count Method---");
		System.out.println("Checking the count of the word: \"" + randWord + "\"");
		System.out.println("Count Number: " + wordsDegOne.count(randWord));
		
		//display percent method results with a random word from list  -- degree 1
		System.out.println();
		randWord = wordsDegOne.randomToken();
		System.out.println("---Percent Method---");
		System.out.println("Checking percentage of the word \"" + randWord + "\"");
		System.out.printf("Percent: %2.4f%%\n", wordsDegOne.percent(randWord));
		
		//display add method results with a random word from the list -- degree 1
		System.out.println();
		randWord = wordsDegOne.randomToken();
		System.out.println("---Add Method---");
		System.out.println("\"" + randWord + "\" count BEFORE add: " + wordsDegOne.count(randWord));
		//adding word four times; randWords count should be +4 now
		wordsDegOne.add(randWord);
		wordsDegOne.add(randWord);
		wordsDegOne.add(randWord);
		wordsDegOne.add(randWord);
		System.out.println("\"" + randWord +   "\" count AFTER add: " + wordsDegOne.count(randWord));
		
		
		//Creating frequency object with degree of 4
		System.out.println();
		System.out.println("Frequency Object, Degree 4");
		System.out.println("--------------------------");
		FrequencyCount wordsDegFour = new FrequencyCount (tokenizedFile, 4);

		//display results of head method -- degree 4
		System.out.println("---Head method---");
		sortedList = new LinkedList<Entry<String,Integer>>(wordsDegFour.head());
		counter = 0;	
		while (counter < 20) {
			System.out.println(sortedList.get(counter));
			counter++;
		}
			
		//display results of tail method -- degree 4
		System.out.println();
		System.out.println("---Tail Method---");
		sortedList = new LinkedList<Entry<String,Integer>>(wordsDegFour.tail());
		counter = 0;
		while (counter < 20) {
			System.out.println(sortedList.get(counter));
			counter++;
		}
		
		//display results of random method -- degree 4
		System.out.println();
		System.out.println("---Random Method---");
		System.out.println("Your random word is: " + wordsDegFour.randomToken());
		
		//display results of count method with random word -- degree 4
		System.out.println();
		randWord = wordsDegFour.randomToken();
		System.out.println("---Count Method---");
		System.out.println("Checking the count of the word: \"" + randWord + "\"");
		System.out.println("Count Number: " + wordsDegFour.count(randWord));
		
		//display results of percent method with random word -- degree 4
		System.out.println();
		randWord = wordsDegFour.randomToken();
		System.out.println("---Percent Method---");
		System.out.println("Checking percentage of the word \"" + randWord + "\"");
		System.out.printf("Percent: %2.4f%%\n", wordsDegFour.percent(randWord));
		
		//display results of add method with random word -- degree 4
		System.out.println();
		randWord = wordsDegFour.randomToken();
		System.out.println("---Add Method---");
		System.out.println("\"" + randWord + "\" count BEFORE add: " + wordsDegFour.count(randWord));
		wordsDegFour.add(randWord);
		wordsDegFour.add(randWord);
		wordsDegFour.add(randWord);
		wordsDegFour.add(randWord);
		System.out.println("\"" + randWord +   "\" count AFTER add: " + wordsDegFour.count(randWord));
		
	}//end main
}//end class
