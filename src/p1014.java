/*
 * Your task is to find the minimal positive integer number Q so that the product of digits of Q is exactly equal to N.
Input
The input contains the single integer number N (0 ≤ N ≤ 109).
Output
Your program should print to the output the only number Q. If such a number does not exist print −1.
Sample
input	output

10

	

25

 */
import java.util.*;
public class p1014 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sIn = new Scanner(System.in);
		long N = sIn.nextLong();
		if (N ==0){
			System.out.println(10);
			return;
		} else if (N < 10)
		{
			System.out.println(N);
			return;
		}
		
		long result = 0;
		long cur = N;
		int power = 1;
		for (int i = 9; i>=2; i--){
			
			while (cur >= i && cur % i == 0){
				result +=i*power;
				power *=10;
				cur = cur / i;
			}
		}
		if (cur != 1){
			// number can not be totally divivded by i
			result = -1;
		}
		System.out.println(result);
	}

}
