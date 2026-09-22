class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int left = m-1;
        int right = n-1;

        int i = m+n -1;

        while(left >= 0 && right >=0){
            if(nums1[left] >= nums2[right]){
                nums1[i] = nums1[left];
                left--;
                i--;
            }
            else{
                nums1[i] = nums2[right];
                right--;
                i--;
            }
        }

        while(right >=0){
            nums1[i] = nums2[right];
            i--;
            right--;
        }
    }
}