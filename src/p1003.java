import java.io.*;
import java.util.*;

//Parity
public class p1003 {
	HashMap<Integer, Boolean>  exist;
	HashMap<Integer, Boolean>  odd;
	HashMap<Integer, Integer>  prev;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		p1003 p = new p1003();
		Scanner sIn = new Scanner(System.in);
		while(p.judgeOneSeq(sIn));
	}
	
	private boolean judgeOneSeq(Scanner sIn) throws IOException{
		int sequenceLength = Integer.parseInt(sIn.nextLine().trim());
		if (sequenceLength < 0)
			return false;
		exist = new HashMap<Integer, Boolean>();
		odd = new HashMap<Integer, Boolean>();
		prev = new HashMap<Integer, Integer>();
		int numberOfQuestions = Integer.parseInt(sIn.nextLine().trim());
		boolean isPossible = true;
		
		for (int i = 1; i<=numberOfQuestions; i++){
			String oneline = sIn.nextLine().trim();
			if (!isPossible)
				continue; //finish reading the rest for the batch
			String[] temp = oneline.split(" ");
			int start = Integer.parseInt(temp[0]);
			int end = Integer.parseInt(temp[1]);
			if (start < 1 || start > sequenceLength || end < 1 || end > sequenceLength || start > end)
				isPossible = false;
			isPossible &= add(start, end, !temp[2].toLowerCase().equals("even"));
			if (!isPossible)
				System.out.println(i-1);
		}
		
		exist = null;
		odd = null;
		prev = null;
		if (isPossible)
			System.out.println(numberOfQuestions);
		return true;
	}
	
	private boolean add(int start, int end,  boolean isOdd){//b>=a;
	    if (!exist.containsKey(end)){
	      exist.put(end, true);
	      odd.put(end, isOdd);
	      prev.put(end, start);
	      return true;
	    };
	    int  i = prev.get(end);
	    if(i==start) return (odd.get(end)==isOdd);
	    if(i<start) return add(i,start-1, (isOdd!=odd.get(end)));
	    return add(start,i-1, (isOdd!=odd.get(end)));
	}
}
