class Solution {
    private boolean isAllocate(int[] arr, int k , int maxAns) {
        int split = 1;
		int Sum = 0;
		
		for (int el : arr) {
			if (Sum + el <= maxAns) {
				Sum += el;
			} else {
				split++;
				Sum = el;
			}
		}
		
		return split <= k;

    }

    public int splitArray(int[] arr, int k) {
        if (k > arr.length) return -1;

        int low = Integer.MIN_VALUE;
        int high = 0;

        for (int a : arr) {
            low = Math.max(low, a);
            high += a;
        }

        
        int res = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (isAllocate(arr, k  ,mid)) {
                res = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return res;
    }
}