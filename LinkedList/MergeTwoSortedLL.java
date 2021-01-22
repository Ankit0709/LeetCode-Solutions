//MergeTwoSortedLL
//Problem Link :https://leetcode.com/problems/merge-two-sorted-lists/
class MergeTwoSortedLL {
	public ListNode mergeTwoListsIter(ListNode l1,ListNode l2){
		ListNode newHead=null;
		ListNode curr=null;
		if(l1==null&&l2==null){
			return null;
		}
		while(l1!=null&&l2!=null){
			if(l1.val<=l2.val){
				if(newHead==null){
					newHead=l1;
					curr=newHead;
				}
				else{
					curr.next=l1;
					curr=curr.next;
				}
				l1=l1.next;
			}
			else{
				if(newHead==null){
					newHead=l2;
					curr=newHead;
				}
				else{
					curr.next=l2;
					curr=curr.next;
				}
				l2=l2.next;
			}
		}
		while(l1!=null){
			if(newHead==null){
				newHead=l1;
				curr=newHead;
			}
			else{
				curr.next=l1;
				curr=curr.next;
			}
			l1=l1.next;
		}
		while(l2!=null){
			if(newHead==null){
				newHead=l2;
				curr=newHead;
			}
			else{
				curr.next=l2;
				curr=curr.next;
			}
			l2=l2.next;
		}
		return newHead;
	}
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null&&l2==null){
        	return null;
        }
        else if(l1==null){
        	return l2;
        }
        else if(l2==null){
        	return l1;
        }
        else{
        	if(l1.val<l2.val){
        		l1.next=mergeTwoLists(l1.next,l2);
        		return l1;
        	}
        	else{
        		l2.next=mergeTwoLists(l1,l2.next);
        		return l2;
        	}

        }
    }
}