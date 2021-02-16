// /BottomViewOfBinaryTree
//Problem Link : https://www.geeksforgeeks.org/bottom-view-binary-tree/
class BottomViewOfBinaryTree{
	//1.Recursive Approach  Using Map
	List<Integer> ans=new ArrayList<>();
	Map<Integer,Integer> map=new TreeMap<>();
	public void bottomViewUtil(TreeNode root,int vd){
		if(root==null){return;}
		map.put(vd,root.val);
		bottomViewUtil(root.left,vd-1);
		bottomViewUtil(root.right,vd+1);
	}
	public List<Integer> bottomView(TreeNode root){
		bottomViewUtil(root,0);
		for(Map.Entry<Integer,Integer> entry:map.entrySet()){
    	    ans.add(entry.getValue());
    	}
		return ans;
	}


	//2.Iterative Approach Using Map And Queue
	public ArrayList<Integer> bottomView(Node root){
		Queue<Pair> queue=new LinkedList<>();
		Map<Integer,Integer> map=new TreeMap<>();
		ArrayList<Integer> ans=new ArrayList<>();
		queue.add(new Pair(root,0));
		while(!queue.isEmpty()){
			Pair top=queue.poll();
			map.put(top.vd,top.x.data);
			if(top.x.left!=null){
				queue.add(new Pair(top.x.left,top.vd-1));
			}
			if(top.x.right!=null){
				queue.add(new Pair(top.x.right,top.vd+1));
			}

		}
		for(Map.Entry<Integer,Integer> entry:map.entrySet()){
			ans.add(entry.getValue());
		}
		return ans;
	}

}
class Pair{
	Node x;int vd;
	Pair(Node n,int d){
		x=n;
		vd=d;
	}
}