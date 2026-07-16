class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int left = 0;
        int maxLen = 0;
        // sliding window
        for (int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);
            map.put(ch, map.getOrDefault(ch, 0) + 1);

            // shrinking
            while (map.get(ch) > 1) {
                char leftCh = s.charAt(left);
                map.put(leftCh, map.get(leftCh) - 1);
                left++;

            }
            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;

    }
}