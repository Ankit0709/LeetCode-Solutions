// /BinaryTreeMaxPathSum
//Problem Link : https://leetcode.com/problems/binary-tree-maximum-path-sum/
class BinaryTreeMaxPathSum {   
    int max_sum=Integer.MIN_VALUE; 
    public int dfs(TreeNode root){
        if(root==null){
            return 0;
        }
     
        int ls=dfs(root.left);
        int rs=dfs(root.right);
        int sum=root.val+ls+rs;
        if(sum>max_sum){
            max_sum=sum;
        }
        return Math.max(0,root.val+Math.max(ls,rs));
    }
    public int maxPathSum(TreeNode root) {
       if(root==null){
           return 0;
       }      
        dfs(root);
        return max_sum;
       
    }
}