// /BInaryTreeLevelOrder
//Problem Link : https://leetcode.com/problems/binary-tree-level-order-traversal/

class BInaryTreeLevelOrder { 
    public List<List<Integer>> levelOrder(TreeNode root) {
    	List<List<Integer>> ans=new ArrayList<>();
        if(root==null){
            return ans;
        }
    	Queue<TreeNode> queue=new LinkedList<>();
    	queue.add(root);
    	while(!queue.isEmpty()){
    		int size=queue.size();
    		ArrayList<Integer> nodes=new ArrayList<>();
    		while(size--!=0){
    			TreeNode node=queue.poll();
    			nodes.add(node.val);
    			if(node.left!=null){
    				queue.add(node.left);
    			}
    			if(node.right!=null){
    				queue.add(node.right);
    			}
    		}
    		ans.add(nodes);
    	}    
    	return ans;
    }
    List<Integer> ans=new ArrayList<>();
    public boolean levelUtil(TreeNode root,int lvl){
    	if(root==null){
    		return false;
    	}
    	if(lvl==1){
    		ans.add(root.val);
    		return true;
    	}
    	return levelUtil(root.left,lvl-1)||levelUtil(root.right,lvl-1);
    }
   
    public List<Integer> levelOrder(TreeNode root){
    	int level=1;
    	while(levelUtil(root,level)){
    		level++;
    	}
    	return ans;
    }
}