class Solution {
    public int maxWater(int height[]) {
        // code here
        int n =  height.length;
        int left=0;
        int right=n-1;
        int maxLeft= height[left];
        int maxRight= height[right];
        int water=0;
        
        
        while(left < right){
            if(maxLeft < maxRight){
                left++;
                maxLeft=Math.max(maxLeft , height[left]);
                water += maxLeft - height[left];
            }
            else{
                right--;
                maxRight=Math.max(maxRight , height[right]);
                water += maxRight - height[right];
            }
        }
        return water;
    }
}
