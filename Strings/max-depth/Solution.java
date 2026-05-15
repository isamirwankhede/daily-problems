class Solution {

    private static int maxDepth(String s) {
        // code here
        int curr= 0;
        int res = 0;
        for(char ch : s.toCharArray()){

            if(ch == '('){
                curr++;
                res = Math.max(res, curr);

            } 
            if(ch == ')') curr--;

        }


        return res ;
    }

    public static void main (String args[]){
        String  s = "((5+2)(3+4)((6)))";
        System.out.println(maxDepth(s));

    }
}