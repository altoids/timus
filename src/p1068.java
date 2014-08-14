import java.util.*;

public class p1068 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sIn = new Scanner(System.in);
		int bound = sIn.nextInt();
		int step = bound >=1?1:-1;
		int total = 0;
		for (int i = 1; bound >=1?i<=bound:i>=bound;i+=step){
			total += i;
		}
		System.out.println(total);
		sIn.close();
	}

}
