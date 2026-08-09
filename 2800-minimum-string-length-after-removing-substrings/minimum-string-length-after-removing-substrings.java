class Solution {
    public int minLength(String s) {
        StringBuilder sb = new StringBuilder();

        for (char ch : s.toCharArray()) {
            int len = sb.length();

            if (len > 0 && ch == 'B' && sb.charAt(len - 1) == 'A') {
                sb.deleteCharAt(len - 1);
            } else if (len > 0 && ch == 'D' && sb.charAt(len - 1) == 'C') {
                sb.deleteCharAt(len - 1);
            } else {
                sb.append(ch);
            }
        }

        return sb.length();
    }
}