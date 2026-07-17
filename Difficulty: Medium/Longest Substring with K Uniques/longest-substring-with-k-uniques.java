import java.util.*;
class Solution {
	public int longestKSubstr(String s, int k) {
		// code here
		Map<Character, Integer> map = new HashMap<>();
		
		int left = 0;
		int maxLen = -1;
		
		for (int right = 0 ; right < s.length() ; right++) {
			char ch = s.charAt(right);
			map.put(ch, map.getOrDefault(ch, 0) + 1);
			
			while (map.size() > k) {
				char c = s.charAt(left);
				map.put(c, map.get(c) - 1);
				
				if (map.get(c) == 0){
					map.remove(c);
				}
				left++;
				
			}
			if (map.size() == k) {
				maxLen = Math.max(maxLen, right - left + 1);
			}
		}
		
		return maxLen;
	}
}
