class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();

        Arrays.sort(nums);

        dfs(0, ans, nums, new ArrayList<>());

        return ans;
    }

    public void dfs(int start, List<List<Integer>> ans, int [] nums, List<Integer> temp){
        ans.add(new ArrayList<>(temp));

        for(int i = start; i< nums.length;i++){
            temp.add(nums[i]);
            dfs(i+1, ans, nums, temp);
            temp.remove(temp.size() -1);
        }
    }
}