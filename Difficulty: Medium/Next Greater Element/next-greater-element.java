class Solution {
    public ArrayList<Integer> nextLargerElement(int[] arr) {
        // code here
        int n = arr.length;
        
        ArrayList<Integer> ans = new ArrayList<>();
        
        for(int i =0; i< n;i++){
            ans.add(-1);
        }
        Stack<Integer> stack = new Stack<>();
        
        for(int i = n-1; i>=0; i--){
            while(!stack.isEmpty() && stack.peek() <= arr[i]){
                stack.pop();
            }
            
            if(!stack.isEmpty()){
                ans.set(i , stack.peek());
            }
            
            stack.push(arr[i]);
        }
        
        return ans;
    }
}