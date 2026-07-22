class Solution {
    public int searchInsertK(int arr[], int k) {
        // code here
        int left=0;
        int right=arr.length-1;

        while(left <= right){
            int mid = left + (right-left)/2;
            if(arr[mid] == k) {
                return mid;
            }
            else if (arr[mid] > k) {
                right = mid-1;
            }
            else {
                left = mid+1;
            }
        }

        return left;
    }
};