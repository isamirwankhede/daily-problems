import java.util.*;;

public class PrefixOfWord {

    public static int isPrefixOfWord(String sentence, String searchWord){
        String words[] = sentence.split(" ");


        for( int i=0 ; i<words.length ; i++){
            if(words[i].startsWith(searchWord)) return i+1;

        }


        return -1;


    }

    public static void main(String[] args) {
        String sentence = "this problem is an easy problem";
        String searchWord = "pro";
        // String searchWord = "burg";
        System.out.println(isPrefixOfWord(sentence, searchWord));
    }

}