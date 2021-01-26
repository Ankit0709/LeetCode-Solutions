//ReverseNodesInKGroups
////Problem Link : https://leetcode.com/problems/reverse-nodes-in-k-group/
class ReverseNodesInKGroups {
      public ListNode reverse(ListNode head){
    	if(head==null||head.next==null){
    		return head;
    	}
    	ListNode newHead=reverse(head.next);
    	head.next.next=head;
    	head.next=null;
    	return newHead;        
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head==null||head.next==null||k<=1){
        	return head;
        }
        ListNode start=head;
        ListNode newHead=null;
        ListNode end=head,ptr=head,tail=null;
        
        int len=0;
        while(ptr!=null){
        	len++;
        	ptr=ptr.next;
        }
        ListNode next=null;
        while(len>=k){           
        	 int nodes=k;
        	 while(nodes!=1){
        	 	end=end.next;
        	 	nodes--;        	 	
        	}
            len-=k;
        	next=end.next;
        	end.next=null;
        	ListNode ptr1=reverse(start);
        	if(newHead==null){
        		newHead=ptr1;
           	}
            else{
                tail.next=ptr1;
            }
            tail=start;  
            start=next;
            end=start;
        }
        if(len!=0){
            tail.next=next;
        }
        return newHead;
       
    }
}