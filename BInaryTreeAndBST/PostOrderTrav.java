// /PostOrderTrav
//Problem Link : https://leetcode.com/problems/binary-tree-postorder-traversal/

class PostOrderTrav {
	//Iterative Using 2 Stacks
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans=new ArrayList<>();
        if(root==null){
        	return ans;
        }
        Stack<TreeNode> stack1=new Stack<>(),s2=new Stack<>();        
        stack1.add(root);
        while(!stack1.isEmpty()){
        	TreeNode node=stack1.pop();
        	stack2.push(node);
        	if(node.left!=null){
        		stack1.push(node.left);
        	}	
        	if(node.right!=null){
        		stack1.push(node.right);
        	}
        }
        while(!stack2.isEmpty()){
        	ans.add(stack2.pop());
        }
        return ans;
    }
    //Recursive Implementation  
    List<Integer> ans=new ArrayList<>();
	void postOrder(TreeNode root){
		if(root==null){
			return;
		}
        
		postOrder(root.left);
		postOrder(root.right);
        ans.add(root.val);
	}
    public List<Integer> postorderTraversalRec(TreeNode root) {
        postOrder(root);
        return ans;
    }

    //Morris Traversal
     public List<Integer> postorderTraversalMorris(TreeNode root) {
		LinkedList<Integer> ans=new LinkedList<>();
        TreeNode curr=root;
        while(curr!=null){
        	if(curr.right==null){
        		ans.addFirst(curr.val);
        		curr=curr.left;
        	}
        	else{
        		TreeNode pre=curr.right;
        		while(pre.left!=null&&pre.left!=curr){
        			pre=pre.left;
        		}
        		if(pre.left==null){
        			pre.left=curr;
        			ans.addFirst(curr.val);
        			curr=curr.right;
        		}
        		else{
        			pre.left=null;
        			curr=curr.left;
        		}
        	}
        }
        return ans;
    }

}