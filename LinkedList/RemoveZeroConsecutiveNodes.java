//RemoveZeroConsecutiveNodes
//Problem Link : https://leetcode.com/problems/remove-zero-sum-consecutive-nodes-from-linked-list/
class RemoveZeroConsecutiveNodes {
    public ListNode removeZeroSumSublists(ListNode head) {
        if(head==null){
        	return null;
        }
        ListNode newHead=new ListNode(-1);
        newHead.next=head;
        ListNode ptr=head;
        int prefix_sum=0;
        HashMap<Integer,ListNode> map=new HashMap<>();
        map.put(prefix_sum,newHead);
        int i=0;
        while(ptr!=null){
        	prefix_sum+=ptr.val;
        	//check if map has already same value
        	if(map.containsKey(val)){
        		ListNode toRemove=map.get(val);
        		//remove entries from map
        		int sum=prefix_sum;
        		while(toRemove!=ptr){
        			sum+=toRemove.val;
        			map.remove(sum);
        			toRemove=toRemove.next;
        		}
        		//add link
        		map.get(prefix_sum).next=ptr.next;        		
        	}
        	else{
        		map.put(val,ptr);
        	}        	
        	ptr=ptr.next;
        }
        return newHead.next;
        


    }
}