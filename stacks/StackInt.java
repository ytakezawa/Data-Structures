package stacks;

public interface StackInt<E> {
	E push(E item);
	
	E peek();
	
	E pop();
	
	boolean empty();
}
