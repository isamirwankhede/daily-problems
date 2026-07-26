import java.util.*;

class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int low = 0, high = 0;

        for (int w : weights) {
            low = Math.max(low, w); // this is max (arr)
            high += w; // this is sum of all as a high value
        }

        int ans = 0;

        while (low <= high) {
            int cap = low + (high - low) / 2; // this is mid as a capacity

            if (canShip(weights, days, cap)) {
                ans = cap;
                high = cap - 1;
            } else {
                low = cap + 1;
            }
        }

        return ans;

    }

    private boolean canShip(int[] weights, int days, int cap) {
        int day = 1;
        int sum = 0;

        for (int w : weights) {
            if (sum + w > cap) {
                day++;
                sum = w;
            } else {
                sum += w;
            }
        }
        return day <= days;
    }
}