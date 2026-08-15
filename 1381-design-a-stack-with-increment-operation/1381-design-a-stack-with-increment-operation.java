class CustomStack {
    int stack[];
    int index;
    int maxSize;

    public CustomStack(int maxSize) {
        this.maxSize = maxSize;
        stack = new int [maxSize];
        index = -1;

    }
    
    public void push(int x) {
        if(index == maxSize-1){
            return;
        }
        index++;
        stack[index] = x;
    }
    
    public int pop() {
        if(index == -1){
            return -1;
        }
        int val = stack[index];
        index--;
        return val;

    }
    
    public void increment(int k, int val) {
        int limit = Math.min(k , index+1);
        for(int i=0 ;i < limit ;i++){
            stack[i] += val;
        }
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */