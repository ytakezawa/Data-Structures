package queues;

import java.util.NoSuchElementException;

public class QueueLL<E> {
	public class Node<E> {
		//data fields
		private E data;
		Node<E> next;
		
		//constructor
		Node(E item){
			data = item;
			next = null;
		}
		Node(E item, Node<E> next){
			data = item;
			this.next = next;
		}
	}
	
	//dtaa fields
	Node<E> front;
	Node<E> rear;
	int size = 0;
	
	//constructor
	QueueLL(){
		front = null;
		rear = null;
		size = 0;
	}
	
	
	//methods 
	/**
	 * @return entry at front without removing it, if queue is empty return Exception
	 */
	public E element() {
		// IllegalStateException
		if (front == null) {
			throw new NoSuchElementException();
		} 
		return front.data;
	}
	
	/**
	 * insert an item at the rear of the queue
	 * @param item
	 * @return
	 */
	public boolean offer(E item) {
		if (front == null) {
			front = new Node<E> (item);
			rear = front;
		}else {
			rear.next = new Node<E>(item);
			rear = rear.next;
		}
		size ++;
		return true;
	}
	
	/**
	 * removes an entry from the front of the queue if it is not empty.
	 * if empty, throws exception
	 * @return entry at front of the queue
	 */
	public E remove() {
		if (front ==null) { //the queue is empty
			throw new NoSuchElementException();
		} else { //queue not empty
			E temp = front.data;
			front = front.next;
			if (front == null) { //if queue is empty after removal, set rear to null;
				rear = null;
			}
			size --;
			return temp;
		}
	}
	
	public E remove2() {
		// !!!!! FIND TIME COMPLEXITY: O(n) because the while loop , everything else is a fixed amount of time
		//time complexity for remove (first method): O(constant) no for loops and what not
		if (front ==null) { //queue is empty
			throw new NoSuchElementException();
		}
		if (front == rear) { // queue is a singleton
			E temp = front.data;
			front = null;
			rear = null;
			size = 0;
			return temp;
		}
		//the queue has two or more items
		Node<E> current = rear;
		while (current.next != front) {
			current= current.next;
		}
		E temp = front.data;
		current.next = null;
		front = current;
		size --;
		return temp;
		
	}
	
	/**
	 * return first elemnent
	 * @return
	 */
	public E poll() {
		return front.data;
	}
	
	
	/**
	 * returns the size of the queue
	 * @return
	 */
	public int size() {
		return size;
	}
	
	
	public String toString() {
		StringBuilder s = new StringBuilder();
		s.append("<");
		Node<E> current = front;
		
		while(current != null) {
			s.append(current.data);
			current = current.next;
		}
		
		return s.toString();
	}
	
	public static void main(String [] args){
		QueueLL<Integer> q = new QueueLL<Integer>();
		
		q.offer(1);
		q.offer(2);
		q.offer(3);
		
		System.out.println(q);
		
		System.out.println(q.remove());
		System.out.println(q.remove());
		System.out.println(q.remove());
		
		q.offer(4);
		
		System.out.println(q);
	}
}
