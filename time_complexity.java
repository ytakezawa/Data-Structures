/*
 * CS284 HW2
 * Yoshika Takezawa
 * 
 * note: the counter counts then outputs 
 */
public class time_complexity {
	public static void method1(int n) {
		//time complexity O(n^2)
		int counter = 0;
		for (int i = 0; i<n; i++) {
			for (int j = 0; j<n; j++) {
				counter ++;
				System.out.println("Operation " + counter);
			}
		}
	}
	
	public static void method4(int n) {
		//time complexity O(n^3)
		int counter = 0;
		for (int i = 0; i<n; i++) {
			for (int j = 0; j<n; j++) {
				for (int k = 0; k<n; k++) {
					counter ++;
					System.out.println("Operation " + counter);
				}
			}
		}
	}
	
	public static void method2(int n) {
		//time complexity O(log n)
		//for checking: rounds up, best to use 2^n numbers
		int counter = 0;
		for ( int i =1; i<n; i*=2) {
			counter ++;
			System.out.println("Operation " + counter);
		}
	}
	
	public static void method3(int n) {
		//time complexity O(n log n)
		//for checking: best to use 2^n numbers 
		// to ensure that rounding doesn't occur.
		int counter = 0;
		for (int i = 0; i<n; i++) {
			for (int j = 1; j< n; j*=2) {
				counter ++;
				System.out.println("Operation " + counter);
			}
		}
	}
	
	public static void method5(int n) {
		//time complexity O(log log n)
		int counter = 0;
		for (int i = 1; i<n; i*=2) {
			counter ++;
			System.out.println("Operation " + counter);
			int j = (int) Math.pow(2, i);
			n= n/j;
		}
	}
	
	
	
	public static void main (String[] args) {
		//method1(55);
		//method4(77);
		//method2(8);
		//method3(64);
		//method3(8);
		
		//method5(257);
		//method6(3);
		
	}
}
