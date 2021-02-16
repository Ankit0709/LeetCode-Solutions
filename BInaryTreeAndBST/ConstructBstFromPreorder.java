//ConstructBstFromPreorder
//Problem Link : https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/
class Solution {
	//1. We can build tree with inorder and preorder of bst
	 int  indx=0;
	public TreeNode buildTree(int[] pre,int[] in,int s,int e){
		if(s>e||indx==pre.length){
			return null;
		}
		int findNode=Arrays.binarySearch(in,pre[indx]);
		TreeNode root=new TreeNode(pre[indx++]);
		root.left=buildTree(pre,in,s,findNode-1);
		root.right=buildTree(pre,in,findNode+1,e);
		return root;

	}
    public TreeNode bstFromPreorder(int[] preorder) {
        int[] inorder=Arrays.copyOf(preorder,preorder.length);
        Arrays.sort(inorder);
        return buildTree(preorder,inorder,0,preorder.length-1);
    }


    //2. Use BSt Property by inserting nodes using insert function
     public TreeNode bstFromPreorderOpti(int[] preorder) {
     	 TreeNode root=new TreeNode(preorder[0]);
     	 for(int i=1;i<preorder.length;i++){
     	     insert(root,preorder[i]);
     	 }
     	 return root;
     }
     public TreeNode insert(TreeNode root,int val){
     	if(root==null){
     		return new TreeNode(val);
     	}
     	if(root.val<val){
     		root.right=insert(root.right,val);
     	}
     	else{
     		root.left=insert(root.left,val);
     	}
     	return root;
     }
}