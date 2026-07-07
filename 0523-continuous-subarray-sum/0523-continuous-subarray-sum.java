class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        int n = nums.length;

        HashMap<Integer, Integer> mpp = new HashMap<>();
        mpp.put(0 , -1);
        int prefixSum = 0;

        for (int i = 0; i < n; i++) {
            prefixSum += nums[i];

            int rem = prefixSum % k;

            if (mpp.containsKey(rem)) {
                if (i - mpp.get(rem)  >= 2) {
                    return true;
                }
            } else {
                mpp.put(rem, i);

            }
        }

        return false;
    }
}