public class BalancedString {
    public static boolean isBalanced(String num) {
        int evenSum = 0;
        int oddSum = 0;

        for(int i =0 ; i< num.length() ; i++){
            if(i % 2 == 0) evenSum += num.charAt(i) - '0';
            else oddSum += num.charAt(i) - '0';
        }


        if(evenSum == oddSum ) return true;
        else return false;
    }
    public static void main(String[] args) {
        String s = "1232";
        System.out.println(isBalanced(s));
    }
}