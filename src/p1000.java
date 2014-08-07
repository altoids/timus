import java.io.*;

public class p1000 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		// read the console line
		BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
	    String[] s = bufferRead.readLine().split(" ");
	    if (s.length != 2)
	    	return;
	    else
	    	System.out.println(Integer.parseInt(s[0]) + Integer.parseInt(s[1]));

	}

}
