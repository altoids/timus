import java.util.Scanner;

/*
 * Let’s consider K-based numbers, containing exactly N digits. We define a number to be valid if its K-based notation doesn’t contain two successive zeros. For example:

    1010230 is a valid 7-digit number;
    1000198 is not a valid number;
    0001235 is not a 7-digit number, it is a 4-digit number. 

Given two numbers N and K, you are to calculate an amount of valid K based numbers, containing N digits.
You may assume that 2 ≤ K ≤ 10; N ≥ 2; N + K ≤ 18.
Input
The numbers N and K in decimal notation separated by the line break.
Output
The result in decimal notation.
Sample
input	output

2
10

	

90

 */

// f(1) = k-1
// f(2) = k*(k-1)
// f(N) = (f(N-1) + f(N-2)) * (k-1)
public class p1009 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sIn = new Scanner(System.in);
		int digits = sIn.nextInt();
		int k = sIn.nextInt();
		int fn_2 = k-1;
		int fn_1 = k* (k-1);
		int fn = fn_1;
		for (int i = 3; i<=digits; i++){
			fn = (fn_1 + fn_2) * (k -1);
			fn_2 = fn_1;
			fn_1 = fn;
		}
		System.out.println(fn);
	}
}
