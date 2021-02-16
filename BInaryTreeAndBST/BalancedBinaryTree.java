// /BalancedBinaryTree
//Problem Link : https://leetcode.com/problems/balanced-binary-tree/
class BalancedBinaryTree {
	boolean ans=true;
    public int height(TreeNode root){
        if(root==null){
            return 0;
        }
        int lh=height(root.left);
        int rh=height(root.right);
        if(Math.abs(lh-rh)>1){
            ans=false;
        }
        return Math.max(lh,rh)+1;
    }
    public boolean isBalanced(TreeNode root) {
        height(root);
        return ans;
    }
}