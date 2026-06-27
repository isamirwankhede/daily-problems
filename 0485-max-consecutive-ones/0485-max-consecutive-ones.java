class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int n = nums.length;

        int currCnt = 0;
        int maxCnt = 0;

        for (int i = 0; i < n; i++) {
            if (nums[i] == 1) {
                currCnt++;
                

            } else {
                maxCnt = Math.max(maxCnt, currCnt);
                currCnt = 0;

            }
        }

        return Math.max(maxCnt, currCnt);

    }
}