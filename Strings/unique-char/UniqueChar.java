public class UniqueChar {
    static int firstUniqueChar(String s ){
        // int n = s.length();
        
        int freq [] = new int[26];
        char chars [] = s.toCharArray();

        for(char c : chars ){
            freq[c - 'a']++;

        }

        for(int i =0 ; i< chars.length ; i++){
            if(freq[chars[i] - 'a'] == 1 ) return i;
        }

        return -1;

    }

    public static void main(String[] args) {
        String s = "leetcode";
        System.out.println(firstUniqueChar(s));
    }
    
}