/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode correctBinaryTree(TreeNode root) {
        Queue<TreeNode[]> q = new LinkedList<>();
        q.add(new TreeNode[]{root, null});

        while(!q.isEmpty()){
            int n = q.size();

            Set<TreeNode> visited = new HashSet<>();

            for(int i =0; i< n;i++){
                TreeNode[] temp = q.poll();
                TreeNode node = temp[0];
                TreeNode parent = temp[1];

                if(visited.contains(node.right)){
                    if(parent.left == node){
                        parent.left = null;
                    }
                    else{
                        parent.right = null;
                    }

                    return root;
                }

                visited.add(node);

                if(node.right != null){
                    q.add(new TreeNode[]{node.right, node});
                }
                if(node.left != null){
                    q.add(new TreeNode[]{node.left, node});
                }
            }

        }

        return root;
    }
}