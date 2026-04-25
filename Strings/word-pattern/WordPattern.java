import java.util.*;

public class WordPattern {

    public static boolean wordPattern(String pattern, String s) {
        String arr[] = s.split(" ");

        if(pattern.length() != arr.length){
            return false;
        }

        HashMap<Character , String> mpp = new HashMap<>();

        for(int i=0 ; i<pattern.length() ; i++){
            char ch = pattern.charAt(i);

            boolean containsKey = mpp.containsKey(ch);
            
            if(mpp.containsValue(arr[i]) && !containsKey) return false;
            if(containsKey &&  !mpp.get(ch).equals(arr[i])) return false;
            else {
                mpp.put(ch,arr[i]);
            }

        }

        return true;

         
    }

    public static void main(String[] args) {
        String s = "dog cat cat dog";
        String pattern = "abba";
        System.out.println(wordPattern( pattern , s));
    }
}