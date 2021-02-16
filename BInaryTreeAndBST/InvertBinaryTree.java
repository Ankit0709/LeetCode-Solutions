//InvertBinaryTree
//Problem Link : https://leetcode.com/problems/invert-binary-tree/
class InvertBinaryTree {
	//1.Swap Pointer
     public void dfs(TreeNode root){
        if(root==null){return;}
        dfs(root.left);
        dfs(root.right);
        TreeNode temp=root.right;
        root.right=root.left;
        root.left=temp;
        return;        
    }
    public TreeNode invertTree(TreeNode root) {
       if(root==null){
           return null;
       }
        dfs(root);
        return root;       
    }
}