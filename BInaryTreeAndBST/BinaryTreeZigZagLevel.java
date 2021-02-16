// /BinaryTreeZigZagLevel
//Problem Link : https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
class BinaryTreeZigZagLevel {
	//1.USing Two Stacks
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
      Stack<TreeNode> s1=new Stack<>(),s2=new Stack<>();
      List<List<Integer>> ans=new ArrayList<>();
      if(root==null){return ans;}
        s1.push(root);
        while(!s1.isEmpty()||!s2.isEmpty()){
            ArrayList<Integer> list=new ArrayList<>();
            while(!s1.isEmpty()){
                TreeNode rp=s1.pop();
                list.add(rp.val);
                if(rp.left!=null){
                    s2.push(rp.left);
                }
                if(rp.right!=null){
                    s2.push(rp.right);
                }
            }
            if(list.size()!=0)
            ans.add(list);
            list=new ArrayList<>();
            while(!s2.isEmpty()){
                TreeNode rp=s2.pop();
                list.add(rp.val);
                if(rp.right!=null){
                    s1.push(rp.right);
                }
                if(rp.left!=null){
                    s1.push(rp.left);
                }
            }
            if(list.size()!=0)
            ans.add(list);
        }
        return ans;
    }


    //2.USing Level Order
     public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
     	Queue<TreeNode> queue=new LinkedList<>();
     	List<List<Integer>> ans=new ArrayList<>();
     	if(root==null){
     		return ans;
     	}
     	queue.add(root);
     	boolean flag=true;
     	while(!queue.isEmpty()){
     		int size=queue.size();
     		ArrayList<Integer> x=new ArrayList<>();
     		while(size--!=0){
     			TreeNode node=queue.poll();
     			x.add(node.val);
     			if(node.left!=null){
     				queue.add(node.left);
     			}
     			if(node.right!=null){
     				queue.add(node.right);
     			}
     		}
            
     		if(!flag){
     			Collections.reverse(x);
     		}
            flag=!flag;
     		ans.add(x);
     	}
     	return ans;
     }

}