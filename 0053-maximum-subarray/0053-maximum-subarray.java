class Solution {
    public int maxSubArray(int[] nums) {
        // this is solved by using the kadanes algo:
        // algo : keep count current sum and if neeegative enter then update this to the 0;
        
        int currSum =0 ;
        int maxSum = nums[0];


        for(int num : nums){
            currSum += num;
            maxSum = Math.max(currSum , maxSum);

            if(currSum <0) currSum =0;
        }

        return maxSum;
    }
}