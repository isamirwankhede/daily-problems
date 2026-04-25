class Equivalent{
    public static boolean equivalent(String s1 , String s2){
        int freq[] = new int[26];

        for(int i =0 ; i< s1.length(); i++){
            freq[s1.charAt(i) - 'a']++;
            freq[s2.charAt(i) - 'a']--;
        }

        for (int i = 0; i < freq.length; i++) {
            if(Math.abs(freq[i]) > 3) return false;

        }

        return true;
    }
    public static void main (String args[]){
        String s1 = "aaaa";
        String s2 = "bccb";
        System.out.println(equivalent(s1 , s2));

    }
}