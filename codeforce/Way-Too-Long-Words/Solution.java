import java.util.Scanner;

public class Solution {

    private static String shortString(String s) {

        if (s.length() <= 10) {
            return s;
        }

        return "" + s.charAt(0) + (s.length() - 2) + s.charAt(s.length() - 1);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {

            String s = sc.next();

            System.out.println(shortString(s));
        }

        sc.close();
    }
}