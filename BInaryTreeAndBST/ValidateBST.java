// /ValidateBST
//Problem Link : https://leetcode.com/problems/validate-binary-search-tree/

class ValidateBST {
	//1. Check in left sutreee that we have values less than the node
	// and in right subtree we have values greater than node
	ArrayList<Integer> x=new ArrayList<>();
	public void inorder(TreeNode root){
		if(root==null){return;}
		inorder(root.left);
        x.add(root.val);
		inorder(root.right);		
	}
	public boolean isValidBSTNaive(TreeNode root) {
       if(root==null){return true;}
        inorder(root);
        for(int i=1;i<x.size();i++){
        	if(x.get(i)<=x.get(i-1)){
        		return false;
        	}
        }
        return true;
    }




	//2. Optimised Approach By setting min and max T(n)=O(n)
	   public boolean isBSTUtil(TreeNode root,long min,long max){
		if(root==null){
			return true;
		}
		return root.val>min&&root.val<max&&isBSTUtil(root.left,min,root.val)
		&&isBSTUtil(root.right,root.val,max);
	}
    public boolean isValidBST(TreeNode root) {
       return isBSTUtil(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }
}