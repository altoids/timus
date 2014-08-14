import java.io.IOException;
import java.util.*;


public class P1005 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Scanner sIn = new Scanner(System.in);
		int len = Integer.parseInt(sIn.nextLine().trim());
		if (len <=0){
			return;
		}
		String[] sN = sIn.nextLine().trim().split(" ");
		int[] a = new int[len];
		for (int i = 0; i< len; i++){
			a[i] = Integer.parseInt(sN[i]);
		}
		if (len == 1){
			System.out.println(a[0]);
			return;
		}
		// real work
		// sort array
		
		Integer[] indexArray = new Integer[len];
		int mindiff = Integer.MAX_VALUE;
		for (int i = 1; i< len/2+1; i++){
			Arrays.fill(indexArray, 0);
			int tempdiff = getC(indexArray, i,0, a);
			if (tempdiff < mindiff)
				mindiff = tempdiff;
		}
		sIn.close();
		System.out.println(mindiff);
	}
	
	private static int getC(Integer[] a, int count, int start, int[] values){
		int mindiff = Integer.MAX_VALUE;
		if (count == 1){
			int leftsum = 0;
			int rightsum = 0;
			for (int j = 0; j<a.length;j++){
				if (a[j] ==1)
					leftsum += values[j];
				else 
					rightsum += values[j];
			}
			for (int i = start; i<a.length; i++){
				if (a[i] != 1){
					leftsum += values[i];
					rightsum -= values[i];
					if (Math.abs(leftsum - rightsum) < mindiff)
						mindiff = Math.abs(leftsum - rightsum);
					leftsum -= values[i];
					rightsum += values[i];
					
				}
			}
			return mindiff;
		}
		
		for (int i = start; i<a.length; i++){
			if (a[i] != 1){
				a[i] = 1;
				int tempdiff = getC(a,count -1,i, values);
				if (tempdiff < mindiff)
					mindiff = tempdiff;
				a[i] = 0;
			}
		}
		
		return mindiff;
	}
}
