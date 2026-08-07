class Solution {
    public boolean backspaceCompare(String s, String t) {
        return build(s).equals(build(t));
    }

    private String build(String s) {
        Stack<Character> st = new Stack<>();

        for (char ch : s.toCharArray()) {
            if (ch == '#') {
                if (!st.isEmpty()) {
                    st.pop();
                }
            }
             else {
                    st.push(ch);
                }
        }

        StringBuilder ans = new StringBuilder();
        for (char c : st) {
            ans.append(c);
        }

        return ans.toString();

    }
}