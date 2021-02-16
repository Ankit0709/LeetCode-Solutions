// /BinaryTreeInorderTrav
//Problem Link : https://leetcode.com/problems/binary-tree-inorder-traversal/
class BinaryTreeInorderTrav {
	//Iterative Using Stack T(n)=> O(n)
    public List<Integer> inorderTraversal(TreeNode root) {
    	List<Integer> ans=new ArrayList<>();
    	TreeNode curr=root;
    	Stack<TreeNode> stack=new Stack<>();
    	while(curr!=null||!stack.isEmpty()){
    		while(curr!=null){
    			stack.push(curr);
    			curr=curr.left;
    		}
    		TreeNode top=stack.pop();
    		ans.add(top.val);
    		curr=top.right;
    	}    
    	return ans;
    }
    //Itertive using Morris Traversal T(n)=O(n) S(n)=O(1)
     public List<Integer> inorderTraversalMorrisTraversal(TreeNode root) {
    	List<Integer> ans=new ArrayList<>();
    	TreeNode curr=root;
    	while(curr!=null){
    		if(curr.left==null){
    			ans.add(curr.val);
    			curr=curr.right;
    		}
    		else{
    			TreeNode pre=curr.left;
    			while(pre.right!=null&&pre.right!=curr){
    				pre=pre.right;
    			}
    			if(pre.right==null){
    				pre.right=curr;
    				curr=curr.left;
    			}
    			else{
    				pre.right=null;
    				ans.add(curr.val);
    				curr=curr.right;
    			}
    		}
    	}
    	return ans;
    }
}