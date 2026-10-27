class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int total =0;
        int leftMax=0;
        int rightMax =0;
        int left =0;
        int right = n-1;

        while(left < right){
            if(height[left] <= height[right]){
                if(height[left] < leftMax){
                    total += leftMax - height[left];
                }
                else{
                    leftMax = height[left];
                }
                left++;
            }
            else{
                if(height[right] < rightMax){
                    total += rightMax - height[right];
                }
                else{
                    rightMax = height[right];
                }
                right--;
            }
        }

        return total;
        
    }
}