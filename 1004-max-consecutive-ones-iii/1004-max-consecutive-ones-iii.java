class Solution {
    public int longestOnes(int[] nums, int k) {
        int zeroCnt =0;
        int n = nums.length;
        int left =0;
        for(int right =0; right < n; right++){
            if(nums[right] == 0){
                zeroCnt++;

            }

            if(zeroCnt > k){
                if(nums[left] == 0){
                    zeroCnt--;

                }
                left++;

            }
        }


        return n - left;

    }
}