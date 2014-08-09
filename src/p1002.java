import java.util.*;
public class p1002 {
	HashMap<String, String> hm = null;
	HashMap<String, String> hmPartialResults = null;
	
	public static void main(String[] args) {
		p1002 solution = new p1002();
		Scanner sIn = new Scanner(System.in);
		while (solution.PhoneNumber(sIn));
	}
	
	private boolean PhoneNumber(Scanner sIn) {
		String targetStr = sIn.nextLine().trim();
		if (targetStr.equals("-1")){
			return false;
		}
		int numberOfWords = Integer.parseInt(sIn.nextLine().trim());
		hm = new HashMap<String, String>();
		hmPartialResults = new HashMap<String, String>();
		for (int i = 0; i< numberOfWords; i++){
			String strWord = sIn.nextLine().trim();
			String strNumber = convertToNumber(strWord);
			if (!hm.containsKey(strNumber)){
				hm.put(strNumber, strWord);
			}
		}
		String oneResult = match(targetStr);
		if (oneResult != null)
			System.out.println(oneResult);
		else 
			System.out.println("No solution.");
		
		hm = null;
		hmPartialResults = null;
		return true;
	}
	
	private String match(String targetNumber){
		if (targetNumber.isEmpty())
			return "";
		if (hmPartialResults.containsKey(targetNumber))
			return hmPartialResults.get(targetNumber);
		int minWordCount = Integer.MAX_VALUE;
		String localResult = null;
		for (int i = targetNumber.length(); i>0; i--){
			String localsub = targetNumber.substring(0,i);
			if (hm.containsKey(localsub)){
				String subResult = match(targetNumber.substring(i, targetNumber.length())); 
				if ( subResult != null){
					String temp = hm.get(localsub) + " " + subResult;
					int tempcount =temp.split(" ").length; 
					if ( tempcount < minWordCount){
						localResult = temp;
						minWordCount = tempcount;
					}
				}
			}
		}
		hmPartialResults.put(targetNumber, localResult);
					
		return localResult;
	}
	
	private String convertToNumber(String word){
		String result = "";
		for (int i = 0; i< word.length(); i++){
			result += mappingCharToNum(word.charAt(i));
		}
		return result;
	}
	
	private String mappingCharToNum(char ch){
		switch (ch){
		case 'i': case 'j':
			return "1";
		case 'a': case 'b':	case 'c':
			return "2";
		case 'd': case 'e':	case 'f':
			return "3";
		case 'g': case 'h':
			return "4";
		case 'k': case 'l':
			return "5";
		case 'm': case 'n':
			return "6";
		case 'p': case 'r': case 's':
			return "7";
		case 't': case 'u':	case 'v':
			return "8";
		case 'w': case 'x':	case 'y':
			return "9";
		case 'o': case 'q':	case 'z':
			return "0";
		}
		return "-1";
	}

}
