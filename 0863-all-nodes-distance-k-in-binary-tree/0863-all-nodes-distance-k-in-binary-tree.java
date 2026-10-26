/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public void markParent(TreeNode root, Map<TreeNode, TreeNode> map, TreeNode target){
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while(!q.isEmpty()){
            int size = q.size();
            for(int i =0; i< size;i++){
                TreeNode curr = q.poll();

                if(curr.left != null){
                    map.put(curr.left, curr);
                    q.offer(curr.left);
                }
                if(curr.right != null){
                    map.put(curr.right, curr);
                    q.offer(curr.right);
                }
            }
        }
    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode, TreeNode> map = new HashMap<>();
        markParent(root, map, target);
        Queue<TreeNode> q = new LinkedList<>();
        Map<TreeNode, Boolean> visited = new HashMap<>();
        q.offer(target);
        visited.put(target, true);
        int currentLevel =0;

        while(!q.isEmpty()){
            int size = q.size();

            if(currentLevel == k){
                break;
            }

            currentLevel++;

            for(int i =0; i< size;i++){
                TreeNode curr = q.poll();
                if(curr.left!= null && visited.get(curr.left) == null){
                    visited.put(curr.left, true);
                    q.offer(curr.left);
                }
                if(curr.right != null && visited.get(curr.right) == null){
                    visited.put(curr.right, true);
                    q.offer(curr.right);
                }
                if(map.get(curr) != null && visited.get(map.get(curr)) == null){
                    visited.put(map.get(curr), true);
                    q.offer(map.get(curr));
                }
            }

           
        }

         List<Integer> list = new ArrayList<>();

            while(!q.isEmpty()){
                TreeNode node = q.poll();
                list.add(node.val);
            }

            return list;
    }
}