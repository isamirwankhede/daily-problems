class Solution {
    public String minRemoveToMakeValid(String s) {
        StringBuilder first = new StringBuilder();
        int open = 0;

        // Remove invalid ')'
        for (char ch : s.toCharArray()) {

            if (ch == '(') {
                open++;
                first.append(ch);
            } 
            else if (ch == ')') {
                if (open > 0) {
                    open--;
                    first.append(ch);
                }
            } 
            else {
                first.append(ch);
            }
        }

        // Remove extra '(' from right to left
        StringBuilder ans = new StringBuilder();

        for (int i = first.length() - 1; i >= 0; i--) {
            char ch = first.charAt(i);

            if (ch == '(' && open > 0) {
                open--;
            } 
            else {
                ans.append(ch);
            }
        }

        return ans.reverse().toString();
    }
}