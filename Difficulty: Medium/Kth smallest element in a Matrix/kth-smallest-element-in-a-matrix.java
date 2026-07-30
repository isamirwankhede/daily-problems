class Solution {
    public int kthSmallest(int[][] mat, int k) {
        // code here
        int n = mat.length;
        
        int low = mat[0][0];
        int high = mat[n-1][n-1];
        
        while(low<=high){
            int mid = low+(high-low)/2;
            int cnt = cntLessEqual(mat , n , mid);
            if(cnt <k)low = mid+1;
            else high = mid-1;
            
        }
        
        return low;
        
    }
    
    private int cntLessEqual(int[][] mat, int n , int target){
        int row = n-1;
        int col = 0;
        int cnt=0;
        
        while(row >=0 && col<n){
            if(mat[row][col] <= target){
                cnt += (row+1);
                col++;
            }else{
                row--;
            }
        }
        
        return cnt;
        
    } 
}
