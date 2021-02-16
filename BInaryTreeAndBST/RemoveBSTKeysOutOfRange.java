//RemoveBSTKeysOutOfRange
//Problem Link : https://leetcode.com/problems/trim-a-binary-search-tree/
class RemoveBSTKeysOutOfRange{
	public TreeNode postOrder(TreeNode root,int low,int high){
        if(root==null){return null;}
        root.left=postOrder(root.left,low,high);
        root.right=postOrder(root.right,low,high);
        // System.out.println(root.val+":"+low);
        if(root.val<low){            
            return root.right;
        }
        else if(root.val>high){            
            return root.left;
        }
        return root;
    }
    public TreeNode trimBST(TreeNode root, int low, int high) {
       if(root==null){
           return null;
       }
       return postOrder(root,low,high);    
       

    }
}