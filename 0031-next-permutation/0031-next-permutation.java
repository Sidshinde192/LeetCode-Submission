class Solution {
    public void nextPermutation(int[] nums) {
        int index = -1;

        for(int i = nums.length-2;i>=0;i--){
            if(nums[i] < nums[i+1]){
                index = i;
                break;
            }
        }

        if(index == -1){
            swap(0, nums.length-1, nums);
            return;
        }

        for(int i =nums.length-1;i>=0;i--){
            if(nums[i] > nums[index]){
                int temp = nums[i];
                nums[i] = nums[index];
                nums[index] = temp;
                break;
            }
        }

        swap(index + 1, nums.length-1, nums);
        return;
    }

    public void swap(int i, int j, int [] nums){
        while(i <= j){
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }
}