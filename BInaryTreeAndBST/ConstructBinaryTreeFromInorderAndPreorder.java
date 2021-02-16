// /ConstructBinaryTreeFromInorderAndPreorder
//Problem LInk : https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/

class ConstructBinaryTreeFromInorderAndPreorder {
	int indx=0;
	public int findNode(int[] inorder,int ele,int l,int r){
		int i=l;
        if(l==r){
            return l;
        }
		while(i<=r){
			if(inorder[i]==ele){
				return i;
			}
            i++;
		}
		return -1;
	}
    public TreeNode buildUtil(int[] preorder,int[] inorder,int left,int right){
    	if(indx==preorder.length){
    		return null;
    	}
        if(left>right){
            return null;
        }
    	int ele=preorder[indx++];
    	int indx=findNode(inorder,ele,left,right);
        TreeNode root=new TreeNode(inorder[indx]);
    	root.left=buildUtil(preorder,inorder,left,indx-1);
    	root.right=buildUtil(preorder,inorder,indx+1,right);
    	return root;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildUtil(preorder,inorder,0,inorder.length-1);
    }
}