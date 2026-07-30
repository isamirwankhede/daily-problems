class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;

        int top = 0, bottom = n - 1;
        int row = -1;

        while (top <= bottom) {
            int mid = (top + bottom) / 2;

            if (target >= matrix[mid][0] && target <= matrix[mid][m - 1]) {
                row = mid;
                break;
            } else if (target > matrix[mid][0]) {
                top = mid + 1;
            } else {
                bottom = mid - 1;
            }
        }

        if (row == -1)
            return false;

        int low = 0, high = m - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (matrix[row][mid] == target) {
                return true;
            } else if (matrix[row][mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return false;

    }
}