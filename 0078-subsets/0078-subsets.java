class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();

        int n = nums.length;

        if(n == 0){
            return ans;
        }

        dfs(0, ans, new ArrayList<>(), nums);

        return ans;


    }

    public void dfs(int start, List<List<Integer>> ans, List<Integer> temp, int [] nums){
        ans.add(new ArrayList<>(temp));

        for(int i = start; i< nums.length;i++){
            temp.add(nums[i]);
            dfs(i+1, ans, temp, nums);
            temp.remove(temp.size() - 1);
        }
    }
}