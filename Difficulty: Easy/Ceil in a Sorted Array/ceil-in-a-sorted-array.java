class Solution {
    public int findCeil(int[] arr, int x) {
        // code here
        int left=0 , right = arr.length-1;
        int ans=-1;
        
        while(left <= right){
            int mid = left +(right-left)/2;
            
            if(arr[mid] >= x){
                right = mid-1;
                ans =mid;
                
            }else{
                left = mid+1;
                
            }
        }
        
        return ans;
    }
}
