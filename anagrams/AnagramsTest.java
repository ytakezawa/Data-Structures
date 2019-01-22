package anagrams;
/**
 * yoshika takezawa
 * i pledge my honor that i have abided by the stevens honor system
 */

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Map;

import org.junit.Test;

public class AnagramsTest {
	
	
	
	//test to see if max entries can handle one max
	@Test
	public void test01() {
		Anagrams map = new Anagrams();
		map.addWord("alter");
		map.addWord("later");
		map.addWord("alert");
		map.addWord("otatop");
		map.addWord("tatopo");
		map.addWord("pleaseworkireallywantthistowork");
		map.addWord("youlovelymustard");
		ArrayList<Map.Entry<Long, ArrayList<String>>> maxEntries = map.getMaxEntries();
		
		assertEquals("[3525434=[alter, later, alert]]", maxEntries.toString());
	}
	
	//test to see if it can handle multiple maxes
	@Test
	public void test02() {
		Anagrams map = new Anagrams();
		map.addWord("alter");
		map.addWord("later");
		map.addWord("alert");
		map.addWord("otatop");
		map.addWord("tatopo");
		map.addWord("potato");
		map.addWord("pleaseworkireallywantthistowork");
		map.addWord("workireallywantthistoworkplease");
		map.addWord("ireallywantthistoworkpleasework");
		map.addWord("youlovelymustard");
		ArrayList<Map.Entry<Long, ArrayList<String>>> maxEntries = map.getMaxEntries();
		
		assertEquals("[1180370314=[otatop, tatopo, potato],"
				+ " 4049449989640551080=[pleaseworkireallywantthistowork, workireallywantthistoworkplease, ireallywantthistoworkpleasework],"
				+ " 3525434=[alter, later, alert]]", maxEntries.toString());
	}
	

}
