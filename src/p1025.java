import java.util.*;

public class p1025 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sIn = new Scanner(System.in);
		int K = sIn.nextInt();
		int[] groupSize = new int[K];
		for (int i = 0; i< K; i++)
			groupSize[i] = sIn.nextInt();
		
		Arrays.sort(groupSize);
		int totalHalves = 0;
		for (int i = 0; i<=K/2; i++){
			totalHalves += (groupSize[i]+1)/2;
		}
		
		System.out.println(totalHalves);
		sIn.close();

	}

}
