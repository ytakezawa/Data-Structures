package stacks;

public class PalindromeChecker {
	//data fields
	private String inputStr;
	private StackInt<Character> charStack;
	
	//constructor
	PalindromeChecker(String str){
		inputStr = str;
		charStack = new StackLL<Character>();
		fillStack(str);
	}
	
	private void fillStack(String s) {
		for (int i = 0; i<s.length(); i++) {
			if (s.charAt(i)!= ' ') {
				charStack.push(s.charAt(i));
			}
		}
	}
	
	private String buildReverse() {
		StringBuilder str = new StringBuilder();
		
		while(!charStack.empty()) {
			str.append(charStack.pop());
		}
		
		return str.toString();
	}
	
	public boolean isPalindrome() {
		//return inputStr.equalsIgnoreCase(buildReverse());
		boolean result = false;
		String reverseStr = buildReverse();
		int j =0;
		
//		for (int i = 0; i < reverseStr.length(); i ++) {
//		}
		return false;
	}
	
	public static void main(String[] args){
		PalindromeChecker pc = new PalindromeChecker("kayak");
		PalindromeChecker pc2 = new PalindromeChecker("kayaK");
		PalindromeChecker pc3 = new PalindromeChecker("kaya k");
		PalindromeChecker pc4 = new PalindromeChecker("cayak");
		
		System.out.println(pc.isPalindrome());
		System.out.println(pc2.isPalindrome());
		System.out.println(pc3.isPalindrome());
		System.out.println(pc4.isPalindrome());
	}
}
