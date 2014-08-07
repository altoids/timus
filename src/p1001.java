

import java.io.IOException;
import java.util.Scanner;
import java.util.*;

public class p1001 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Scanner scanIn = new Scanner(System.in);
		LinkedList<Long> l = new LinkedList<Long>();
		
		while (scanIn.hasNextLine()){
			String sar[] = scanIn.nextLine().split("\\s+");
			for (String s : sar){
				if(s.length() > 0)
					l.addFirst(Long.parseLong(s));
			}
		}
		for (Long lnum : l)
			System.out.println(Math.sqrt(lnum));
		
		scanIn.close();
	}

}
