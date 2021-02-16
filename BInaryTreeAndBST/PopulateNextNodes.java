// /PopulateNextNodes
//Problem LInk : https://leetcode.com/problems/populating-next-right-pointers-in-each-node/
class PopulateNextNodes {
	//1 Approach 1 Level Order Traversal
    public Node connect(Node root) {
        if(root==null){
            return null;
        }          
        Queue<Node> queue=new LinkedList<>();
        queue.add(root);
        queue.add(null);
        while(!queue.isEmpty()){
            int size=queue.size();
            while(size--!=0){
                Node top=queue.poll();
                 if(top!=null){
                     top.next=queue.peek();
                     if(top.left!=null){
                         queue.add(top.left);
                     }
                     if(top.right!=null){
                         queue.add(top.right);
                     }
                     
                }             
             }
             if(queue.size()!=0)
              queue.add(null);             
        }
        return root;
    }

    //2. Constant Space Optimised traverse from top to bottomn using left and next will be used as
    //going from left to right
     public Node connectSpace(Node root) {
     	if(root==null){
     		return null;
     	}
     	Node start=root;
     	while(root.left!=null){
     		Node head=root;
     		while(head!=null){
     			head.left.next=head.right;
     			if(head.next!=null){
     				head.right.next=head.next.left;
     			}
     			head=head.next;
     		}
     		root=root.left;
     	}
     	return start;
     }
}