//SymmetricTree
//Problem LInk : https://leetcode.com/problems/symmetric-tree/
class SymmetricTree {
    public boolean isSymmetricUtil(TreeNode root1,TreeNode root2){
        if(root1==null&&root2==null){return true;}
        return root1!=null&&root2!=null&&root1.val==root2.val&&isSymmetricUtil(root1.left,root2.right)
            &&isSymmetricUtil(root1.right,root2.left);
    }
    public boolean isSymmetric(TreeNode root) {
        if(root==null){return true;}
        return isSymmetricUtil(root,root);        
    }
}