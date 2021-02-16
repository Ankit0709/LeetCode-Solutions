// /InsertIntoBST
//Problem Link : https://leetcode.com/problems/insert-into-a-binary-search-tree/

class InsertIntoBST {
    //1. Approach for Insertion check if root.val<val then go to right else go to left
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root==null){
        	TreeNode node=new TreeNode(val);
        	return node;
        }
        if(root.val<val){
        	root.right=insertIntoBST(root.right,val);	
        }
        else{
        	root.left=insertIntoBST(root.left,val);
        }
        return root;
    }

    //2.Iterative Approach 
    public TreeNode insertIntoBSTIter(TreeNode root, int val) {\
    	TreeNode node=new TreeNode(val);
    	if(root==null){    		
    		return node;
    	}
    	TreeNode x=root;
    	while(root!=null){
    		if(root.val<val){
    			if(root.right==null){
    				root.right=node;
    				break;
    			}
    			else{
    				root=root.right;
    			}
    		}
    		else{
    			if(root.left==null){
    				root.left=node;
    				break;
    			}
    			else{
    				root=root.left;
    			}
    		}
    	}
    	return x;
    }
}