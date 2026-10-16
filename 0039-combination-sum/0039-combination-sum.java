class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();

        dfs(0, ans, new ArrayList<>(), candidates, target);
        return ans;
    }

    public void dfs(int idx, List<List<Integer>> ans, List<Integer> temp, int [] candidates, int target){
        if(idx == candidates.length){
            if(target == 0){
                ans.add(new ArrayList<>(temp));
                
            }

            return;
        }

        if(candidates[idx] <= target){
            temp.add(candidates[idx]);
            dfs(idx, ans, temp, candidates, target - candidates[idx]);
            temp.remove(temp.size() - 1);
        }

        dfs(idx + 1, ans, temp, candidates, target);
    }
}