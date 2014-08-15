import java.util.Scanner;


public class p1083 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sIn = new Scanner(System.in);
		int base = sIn.nextInt();
		String ban = sIn.next().trim();
		int k = ban.length();
		int result = base;
		while (base > k){
			 result = result * (base - k);
			 base = base - k;
		}
		System.out.println(result);

	}

}
