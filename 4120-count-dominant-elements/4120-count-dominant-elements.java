class Solution {
    public int countDominantElements(int[] A) {
        int n = A.length;
        if (n == 1)
            return 1;
        int res = (A[0] >= A[1] ? 1 : 0) + (A[n - 1] >= A[n - 2] ? 1 : 0);
        for (int i = 1; i < n - 1; ++i) {
            if (A[i] + A[i] >= A[i - 1] + A[i + 1])
                res += 1;
        }
        return res;
    }
}