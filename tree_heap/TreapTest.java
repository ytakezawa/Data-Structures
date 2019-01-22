package tree_heap;
//yoshika takezawa
//i pledge my honor that i have abided by the Stevens honor system

import static org.junit.Assert.*;

import org.junit.Test;

public class TreapTest {
	Treap <Integer> empt = new Treap<Integer>();
	Treap<Integer> single = new Treap<Integer> ();
	Treap<Integer> t = new Treap<Integer> ();
	
	public void setUp() {
		single.add (4, 19);
		t.add (4 ,19);
		t.add (2 ,31);
		t.add (6 ,70);
		t.add (1 ,84);
		t.add (3 ,12);
		t.add (5 ,83);
		t.add (7 ,26);
	}
	
	//test to check add
	@Test
	public void Test01() {
		setUp();
		//tests the empty tree
		assertEquals( "null" , empt.toString());
		
		//tests the singleton
		String goodS = "data= 4, priority= 19\n"
				+ "--null\n"
				+ "--null";
		assertEquals(goodS, single.toString());
		
		//tests the several-noded tree
		String goodT = "data= 1, priority= 84\n" + 
				"--data= 5, priority= 83\n" + 
				"----data= 6, priority= 70\n" + 
				"------data= 7, priority= 26\n" + 
				"--------null\n" + 
				"--------null\n" + 
				"------null\n" + 
				"----data= 2, priority= 31\n" + 
				"------data= 4, priority= 19\n" + 
				"--------null\n" + 
				"--------data= 3, priority= 12\n" + 
				"----------null\n" + 
				"----------null\n" + 
				"------null\n" + 
				"--null";
		assertEquals(goodT, t.toString());
		
		//tests if several noded tree can refuse duplicates
		assertEquals(false, t.add(4));
		
	}
	
	//test to check delete
	@Test
	public void Test02() {
		setUp();
		//delete from an empty tree
		assertEquals(false, empt.delete(4));
		
		//delete from singleton
		single.delete(4);
		assertEquals("null", single.toString());
		
		//delete root from several noded tree
		t.delete(1);
		String goodTr = "data= 5, priority= 83\n" + 
				"--data= 6, priority= 70\n" + 
				"----data= 7, priority= 26\n" + 
				"------null\n" + 
				"------null\n" + 
				"----null\n" + 
				"--data= 2, priority= 31\n" + 
				"----data= 4, priority= 19\n" + 
				"------null\n" + 
				"------data= 3, priority= 12\n" + 
				"--------null\n" + 
				"--------null\n" + 
				"----null";
		assertEquals(goodTr, t.toString());
		
		//delete node from several noded tree
		t.delete(2);
		String goodTre = "data= 5, priority= 83\n" + 
				"--data= 6, priority= 70\n" + 
				"----data= 7, priority= 26\n" + 
				"------null\n" + 
				"------null\n" + 
				"----null\n" + 
				"--data= 4, priority= 19\n" + 
				"----null\n" + 
				"----data= 3, priority= 12\n" + 
				"------null\n" + 
				"------null";
		assertEquals(goodTre, t.toString());
	}
	
	
	//test to check find
	@Test
	public void Test03() {
		setUp();
		
		//find key in an empty tree
		assertEquals(false, empt.find(4));
		
		//find key in a singleton
		assertEquals(true, single.find(4));
		
		//find a nonexistent key in several noded tree
		assertEquals(false, t.find(77));
		
		//find a key in a several noded tree
		assertEquals(true, t.find(7));
		assertEquals(true, t.find(6));
	}
}
