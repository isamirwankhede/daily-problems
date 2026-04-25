//Leetcode Link: https://leetcode.com/problems/group-anagrams/
// Youtube Solution: https://www.youtube.com/watch?v=dEMcIpBOHpg

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs.length ==0)  return new ArrayList();

        Map<String, List> ans = new HashMap<>();

        int cnt [] = new int[26];

        for(String s : strs){
            Arrays.fill(cnt , 0);
            for(char c : s.toCharArray()){
                cnt[c - 'a']++;

            }

            StringBuilder sb = new StringBuilder("");

            for( int i =0; i< 26 ; i++){
                sb.append("#");
                sb.append(cnt[i]);
            }

            String key = sb.toString() ;
            if(!ans.containsKey(key)){
                ans.put(key , new ArrayList());
            }

            ans.get(key).add(s);
            

        }
        return new ArrayList(ans.values());

    }
}