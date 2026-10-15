class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;

        int [] ans = new int[n + m];

        for(int i =0; i< n;i++){
            ans[i] = nums1[i];
        }

        for(int i = 0; i< m;i++){
            ans[n+i] = nums2[i];
        }
        Arrays.sort(ans);

        int len = ans.length;

        if(len % 2 == 1){
            int mid = len / 2;

            return (double) ans[mid];
        }

        int mid1 = len / 2;
        int mid2 = mid1 -1;

        return (ans[mid1] + ans[mid2]) / 2.0;
    }
}