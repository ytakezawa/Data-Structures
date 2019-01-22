package linkwork;
//Exercise Booklet #3

import lists.NodeInt;

public class SingleLinkedList<E> {
	private class Node<E>{
		//data fields
		private E data;
		private Node<E> next;
		
		//constructors
		Node(E data){
			this.data = data;
		}
		Node (E data, Node<E> next){
			this.data = data;
			this.next = next;
		}
	}
	private Node<E> head;
	private int size;
	SingleLinkedList(){
		head = null;
		size = 0;
	}
	
	private boolean add (E item) {
		head = new Node<E> (item, head);
		return true;
	}
	
	private boolean isSingleton() {
		// returns if the list is of length one;
		Node<E> current = head;
		int size =0;
		while (current != null) {
			current = current.next;
			size ++;
		}
		if (size ==0 || size >=2) { // list is not length 1
			return false;
		}else { 					// list is length 1
			return true;
		}
	}
	
	
	private boolean allEven() {
		boolean allE = true;
		Node<E> current = head;
		while (current != null) {
			if ((int)(current.data)%2 == 1) {	//item is odd and breaks the loop
				allE = false;
				break;
			}else {								//item is even and continues the loop
				allE = true ;
				current = current.next;
			}
		}
		return allE;
	}
	
	
	private Integer sumL() {
		Node<E> current = head;
		int sum = 0;
		while (current != null) {
			sum += (int)current.data;
			current = current.next;
		}
		return sum;
	}
	
	
	private boolean noDuplicates() {
		Node<E> current = head;
		while (current != null) {
			while (current.next != null) {
				if ((int) current.data == (int)current.next.data) { //current == current.next and immediately return false
					return false;
				} else {											// current != current.next and coninues to look
					current.next = current.next.next;
				}
			}
			current = current.next;
		}
		// nothing is the same so, there must be no duplicates
		return true;
	}
	
	
	
	private Node copy() {
		Node<E> current = head;
		Node<E> result = new Node(null);
		Node<E> head = result;
		
		while (current != null) {
			result.next = new Node(current.data);
			result = result.next;
			current = current.next;
		}
		return head.next;
	}
	
	
	private Node append(E node1, E node2) {
		//LOOK UP HOW TO HANDLE TWO NODES HELPPP
		Node<E> current = head;
		Node<E> result = new Node(null);
		Node<E> head = result;
		while (current != null) {
			
		}
		return head.next;
	}
	
	
	public String toString() {
		Node current = head;
		StringBuilder str = new StringBuilder();
		str.append("the list is ");
		while ( current != null) {
			str.append(current.data.toString());
			str.append(" ");
			current = current.next;
		}
		return str.toString();
	}
	
	
	public static void main(String[] args) {
		SingleLinkedList<Integer> n = new SingleLinkedList<Integer>();
		n.add(7);
		n.add(8);
		n.add(9);
		n.add(10);
		
//		System.out.println("Singleton? " + n1.isSingleton());
//		System.out.println("Numbers even? " + n3.allEven());
//		System.out.println("Sum: " + n3.sumL());
//		System.out.println("No duplicates? " + n4.noDuplicates());
//		System.out.println(n4);
//		SingleLinkedList bob = n4.copy();
//		SingleLinkedList dude = new SingleLinkedList(28, bob); // when you add a new item, you add it to the "front";
//		System.out.println(dude); 
	}
}



