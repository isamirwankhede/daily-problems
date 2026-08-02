class Solution {
    public ArrayList<Integer> calculateSpan(int[] arr) {
        // code here
        int n = arr.length;
        ArrayList<Integer> ans = new ArrayList<>();
        
        Stack<Integer> stack = new Stack<>();
        
        for(int i =0 ; i< n; i++){
            while(!stack.isEmpty() && arr[stack.peek()] <= arr[i]) stack.pop();
            
            if(stack.isEmpty()) ans.add(i+1);
            else ans.add(i - stack.peek());
            stack.push(i);
        }
        
        return ans;
        
    }
}