/**
 * yoshika takezawa
 * I pledge my honor that i have abided by the stevens honor system
 */
package anagrams;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Anagrams {
	//data fields 
	final Integer[] primes= {2 , 3 , 5 , 7, 11 , 13 , 17 ,
			19 , 23 , 29 , 31 , 37 , 41 , 43 , 47 , 53 , 59 , 61 ,
			67 , 71 , 73 , 79 , 83 , 89 , 97 , 101};
	Map<Character, Integer> letterTable ; // primes to chars,, 2==a, 3==b, 5==c etc
	Map<Long, ArrayList<String>> anagramTable = new HashMap<Long, ArrayList<String>>();
	
	//methods
	public Anagrams() {
		buildLetterTable();
	}
	
	/**
	 * builds the table, brick by brick
	 * go get your shovel 
	 * and we'll dig a deep hole
	 * to bury the castle, bury the castle.
	 * this comment has been brought to you by paramore
	 */
	private void buildLetterTable() {
		letterTable = new HashMap<Character, Integer>();
		letterTable.put('a', primes[0]);
		letterTable.put('b', primes[1]);
		letterTable.put('c', primes[2]);
		letterTable.put('d', primes[3]);
		letterTable.put('e', primes[4]);
		letterTable.put('f', primes[5]);
		letterTable.put('g', primes[6]);
		letterTable.put('h', primes[7]);
		letterTable.put('i', primes[8]);
		letterTable.put('j', primes[9]);
		letterTable.put('k', primes[10]);
		letterTable.put('l', primes[11]);
		letterTable.put('m', primes[12]);
		letterTable.put('n', primes[13]);
		letterTable.put('o', primes[14]);
		letterTable.put('p', primes[15]);
		letterTable.put('q', primes[16]);
		letterTable.put('r', primes[17]);
		letterTable.put('s', primes[18]);
		letterTable.put('t', primes[19]);
		letterTable.put('u', primes[20]);
		letterTable.put('v', primes[21]);
		letterTable.put('w', primes[22]);
		letterTable.put('x', primes[23]);
		letterTable.put('y', primes[24]);
		letterTable.put('z', primes[25]);
	}
	
	/**
	 * applies hashcode function and places 
	 * hashcode as key and s as the value (arraylist)
	 * if the key already exists, that is it is an anagram, 
	 * it adds to the value- arraylist
	 * 
	 * joke: Edward had trouble with addWord haaaHAHA get it? cuz edward addword?
	 * in retrospect that was not funny at all. im so sorry.
	 * @param s
	 */
	protected void addWord(String s) {
		long hashCode = myHashCode(s);
		if (anagramTable.containsKey(hashCode)) { //key already exists
			anagramTable.get(hashCode).add(s);
		}else {		//key does not exist
			ArrayList<String> temp = new ArrayList<String>();
			temp.add(s);
			anagramTable.put(hashCode, temp);
		}
		return;
	}
	
	/**
	 * given  a string and outputs a hashcode, all anagrams should have the same hashcode.
	 * multiply all the characters of a string --> hashcode
	 * @param s -- string given to handle
	 * @return the hashcode of string s
	 * 
	 * or if you will, myHaHaHaHashCode, or myHashBrown, or my#
	 */
	private long myHashCode(String s) {
		if (s == null) {
			throw new IllegalArgumentException();
		}
		int wordLen = s.length();
		long product = 1;
		for (int i =0; i<wordLen; i++) {
			product *= letterTable.get(s.charAt(i));
		}
		return product;
	}
	
	
	/**
	 * processes file/ dictionary given and adds each word to the table
	 * @param s
	 * @throws IOException
	 * 
	 * man, these nonGMO people are now cracking down on processedFiles now
	 */
	private void processFile(String s) throws IOException {
		FileInputStream fstream = new FileInputStream (s );
		BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
		String strLine;
		while((strLine = br.readLine()) != null) {
			this.addWord(strLine);
		}
		br.close();
		}
	
	/**
	 * looks through every item in anagramTable and keeps the 
	 * entry with the most amount of anagrams
	 * if equal, adds to the array list
	 * @return list of entrie(s) with the most amount of anagrams
	 * 
	 * this function is analogous to taking Max's diary entries and seeing
	 * what word he used the most
	 */
	protected ArrayList<Map.Entry<Long, ArrayList<String>>> getMaxEntries(){
		int largest=0;
		ArrayList<Map.Entry<Long, ArrayList<String>>> max = new ArrayList<Map.Entry<Long, ArrayList<String>>>();
		for (Map.Entry<Long,ArrayList<String>> entry : anagramTable.entrySet()) {
			int newLen = entry.getValue().size();
			if (newLen == largest) { //two or more entries are the max
				max.add(entry);
			}else if (newLen >largest) { //new larger entry
				max.clear();
				max.add(entry);
				largest = newLen;
			}//do nothing is temp is < largest
		}
		return max;
		
	}
	
	/**
	 * toString method: found online, just needed to test my code somehow
	 */
//	public String toString() {
//		String result = anagramTable.entrySet()
//		            .stream()
//		            .map(entry -> entry.getKey() + " - " + entry.getValue())
//		            .collect(Collectors.joining(", "));
//		return result;
//	}
	
	public static void main(String[] args) {
//		Anagrams a = new Anagrams();
//		final long startTime = System.nanoTime();
//		try{
//			a.processFile("words_alpha.txt");
//		}catch (IOException e1) {
//			e1.printStackTrace();
//		}
//		ArrayList<Map.Entry<Long, ArrayList<String>>> maxEntries = a.getMaxEntries();
//		final long estimatedTime = System.nanoTime()- startTime;
//		final double seconds = ((double) estimatedTime /1000000000);
//		System.out.println (" Time : "+ seconds );
//		
//		System.out.println (" List of max anagrams : "+ maxEntries );
		
		
		Anagrams map = new Anagrams();
		map.addWord("alter");
		map.addWord("later");
		map.addWord("alert");
		map.addWord("otatop");
		map.addWord("tatopo");
		map.addWord("potato");
		map.addWord("pleaseworkireallywantthistowork");
		map.addWord("youlovelymustard");
		System.out.println(map);
		ArrayList<Map.Entry<Long, ArrayList<String>>> maxEntries = map.getMaxEntries();
		System.out.println(maxEntries);
	}
}
