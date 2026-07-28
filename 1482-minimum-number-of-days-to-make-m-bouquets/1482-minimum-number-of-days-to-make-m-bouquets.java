class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;
        if (n < (long) m * k)
            return -1;

        int minDay = Integer.MAX_VALUE;
        int maxDay = Integer.MIN_VALUE;

        for (int bloom : bloomDay) {
            minDay = Math.min(minDay, bloom);
            maxDay = Math.max(maxDay, bloom);
        }

        int low = minDay;
        int high = maxDay;

        int ans = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (isPossible(bloomDay, mid, m, k)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }

        }

        return ans;

    }

    public boolean isPossible(int[] bloomDay, int day, int m, int k) {
        int cnt = 0;
        int b = 0;

        for (int bloom : bloomDay) {
            if (bloom <= day) {
                cnt++;
                if (cnt == k) {
                    b++;
                    cnt = 0;
                }
            } else {
                cnt = 0;
            }
        }
        return b >= m;
    }
}