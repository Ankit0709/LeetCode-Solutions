// /FlattenBinaryTreeToLL
//Problem Link : https://leetcode.com/problems/flatten-binary-tree-to-linked-list/

class FlattenBinaryTreeToLL {
	ArrayList<TreeNode> list=new ArrayList<>();
	public void preorder(TreeNode root){
		if(root==null){
			return;
		}
		list.add(root.val);
		preorder(root.left);
		preorder(root.right);
	}
    public void flatten(TreeNode root) {
        if(root==null){
        	return;
        }
        preorder(root);
        TreeNode head=root;
        int i=0;
        while(i<list.size()-1){
        	TreeNode ptr1=list.get(i);
        	TreeNode ptr2=list.get(i+1);
        	ptr1.left=null;
        	ptr1.right=ptr2;
        	 i++;
        }
        TreeNode last=list.get(i);
        last.left=null;
        last.right=null;
    }
}