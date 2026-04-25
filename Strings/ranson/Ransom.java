public class Ransom {

    public static boolean canConstruct(String ransomNote , String magazine){
        int freq[] = new int [26];

        for(char ch : magazine.toCharArray()){
            freq[ch - 'a']++;
        }

        for(char ch : ransomNote.toCharArray()){
            if(freq[ch - 'a'] == 0) return false;
            freq[ch - 'a']--;


        }

        return true;
    }
    public static void main(String[] args) {
        String ransomNote  = "aab";
        String magazine   = "aab";
        System.out.println(canConstruct(ransomNote , magazine));

    }
    
}