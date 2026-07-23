class Solution {
    public int findPeakElement(int[] nums) {
        int n = nums.length;

        int left = 0;
        int right = n-1;

        while(left < right){
            int mid = left + (right - left)/2+1;

            if(nums[mid] > nums[mid-1]){
                left = mid;

            }else{
                right = mid -1;
            }
        }

        return left;
    }
}