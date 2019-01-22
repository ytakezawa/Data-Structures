package queues;

import java.util.Arrays;
import java.util.NoSuchElementException;

import queues.QueueLL.Node;

public class QueueC<E> {
	
	//circular array 
	
	
	//data fields
	private E[] data;
	private int front;
	private int rear;
	private int capacity;
	private int size;
	private static final int INITIAL_CAPACITY = 10;
	
	//constructor 
	QueueC() {
		data = (E[])new Object[INITIAL_CAPACITY];
		size = 0;
		front = 0;
		rear = 0;
		capacity = INITIAL_CAPACITY;
	}
	
	//methods
	/**
	 * @return entry at front without removing it, if queue is empty return Exception
	 * @throws Exception 
	 */
	public E element() throws Exception {
		if (size == 0) { //the array is empty
			throw new NoSuchElementException();
		}
		return data[front];
	}
	
	
	public void resize() {
		E[] temp = (E[])new Object[capacity *2]; // makes a new array
		
		for (int i = 0; i<size; i++) {
			temp[i]= data[front +1];
		}
		
		capacity = capacity *2;
		data = temp;
		front = 0;
		rear = size-1;
		
	}
	
	
	
	/**
	 * insert an item at the rear of the queue,,, resizing the array
	 * @param item
	 * @return
	 */
	public boolean offer(E item) {
		if (size == capacity) { // array is full and resize array
			resize();
		}
		rear = (rear +1) % capacity;
		data[rear] = item;
		size ++;
		return true;
	}
	
	/**
	 * removes an entry from the front of the queue if it is not empty.
	 * if empty, throws exception
	 * @return entry at front of the queue
	 */
	public E remove() {
		if (size ==0) {
			throw new NoSuchElementException();
		}else {
			
			E temp = data[front];
			front = (front + 1) % capacity;
			size --;
			return temp;
		}
	}
	
	
	
	/**
	 * returns the size of the queue
	 * @return
	 */
	public int size() {
		return size;
	}
	
	
	public String toString() {
		return Arrays.toString(data);
	}
	
	
	
	//recursion/memoization
	public static double ffib(double old, double current, double n) {
		if (n<=1) {
			return current;
		}else {
			return ffib(current, current+old, n-1);
		}
	}
	
	
//	//filter even return odds........ put this in nodeInt
//	public QueueC filterEven() {
//		if (next == null;) {
//			if (data%2 == 0) {
//				return null;
//			}else {
//				return this;
//			}
//		}else {
//			if (data%2 ==0) {
//				return next.filterEven();
//			}else {
//				next = next.filterEven();
//				return this;
//			}
//		}
//	}
	
	
	public static void main(String [] args){
		
		System.out.println(ffib(1, 1, 55));
		
//		QueueC<Integer> q = new QueueC<Integer>();
//		
//		for (int i = 0; i<10; i++) {
//			q.offer(i);
//		}
//		System.out.println(q);
//		System.out.println(q.front);
//		System.out.println(q.rear);
//		q.remove();
//		System.out.println(q);
//		System.out.println(q.front);
//		System.out.println(q.rear);
//		
//		q.remove();
//		q.remove();
//		q.remove();
//		
//		q.offer(11);
//		q.offer(12);
	}
}
