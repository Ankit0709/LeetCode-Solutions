//ConstructBinaryTreeFromInorderAndPostOrder
//Problem Link : https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
class ConstructBinaryTreeFromInorderAndPostOrder {
	int indx=0;
	public int findNode(int[] inorder,int ele,int s,int e){
		int i=s;
		if(s==e){
			return s;
		}
		while(i<=e){
			if(inorder[i]==ele){
				return i;
			}
		}
		return -1;
	}
	public TreeNode buildTreeUtil(int[] inorder,int indx,int[] postorder,int s,int e){
		if(indx==inorder.length){
			return null;
		}
		if(s>e){
			return null;
		}
		int ele=inorder[indx++];
		int indx=findNode(inorder,ele,s,e);
		TreeNode root=new TreeNode(inorder[indx]);
		root.left=buildTreeUtil(inorder,indx,postorder,s,indx-1);
		root.right=buildTreeUtil(inorder,indx,postorder,indx+1,e);
		return root;

	}
    public TreeNode buildTree(int[] inorder, int[] postorder) {
    	return buildTreeUtil(inorder,0,postorder);
        
    }
}