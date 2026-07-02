class Solution {
    public int totalFruit(int[] fruits) {
        int ans = 0;
        int left =0;
        HashMap<Integer , Integer> mpp = new HashMap<>();

        for(int right = 0 ; right < fruits.length; right++){
            //cnt the freq / update the freq 
            mpp.put(fruits[right] , mpp.getOrDefault(fruits[right] , 0) +1);

            while(mpp.size() >2){

                // we remove one freq and update into map
                mpp.put(fruits[left] , mpp.get(fruits[left]) -1);
                //if freq == 0 then we remove the element
                if(mpp.get(fruits[left]) == 0){
                    mpp.remove(fruits[left]);
                }
                // window shrinking by doing left++
                left++;
            }

            //cnt the legnth anad update into ans;
            
            ans = Math.max(ans , right - left +1);
        }

        return ans;
        
    }
}