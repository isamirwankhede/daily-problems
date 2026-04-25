// package Strings.isomorphic;

import java.util.HashMap;

public class Isomorphic {
    public static boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> mpp = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            if (mpp.containsKey(s.charAt(i))) {
                if (mpp.get(s.charAt(i)) != t.charAt(i))
                    return false;
            } else {
                if (mpp.containsValue(t.charAt(i)))
                    return false;
                mpp.put(s.charAt(i), t.charAt(i));
            }
        }

        return true;

    }

    public static void main(String[] args) {
        String s = "paper";
        String t = "title";
        System.out.println(isIsomorphic(s, t));

    }
}