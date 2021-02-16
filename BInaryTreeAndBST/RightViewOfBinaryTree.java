// /RightViewOfBinaryTree
//Problem LInk : https://leetcode.com/problems/binary-tree-right-side-view/
class RightViewOfBinaryTree {
	//1.Recursive Approach T(n)=O(n) & S(n)=O(n)
	List<Integer> ans=new ArrayList<>();
	int max_level=0;
	public void rightSideViewUtil(TreeNode root,int level){
		if(root==null){return;}
		if(max_level<level){
			ans.add(root.val);
			max_level=level;
		}
		rightSideViewUtil(root.right,level+1);
		rightSideViewUtil(root.left,level+1);
	}
    public List<Integer> rightSideViewRec(TreeNode root) {
        
        rightSideViewUtil(root,1);
        return ans;
    }



    //2.Iterative Approach T(n)=O(n) & S(n)=O(n)
     public List<Integer> rightSideView(TreeNode root) {
     	List<Integer> ans=new ArrayList<>();
     	  if(root==null){
             return ans;
         }
     	Queue<TreeNode> queue=new LinkedList<>();
     	queue.add(root);
     	while(!queue.isEmpty()){
     		int size=queue.size();
     		int i=1;
     		while(size--!=0){
     			TreeNode node=queue.poll();
     			if(i++==1){
     				ans.add(node.val);
     			}
     			if(node.right!=null){
     				queue.add(node.right);
     			}
     			if(node.left!=null){
     				queue.add(node.left);
     			}
     		}
     	}
     	return ans;
     }
}