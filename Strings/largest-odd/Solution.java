public class Solution {
    private static String largestOddNumber(String num) {
        int n =num.length()-1;

        while( n >=0){
            int d = num.charAt(n) -'0';
            if( d % 2 != 0) return num.substring(0 , n+1);
            n--;
        }

        return "";
    }
    public static void main(String[] args) {
        String num = "35427";
        System.out.println(largestOddNumber(num));
        
    }
}