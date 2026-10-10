class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
       int n = nums1.length;

        // Frequency array for differences (0 to 100000)
        int[] diff = new int[100001];

        int maxDiff = 0;
        long totalDiff = 0;
        long operations = (long) k1 + k2;

        // Step 1: compute absolute differences
        for (int i = 0; i < n; i++) {
            int d = Math.abs(nums1[i] - nums2[i]);
            diff[d]++;
            maxDiff = Math.max(maxDiff, d);
            totalDiff += d;
        }

        // Step 2: if we can remove all differences
        if (operations >= totalDiff) return 0;

        // Step 3: greedy reduction from largest difference
        for (int i = maxDiff; i > 0 && operations > 0; i--) {
            if (diff[i] == 0) continue;

            long take = Math.min(diff[i], operations);

            diff[i] -= take;
            diff[i - 1] += take;
            operations -= take;
        }

        // Step 4: compute result
        long result = 0;
        for (int i = 0; i <= maxDiff; i++) {
            result += (long) i * i * diff[i];
        }

        return result;

    }
}