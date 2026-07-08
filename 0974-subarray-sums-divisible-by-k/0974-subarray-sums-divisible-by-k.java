class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        HashMap<Integer, Integer> mpp = new HashMap<>();

        int cnt = 0;
        int prefixSum = 0;
        mpp.put(0, 1);

        for (int num : nums) {
            prefixSum += num;
            int rem = prefixSum % k;

            if (rem < 0)
                rem += k;

            if (mpp.containsKey(rem)) {
                cnt += mpp.get(rem);
            }
            mpp.put(rem, mpp.getOrDefault(rem, 0) + 1);

        }

        return cnt;
    }
}