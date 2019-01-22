package stacks;

import java.util.EmptyStackException;

public class BalancedChecker {
	private static final String OPEN = "({[";
	private static final String CLOSE = ")}]";
	
	public static boolean isOpen (Character c) {
		return OPEN.indexOf(c)>-1;
	}
	
	public static boolean isClosed (Character c) {
		return CLOSE.indexOf(c)>-1;
	}
	
	public static boolean isBalanced(String str) {
		boolean balanced = true;
		int i = 0;
		StackLL<Character> s = new StackLL<Character>();
		
		try {
		while (balanced && i < str.length()) {
			if (isOpen(str.charAt(i))) {
				s.push(str.charAt(i));
			}else { //char at i is closing delimiter
				Character c = s.pop();
				balanced = balanced && CLOSE.indexOf(str.charAt(i)) == OPEN.indexOf(c);
			}
			i++;
		}
		}catch (EmptyStackException e) {
			balanced = false;
		}
		
		return balanced && s.empty();
	}
	
	public static void main (String[] args) {
		System.out.println(isBalanced("(())"));
		System.out.println(isBalanced("())"));
		System.out.println(isBalanced("([])"));
		System.out.println(isBalanced("(([)])"));

	}
}
