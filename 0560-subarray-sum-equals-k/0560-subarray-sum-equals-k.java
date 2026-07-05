class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> mpp = new HashMap<>();

        int cnt = 0;
        int prefixSum = 0;

        mpp.put(0, 1);

        for (int num : nums) {
            prefixSum += num;

            if (mpp.containsKey(prefixSum - k)) {
                cnt += mpp.get(prefixSum - k);

            }
            mpp.put(prefixSum, mpp.getOrDefault(prefixSum, 0) + 1);

        }

        return cnt;

    }
}