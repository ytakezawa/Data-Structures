/**
 * 
 * @author Yoshika Takezawa
 * CS284 A RC
 * 
 * 2/3/18
 * 
 * Uses BIG endian format, as in the smallest value is at the right and the largest value is at the left
 * 
 * BTW: for the shiftR method, I assumed format(big-endian/little endian) did not matter
 * 
 */


public class BinaryNumber {
	//Data fields
	private int data[];
	private boolean overflow;
	
	
	//Constructor
	/**
	 * Creates a new array with the size of length and 
	 * fills each spot with a 0.
	 * @param length is the length of the binary number
	 * @throws Exception if length is equal to or less than 0
	 */
	public BinaryNumber(int length) throws Exception {
		data = new int [length];
		if (length < 0){
			throw new Exception("Please enter a nonnegative number for the length.");
		}
		//only length >0
		for (int i = 0; i<length; i++) {
			data[i] = 0;
		}
		
	}
	
	
	/**
	 * Converts all string's characters to integers
	 * and places them in each space in data.
	 * @param str is the binary NUmber in string format
	 */
	public BinaryNumber(String str) throws Exception{
		data = new int[str.length()];
		if (!(str instanceof String)) {
			throw new Exception("Please enter a string");
		}
		for (int i = 0; i<=str.length()-1; i++) {
			int num = Character.getNumericValue(str.charAt(i));
			//the if statement below checks if all digits are valid
			if (!(num == 1 || num == 0)) {
				throw new Exception("This is not binary. Oh no.");
			}
			data[i] = num;
		}
	}
	
	
	/**
	 * determines the length of the binary number
	 * @return data's length
	 */
	public int getLength() {
		return data.length;
	}
	
	
	/**
	 * obtains the digit in a given index.
	 * @param index
	 * @return the digit in a given index
	 * @throws Exception the index is not b/w 0 and data.length-1
	 */
	public int getDigit(int index) throws Exception  {
		try {
			return data[index];
		}
		catch(IndexOutOfBoundsException e){
			throw new Exception("Index out of bounds");
		}
	}
	
	
	//methods
	
	/**
	 * shifts all digits in a binary number any places to the right.
	 * @param amount is the amount to shift
	 * @throws Exception  if the length is negative
	 */
	public void shiftR(int amount) throws Exception {
		int[] newData = new int [(data.length + amount)];
		if (amount<0) {
			throw new Exception("Enter a nonnegative number.");
		}
		for (int i=0; i<amount; i++) {
			newData[i]=0;
		}
		for (int i=0; i< data.length; i++) {
			newData[amount+i]= data[i];
		}
		data = newData;
	}
	
	
	/**
	 * adds two binary numbers together
	 * @param aBinaryNumber-- a new, different binary number
	 * @throws Exception  if the lengths of the binary numbers are not equal
	 */
	public void add(BinaryNumber aBinaryNumber) throws Exception {
		int carry = 0;
		int [] temp = new int [data.length];
		int total =0;
		
		if (aBinaryNumber.getLength() != data.length) {
			throw new Exception("The binary numbers need to be the same length");
		}
		else {
			for (int ind = data.length-1 ; ind>=0; ind--) {
				total = getDigit(ind) + aBinaryNumber.getDigit(ind)+carry;
				if (total== 2) {
					carry = 1;
					temp[ind] = 0;
				}
				else if (total ==3) {
					carry = 1;
					temp[ind] = 1;
				}
				else if (total <= 1) {
					carry=0;
					temp[ind] = total;
				}
			}
		}
		if (carry >= 1) {
			overflow = true;
		}
		else {
			overflow = false;
		}
		data = temp;
		
	}
	
	
	public String toString() {
		String str = "";
		if (overflow ==true) {
			 str = "Overflow!! ";
		}
		for (int i= 0; i<data.length; i++) {
			str += data[i];
		}
		return str;
	}
	
	
	/**
	 * transforms a binary number to its decimal notation.
	 * @return the decimal notation of the binary num
	 * @throws Exception (from get Digit) the index can only be b/w 0 and the length-1
	 */
	public int toDecimal() throws Exception {
		int total = 0;
		int num = 0;
		for (int i=0; i<data.length; i++) {
			num = getDigit(data.length -i -1);
			total += num * Math.pow(2, i);
		}
		return total;
	}
	
	
	public void clearOverflow() {
		overflow = false;
	}
	
	
	public static void main (String[] args) throws Exception {
		BinaryNumber A = new BinaryNumber("1010");
		BinaryNumber B = new BinaryNumber("0111");
		System.out.println(A);
		System.out.println(B);
		System.out.println(A.getDigit(3));
		System.out.println(B.getDigit(3));
		A.shiftR(3);
		B.shiftR(3);
		System.out.println(A);
		System.out.println(B);
		A.add(B);
		System.out.println(A);
		System.out.println(A.toDecimal());
		System.out.println(B.toDecimal());
	}

}
