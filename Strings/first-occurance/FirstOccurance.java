public class FirstOccurance {
    public static int strStr(String haystack, String needle) {
        for( int i =0 ; i < haystack.length() - needle.length() +1 ; i++){
            if (haystack.charAt(i) == needle.charAt(0)) {
                if(haystack.substring(i, needle.length() +i).equals(needle)){
                    return i;
                }
            }


        }
        return -1;
    }

    public static int advancedStr(String haystack, String needle){
        return haystack.indexOf(needle);
    }
    public static void main(String[] args) {
        System.out.println(advancedStr("sadbutsad",  "but"));
    }
}