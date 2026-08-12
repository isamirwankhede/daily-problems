class Solution {
    public int longestValidParentheses(String s) {
        int left = 0, right = 0, max = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(')
                left++;
            else
                right++;

            if (left == right)
                max = Math.max(max, 2 * right);
            else if (right > left)
                right = left = 0;
        }

        right = left = 0;
        for (int i = s.length()-1; i >= 0; i--) {
            if (s.charAt(i) == '(')
                left++;
            else
                right++;

            if (left == right)
                max = Math.max(max, 2 * right);
            else if (left > right)
                right = left = 0;
        }

        return max;

    }
}