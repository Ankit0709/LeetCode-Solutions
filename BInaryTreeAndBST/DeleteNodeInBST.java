//DeleteNodeInBST
//Problem Link : https://leetcode.com/problems/delete-node-in-a-bst/
class DeleteNodeInBST {
    public int inorderSucc(TreeNode root,int key){
    	while(root.left!=null){
    		root=root.left;
    	}
    	return root.val;
    }
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root==null){return null;}
        if(root.val<key){
        	root.right=deleteNode(root.right,key);
        }
        else if(root.val>key){
        	root.left=deleteNode(root.left,key);
        }
        else{
        	if(root.left==null){
        		return root.right;
        	}
        	if(root.right==null){
        		return root.left;
        	}
        	int succ=inorderSucc(root.right,key);
        	root.val=succ;
        	root.right=deleteNode(root.right,succ);
        }
        return root;
    }
}