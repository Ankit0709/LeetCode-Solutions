//LeftViewofBinaryTree
//Problem Link : https://www.geeksforgeeks.org/print-left-view-binary-tree/
class LeftViewofBinaryTree{
	//Iterative T(n)=O(n)
	public List<Integer> leftViewOfBinaryTree(TreeNode root){
		List<Integer> ans=new ArrayList<>();
		Queue<TreeNode> queue=new LinkedList<>();
		queue.add(root);
		while(!queue.isEmpty()){
			int size=queue.size();
			int i=1;
			while(size--!=0){
				TreeNode top=queue.poll();
				if(i++==1){
					ans.add(top.val);
				}
				if(top.left!=null){
					queue.add(top.left);
				}
				if(top.right!=null){
					queue.add(top.right);
				}
			}
		}
		return ans;
	}

	//Recursive Approach T(n)=O(n) and S(n)=O(n)
	List<Integer> ans=new ArrayList<>();
	int max_level=0;
	public void leftViewUtil(TreeNode root,int level){
		if(root==null){
			return;
		}
		if(max_level<level){
			ans.add(root.val);
			max_level=level;
		}
		leftViewUtil(root.left,level+1);
		leftViewUtil(root.right,level+1);
	}
	public List<Integer> leftViewOfBinaryTreeRec(TreeNode root){
		leftViewUtil(root,1);
		return ans;
	}


}