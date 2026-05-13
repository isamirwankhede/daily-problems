import java.util.Scanner;

public class Solution {
	
	public static String capitalize (String s ) {
		
		StringBuilder sb = new StringBuilder();
		
		String firstLetter = s.substring(0 , 1 ).toUpperCase();
		sb.append(firstLetter);
		
		String remString = s.substring(1);
		
		sb.append(remString);
		
 		return sb.toString();
		
	}
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		String s = scanner.next();
		System.out.println(capitalize(s));
	}
}
