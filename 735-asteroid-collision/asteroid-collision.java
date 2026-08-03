class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        List<Integer> list = new ArrayList<>();
        for (int x : asteroids)
            list.add(x);

        int i = 0;

        while (i < list.size() - 1) {
            int a = list.get(i);
            int b = list.get(i + 1);

            if (a > 0 && b < 0) {
                if (Math.abs(a) > Math.abs(b)) {
                    list.remove(i + 1);
                } else if (Math.abs(a) < Math.abs(b)) {
                    list.remove(i);
                    if (i > 0)
                        i--;

                } else {
                    list.remove(i + 1);
                    list.remove(i);
                    if (i > 0)
                        i--;

                }
            } else
                i++;
        }

        int ans[] = new int[list.size()];

        for (int j = 0; j < list.size(); j++) {
            ans[j] = list.get(j);
            
        }

        return ans;
    }
}