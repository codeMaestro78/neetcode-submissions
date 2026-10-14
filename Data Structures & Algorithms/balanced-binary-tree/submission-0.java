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
    public boolean isBalanced(TreeNode root) {
    return checkHeight(root) != -1;
    }

    private static int checkHeight(TreeNode node){
        if(node == null){
            return 0;
        }

        int leftTree = checkHeight(node.left);

        if(leftTree == -1){
            return -1;
        }

        int rightTree = checkHeight(node.right);
        if(rightTree == -1){
            return -1;
        }

        if(Math.abs(leftTree- rightTree)>1){
            return -1;
        }

        return 1 + Math.max(leftTree,rightTree);
    }
        
}
