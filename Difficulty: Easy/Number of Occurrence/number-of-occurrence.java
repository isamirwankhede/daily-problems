class Solution {
	int countFreq(int[] arr, int target) {
		// code here
		
		int first = firstOccur(arr, target);
		if (first == -1)
			return 0;
		int last = lastOccur(arr, target);
		
		return last - first + 1;
		
	}
	
	int firstOccur(int[] nums, int target) {
		int left = 0, right = nums.length - 1;
		int ans = -1;
		while (left <= right) {
			int mid = left + (right - left)/2;
			
			if (nums[mid] == target) {
				ans = mid;
				right = mid - 1;
			}
			else if (nums[mid] < target) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		
		return ans;
		
	}
	int lastOccur(int[] nums, int target) {
		int left = 0, right = nums.length - 1;
		int ans = -1;
		while (left <= right) {
			int mid = left + (right - left)/2;
			
			if (nums[mid] == target) {
				ans = mid;
				left = mid + 1;
			}
			else if (nums[mid] < target) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		
		return ans;
		
	}
}
