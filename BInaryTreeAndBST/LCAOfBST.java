//LCAOfBST
//Problem Link : https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
class LCAOfBST {
	//1.Recursive Approach T(n)=O(n) S(n)=O(n)
	//We will go to left if root.val<p and q so just go to right else left
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null){return null;}       
        //if value of root is less than go to right
        if(root.val<p.val&&root.val<q.val){
        	return lowestCommonAncestor(root.right,p,q);
        }
        else if(root.val>p.val&&root.val>q.val){
        	return lowestCommonAncestor(root.left,p,q);
        }
        return  root;
    }

    ////2.Iterative  Approach T(n)=O(n) S(n)=O(1)
    public TreeNode lowestCommonAncestorOpti(TreeNode root, TreeNode p, TreeNode q) {
    	 if(root==null){
    		return null;
    	}
    	while(root!=null){
    		if(root==p||root==q){
    			return root;
    		}
    		else if(root.val>p.val&&root.val>q.val){
    			root=root.left;
    		}
    		else if(root.val<p.val&&root.val<q.val){
    			root=root.right;
    		}
    		else{
    			break;
    		}
    	}
    	return root;
    }
}