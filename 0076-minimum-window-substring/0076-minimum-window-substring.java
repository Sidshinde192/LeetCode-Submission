class Solution {
    public String minWindow(String s, String t) {
         int n = s.length();
        int m = t.length();

        if (m > n) {
            return "";
        }

        int l = 0;
        int r = 0;
        int count = 0;

        int minLen = Integer.MAX_VALUE;
        int startIndex = -1;

        int[] hash = new int[256];

        // Store required character frequencies
        for (int i = 0; i < m; i++) {
            hash[t.charAt(i)]++;
        }

        while (r < n) {
            char rightChar = s.charAt(r);

            // This character was still required
            if (hash[rightChar] > 0) {
                count++;
            }

            // Always decrease, including extra occurrences
            hash[rightChar]--;

            // Current window contains all characters of t
            while (count == m) {
                int currentLength = r - l + 1;

                if (currentLength < minLen) {
                    minLen = currentLength;
                    startIndex = l;
                }

                char leftChar = s.charAt(l);

                // Remove left character from the window
                hash[leftChar]++;

                // Positive means this character is required again
                if (hash[leftChar] > 0) {
                    count--;
                }

                l++;
            }

            r++;
        }

        return startIndex == -1
                ? ""
                : s.substring(startIndex, startIndex + minLen);

    }
}