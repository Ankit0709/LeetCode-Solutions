// /RemoveBSTKeysInRange
//Problem Link : https://www.geeksforgeeks.org/remove-bst-keys-in-a-given-range/
class RemoveBSTKeysInRange{
	public TreeNode inorderSucc(TreeNode root){
		if(root==null){
			return root;
		}
		while(root.left!=null){
			root=root.left;
		}
		return root;
	}
	public TreeNode deleteNode(TreeNode root) {
       
        if(root.left==null){        	
        	return root.right;;
        }
        else if(root.right==null){
        	return root.left;
        }
         TreeNode succ=inorderSucc(root.right);
         root.val=succ.val;
         root.right=deleteNode(root.right,succ.val);
         return root;
        
    }
	public TreeNode postOrder(TreeNode root,int l,int h){
		if(root==null){
			return null;
		}
		root.left=postOrder(root.left,l,h);
		root.right=postOrder(root.right,l,h);
		if(root.val>=l&&root.val<=h){
			return deleteNode(root);
		}
		return root;
	}
	 public TreeNode removeKeys(TreeNode root, int low, int high) {
	 	if(root==null){
	 		return null;
	 	}
	 	return postOrder(root,low,high);
	 }
}