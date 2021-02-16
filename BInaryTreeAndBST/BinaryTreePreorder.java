        
    
//BinaryTreePreorder
//Problem Link : https://leetcode.com/problems/binary-tree-preorder-traversal/
class BinaryTreePreorder {
	//Iterative USing Stack O(n) 
	public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> ans=new ArrayList<>();
		Stack<TreeNode> stack=new Stack<>();
		if(root==null){
			return ans;
		}		
		TreeNode curr=root;
		while(curr!=null||!stack.isEmpty()){
			while(curr!=null){
				stack.add(curr);
				ans.add(curr.val);
				curr=curr.left;
			}
			TreeNode top=stack.pop();
			curr=top.right;
		}
		return ans;
    }
    //Iterative Using Morris Traversal
    public List<Integer> preorderTraversalUsingMorris(TreeNode root) {
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
    				ans.add(curr.val);
    				pre.right=curr;
    				curr=curr.left;
    			}else{
    				pre.right=null;
    				
    				curr=curr.right;
    			}
    		}
    	}
    	return ans;
    }
}