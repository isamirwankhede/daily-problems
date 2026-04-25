public class CheckDIff {
    public static char findTheDifference(String s , String t ){

        // int total = 0;
       
        // for(int i =0 ;i< t.length() ; i++){
        //     total += t.charAt(i);
            
        // }

        // for(int i =0 ;i< s.length() ; i++){
        //     total -= s.charAt(i);
            
        // }

        
        // return (char)total;
        int xor =0 ;
        for (char c : s.toCharArray()) {
         xor ^= c ;
           
        }
        for (char c : t.toCharArray()) {
         xor ^= c ;
           
        }

        return (char) xor ;

    }



    public static void main(String[] args) {
        String s = "abcd";
        String t = "abcde";
        
        System.out.println(findTheDifference(s , t));

    }
}