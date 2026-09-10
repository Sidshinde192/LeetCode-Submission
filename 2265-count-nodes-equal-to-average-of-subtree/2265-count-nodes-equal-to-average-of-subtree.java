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
    private int count =0;
    public int averageOfSubtree(TreeNode root) {

        if(root == null){
            return count;
        }

        postorder(root);
        return count;
        
    }

    public int[] postorder(TreeNode root){
        if(root == null){
            return new int[]{0, 0};
        }

        int [] left = postorder(root.left);
        int [] right = postorder(root.right);

        int totalSum = left[0] + right[0] + root.val;
        int totalNode = left[1] + right[1] + 1;

        if(totalSum/totalNode == root.val){
            count++;
        }

        return new int[]{totalSum, totalNode};
    }
}