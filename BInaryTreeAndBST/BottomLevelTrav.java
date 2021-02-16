//BottomLevelTrav
//Problem LInk : https://leetcode.com/problems/binary-tree-level-order-traversal-ii/
class BottomLevelTrav {

	List<List<Integer>> ans=new ArrayList<>();
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
         Queue<TreeNode> queue=new LinkedList<>();
         queue.add(root);
         while(!queue.isEmpty()){
         	int size=queue.size();
         	ArrayList<Integer> x=new ArrayList<>();
         	while(size--!=0){
         		TreeNode top=queue.poll();
         		x.add(top.val);
         		if(top.left!=null){
         			queue.add(top.left);
         		}
         		if(top.right!=null){
         			queue.add(top.right);
         		}
         	}
         }

       Collections.reverse(ans);
       return ans;
    }
}