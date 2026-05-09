public class Solution {

    private static String removeOuterParentheses(String s ){
        StringBuilder sb = new StringBuilder();
        int cnt =0;
        int n = s.length();
        for(int i=0 ; i<n ; i++ ){
            if(s.charAt(i) == ')') cnt--;

            if(cnt != 0)
            sb.append(s.charAt(i));

            if(s.charAt(i) == '(') cnt++;


        }


        return sb.toString();
    }
    public static void main(String[] args) {
        String s = "(()())(())(()(()))";
        System.out.println(removeOuterParentheses(s));

    }
}