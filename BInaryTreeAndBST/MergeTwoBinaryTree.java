// /MergeTwoBinaryTree
//Problem Link : https://leetcode.com/problems/merge-two-binary-trees/
class Solution {
    //Preorder traverse
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if(root1!=null&&root2!=null){
            root1.val+=root2.val;
        }
        else if(root1!=null){
            return root1;
        }
        else if(root2!=null){
            return root2;
        }
        else{
            return null;
        }
        root1.left=mergeTrees(root1.left,root2.left);
        root1.right=mergeTrees(root1.right,root2.right);
        return root1;      
        
    }
}