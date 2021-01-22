//FirstNodeInCycleLL
//Problem Link : https://leetcode.com/problems/linked-list-cycle-ii/
public class FirstNodeInCycleLL {
	public ListNode detectCycle(ListNode head) {
        if(head==null){
        	return head;
        }
        ListNode fast=head,slow=head;
        boolean flag=false;
        while(fast!=null&&fast.next!=null){
        	fast=fast.next.next;
        	slow=slow.next;
        	if(slow==fast){
        		flag=true;
        		break;
        	}
        }
        if(!flag){
        	return null;
        }
        Node ptr=head;
        while(ptr!=null){
        	if(slow==ptr){
        		return slow;
        	}
        	slow=slow.next;
        	fast=fast.next;
        }
        return null;

    }
}