public class LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        String st = s.trim();
        int cnt = 0;
    
        for(int i = st.length() -1 ; i >= 0 ; i--){
            if(st.charAt(i) != ' ') cnt++;
            else break;
        }

        return cnt ;

    }
    
    public static void main(String[] args) {
        LengthOfLastWord l = new LengthOfLastWord();

        String str =  "   fly me   to   the moon  ";
        System.out.println(l.lengthOfLastWord(str));
    }
    
}