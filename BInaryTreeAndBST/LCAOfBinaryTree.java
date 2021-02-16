// /LCAOfBinaryTree
//Problem Link : https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
class LCAOfBinaryTree {

	//1.Approach that we will store tha path in two arraylist and then we will go from last and find
	//the common node in both arraylist
	 
	 public boolean lca(TreeNode root,TreeNode x,ArrayList<TreeNode> path){
	 	if(root==null){
	 		return false;
	 	}
	 	path.add(root);
	 	if(root==x){
	 		return true;
	 	}
	 	if(lca(root.left,x,path)){
	 		return true;
	 	}
	 	if(lca(root.right,x,path)){
	 		return true;
	 	}
	 	path.remove(path.size()-1);
	 	return false;

	 }
	 public TreeNode lowestCommonAncestorVec(TreeNode root, TreeNode p, TreeNode q) {
	 	 if(root==null){
	 		return null;
	 	}
	 	ArrayList<TreeNode> path1=new ArrayList<>(),path2=new ArrayList<>();
	 	lca(root,p,path1);
	 	lca(root,q,path2);
        int i=0;
	 	for(;i<path1.size()&&i<path2.size();i++){
	 		if(path1.get(i).val!=path2.get(i).val){
	 			break;
	 		}
	 	}
	 	return path1.get(i-1);
	 }


	//2.Approach for O(n) LCA 
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null){
            return null;
        }
        if(root==p||root==q){
            return root;
        }
        TreeNode left=lowestCommonAncestor(root.left,p,q);
        TreeNode right=lowestCommonAncestor(root.right,p,q);
        if(left!=null&&right!=null){
            return root;
        }
        return left!=null?left:right;
    }
}