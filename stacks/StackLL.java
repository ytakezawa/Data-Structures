package stacks;

import java.util.EmptyStackException;

public class StackLL <E> implements StackInt<E>{
	
	public class Node<E>{
		//data fields
		private E data;
		private Node<E> next;
		
		Node(E item){
			data = item;
			next = null;
			
		}
		
		Node (E item, Node<E> next ){
			data= item;
			this.next = next;
		}
		
	}
	//data fields
	private Node<E> topmost;
	private int size;
	
	//constructor
	StackLL(){
		topmost = null;
		size =0;
	}
	
	//methods
	public E push (E item) {
		topmost = new Node<E>(item, topmost);
		size++;
		return item;
	}
	
	public E peek() {
		if (empty()) {
			throw new EmptyStackException();
		} else {
			return topmost.data;
		}
	}
	
	public E pop() {
		if (empty()) {
			throw new EmptyStackException();
		}else {
			E temp = topmost.data;
			topmost = topmost.next;
			size --;
			return temp;
		}
	}
	
	public boolean empty() {
		return topmost == null;
	}
	
	public static void main(String[] args) {
		StackInt<Integer> s = new StackLL<Integer>();
		
		s.push(1);
		s.push(2);
		s.push(3);
		
		System.out.println(s.pop());
		System.out.println(s.pop());
		System.out.println(s.pop());
	}
	
}
