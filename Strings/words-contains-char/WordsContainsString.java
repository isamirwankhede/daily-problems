import java.util.*;
class WordsContainsString {

    public static List<Integer> findWordsContaining(String[] words, char x) {
        ArrayList<Integer> ans = new ArrayList<>();

        for (int i = 0; i < words.length; i++) {
            if (words[i].contains(String.valueOf(x))) {
                ans.add(i);
            }


        }

        return ans;
    }

    public static void main(String[] args) {
        String[] str = { "leet", "code" };
        char x = 'e';
        System.out.println(findWordsContaining(str, x));

    }

}