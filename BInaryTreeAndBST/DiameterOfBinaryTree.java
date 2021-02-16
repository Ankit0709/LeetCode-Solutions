// /DiameterOfBinaryTree
//Problem LInk : https://leetcode.com/problems/diameter-of-binary-tree/
class Solution {
	//1.Approach 1 diamater will be max of (ld,rd,lh+rh+1)
	 public int height(TreeNode root){
        if(root==null)return 0;
        int lh=height(root.left);
        int rh=height(root.right);
        return Math.max(lh,rh)+1;
    }
    public int diameter(TreeNode root){
      if(root==null){
        return 0;
       }
        int lh=height(root.left);
        int rh=height(root.right);
        int ld=diameter(root.left);
        int rd=diameter(root.right);
        return Math.max(ld,Math.max(rd,lh+rh+1));
    }
	public int diameterOfBinaryTreeNaiveApp(TreeNode root) {
        if(root==null){
            return 0;
        }
     return diameter(root)-1;
    }


	//2.Approach for O(n) diamater will be max of (lh+rh+1)
	 int max_dia=0;
    public int height(TreeNode root){
        if(root==null)return 0;
        int lh=height(root.left);
        int rh=height(root.right);
        max_dia=Math.max(max_dia,lh+rh+1);
        return Math.max(lh,rh)+1;
    }
	public int diameterOfBinaryTree(TreeNode root) {
       if(root==null){
       	return 0;
       }
       height(root);
	   return max_dia-1;
    }
}