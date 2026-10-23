class Solution {
    public int sortPermutation(int[] nums) {
        int n = nums.length;

        // If already sorted -> k = 0
        boolean sorted = true;
        for (int i = 0; i < n; i++) {
            if (nums[i] != i) { sorted = false; break; }
        }
        if (sorted) return 0;

        boolean[] vis = new boolean[n];
        int ans = -1;  // all bits set

        for (int i = 0; i < n; i++) {
            if (!vis[i] && nums[i] != i) {
                int curAnd = -1;

                // walk the cycle starting at i
                int j = i;
                while (!vis[j]) {
                    vis[j] = true;
                    curAnd &= nums[j];
                    j = nums[j];
                }

                ans &= curAnd;
            }
        }
        // Always possible at least with k = 0; we want the maximum k
        return Math.max(0, ans);

    }
}