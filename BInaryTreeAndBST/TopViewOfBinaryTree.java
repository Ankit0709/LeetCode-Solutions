//TopViewOfBinaryTree
//Problem Link : https://www.hackerrank.com/challenges/tree-top-view/problem
class TopViewOfBinaryTree{
	//1>Iterative Approach Using Map
	public static void topView(Node root) {
     	Queue<Pair> queue=new LinkedList<>();
         Map<Integer,Integer> map=new TreeMap<>();         
         queue.add(new Pair(root,0));
         while(!queue.isEmpty()){
             Pair rp=queue.poll();
             Node x=rp.x;
             int vd=rp.vd;
             if(!map.containsKey(vd)){
                 map.put(vd,x.data);
             }
             if(x.left!=null){
                 queue.add(new Pair(x.left,vd-1));
             }
             if(x.right!=null){
                 queue.add(new Pair(x.right,vd+1));
             }

         }
         for(Map.Entry<Integer,Integer> entry:map.entrySet()){
             System.out.print(entry.getValue()+" ");
         }     
      
    }

    //2.Recursive Approach
    Map<Integer,Integer> map=new TreeMap<>();
    List<Integer> ans=new ArrayList<>();
    public void topViewUtil(Node root,int vd){
    	if(root==null){return;}
    	if(!map.containsKey(root)){
    		map.put(vd,root.val);
    	}
    	topViewUtil(root.left,vd-1);
    	topViewUtil(root.right,vd+1);
    }    
    public  List<Integer> topView(Node root) {
    	topViewUtil(root,0);
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