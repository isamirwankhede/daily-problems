class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = 0;

        for (int p : piles) {
            high = Math.max(p, high);
        }
        int ans = high;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (canEat(piles, h, mid)) {
                ans = mid;
                high = mid - 1;
            }

            else {
                low = mid + 1;
            }

        }

        return ans;
    }

    private boolean canEat(int[] piles, int h, int k) {
        long hrs = 0;

        for (int p : piles) {
            hrs += (p + k - 1) / k;

        }

        return hrs <= h;
    }

    public int timeReq(int[] arr, int hrs) {
        int totalHr = 0;
        for (int i = 0; i < arr.length; i++) {
            totalHr += (int) Math.ceil((double) arr[i] / hrs);
        }

        return totalHr;

    }

}