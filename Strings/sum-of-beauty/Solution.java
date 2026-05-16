public class Solution {

    private static int maxFreq(int freq[]) {
        int maxcnt = 0;
        for (int i = 0; i < freq.length; i++) {
            maxcnt = Math.max(maxcnt , freq[i]);

        }


        return maxcnt;

    }

     private static int minFreq(int freq[]) {
        int mincnt = Integer.MAX_VALUE;
        for (int i = 0; i < freq.length; i++) {
            if(freq[i] != 0){
                mincnt = Math.min(mincnt , freq[i]);
            }

        }


        return mincnt;
        
    }
    private  static int beautySum(String s) {
        int n = s.length();
        int sum  = 0;

        
        for(int i =0 ; i<  n ; i++){
            int freq[] = new int[26];
            for(int j =i ; j< n ; j++){
                freq[s.charAt(j) - 'a']++;
                int beauty = maxFreq(freq) - minFreq(freq);
                sum += beauty;

            }

        }

        return sum;

    } 


    public static void main(String[] args) {
        String s  = "aabcb";
        System.out.println(beautySum(s));


    }
}