/**
 * yoshika takezawa
 * i pledge my honor that I have abided by the Stevens honor system. ytakezaw
 */
package tree_heap;

import java.util.Random;
import java.util.Stack;

public class Treap<E extends Comparable<E>> {
	private class Node<E>{
		//data fields
		public E data;
		public int priority;
		public Node<E> left;
		public Node<E> right;
		
		//constructors
		public Node(E data, int priority) {
			if (data == null) {
				throw new IllegalArgumentException();
			}
			this.data = data;
			this.priority = priority;
			this.right = null;
			this.left = null;
		}
		
		//methods
		/**
		 * old root goes to the right, new root from oldroot's left
		 * @return new root
		 */
		public Node<E> rotateRight(){
			Node<E> newRoot = this.left;
			this.left =newRoot.right;
			newRoot.right = this;
			return newRoot;
		}
		/**
		 * old root moves to the left, new root from oldroot's right
		 * @return new root
		 */
		public Node<E> rotateLeft(){
			Node<E> newRoot = this.right;
			this.right = newRoot.left;
			newRoot.left = this;
			return newRoot;
		}
		
		public boolean isLeaf(){
			return ((this!=null) && (this.left==null) && (this.right==null));
		}
		
		public String toString() {
			return "data= " + this.data + ", priority= " + this.priority;
		}
	}
	
	
	//data fields
	private Random priorityGenerator;
	private Node<E> root;
	
	//constructors
	public Treap() {
		priorityGenerator = new Random();
	}
	public Treap(long seed) {
		priorityGenerator = new Random(seed);
	}
	
	//methods
	
	public boolean add(E key) {
		//creates the random priority and then calls add(key, prior)
		if (find(key)) {
			return false;
		}
		int  priority = priorityGenerator.nextInt();
		return add(key, priority);
	}
	/**
	 * find the proper place for the new node based on a bst and the data elements
	 * reheaps the tree based on priorities
	 * @param key given char to add
	 * @param priority random number to add with key
	 * @return true if can add key, false if key already exists
	 */
	public boolean add(E key, int priority) {
		if (key == null) {
			throw new IllegalArgumentException();
		}
		if (root == null) { //adding to an empty tree
			root = new Node<E> (key, priority);
			return true;
			
		}else {			//adding to existing tree
			Stack<Node<E>> path = new Stack<Node<E>>();
			Node<E>search = root;
			while (search!= null) {
				path.push(search);
				int comparison = key.compareTo(search.data);
				if (comparison >0) {// key>search goes right
					if (search.right == null) { //
						search.right = new Node <E> (key, priority);
						reheap(search.right, path);
						return true;
					}
					search = search.right;
				}else if (comparison < 0){ //key<search, goes left
					if (search.left == null) {
						search.left = new Node<E> (key, priority);
						reheap(search.left, path);
						return true;
					}
					search = search.left;
				}
			}
		}
		return false;
	}
	/**
	 * fixes the treap.. or rather reheaps the treap. hohohohooooo 
	 * @param n is a leaf at the beginning and trying to go up in life. wow what a story amirite
	 * @param path stack of the path taken thus far. 
	 */
	private void reheap(Node<E> n, Stack<Node<E>> path) {
		while (!path.isEmpty()) {
			Node<E> topOfStack = path.pop();
			if (topOfStack.priority< n.priority) {
				if (topOfStack.data.compareTo(n.data) > 0) {
                    n = topOfStack.rotateRight();
				}else {
                    n = topOfStack.rotateLeft();
				}
				if (!path.isEmpty()) {
                    if (path.peek().left == topOfStack) {
                        path.peek().left = n;
                    }else {
                        path.peek().right = n;
                    }
				}else {
                    root = n;
				}
			}else { //stack is empty, no need for reheaping 
				break;
			}
		}
	}
	
	public boolean delete(E key) {
		if (!find(key)) {
			return false;
		}
		root = delete(key, root);
		return true;
	}
	
	/**
	 * deletes node with key from tree
	 * @param key node we want to delete
	 * @param n node is rooted at
	 * @return if it is possible to delete the node
	 */
	private Node<E> delete (E key, Node<E> n) {
		if (n == null) {
			return n;
		}
		else {
			int comparison = key.compareTo(n.data);
			if (comparison <0) { //key is less than n
				n.left = delete(key, n.left);
			}else if (comparison > 0) { // key is greater than n
				n.right = delete(key, n.right);
			}
			
			//key is found
			else if (n.left == null) { //left is null
				Node<E> temp = n.right;
				n = temp;
			}else if (n.right == null) { // right is null
				Node<E> temp = n.left;
				n = temp;
			}else if (n.left.priority < n.right.priority) { //rigth is greater than left
				n = n.rotateLeft();
				n.left = delete(key, n.left);
			}else { // right is less than left
				n = n.rotateRight(); 
				n.right = delete(key, n.right);
			}
			return n;
		}
	}
	
	private boolean find(Node<E> root, E key) {
		while (root != null) {
			int comparison = root.data.compareTo(key);
			if (comparison == 0) { //root == key
				return true;
			}else if (comparison <0) { //root>key, goes right
				root= root.right;
			}else{ //root <key, goes left
				root = root.left;
			}
		}
		return false;
	}
	
	public boolean find(E key) {
		return find(root, key);
	}
	
	public String toString() {
		return toString(root, 0);
	}
	private String toString(Node<E> n, int depth) {
		StringBuilder r = new StringBuilder();
		// add indentation
		for (int i=0;i<depth;i++) {
			r.append("--");
		}
		if (n==null) {
			r.append("null");
		} else {
			r.append(n.toString());
			r.append("\n");
			r.append(toString(n.right, depth+1));
			r.append("\n");
			r.append(toString(n.left, depth+1));
		}
		return r.toString();
	}
	
	public static void main(String[] args) {
//		Treap<Integer> testTree = new Treap <Integer>();
//		
//		testTree.add (4 ,19);
//		testTree.add (2 ,31);
//		testTree.add (6 ,70);
//		testTree.add (1 ,84);
//		testTree.add (3 ,12);
//		testTree.add (5 ,83);
//		testTree.add (7 ,26);
//		System.out.println(testTree.delete(1));
	}
}
