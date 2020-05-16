//kthLargest
import java.util.*;
public class KthLargest {
     PriorityQueue<Integer> min_heap;
    public KthLargest(int k, int[] nums) {
        min_heap = new PriorityQueue<>();
        int count=0;
        for(int i=0;i<nums.length;i++){
        	if(count==k){
        		if(min_heap.peek()<nums[i]){
        			min_heap.poll();
        			min_heap.add(nums[i]);
        		}
        	}
        	else{
        		min_heap.add(nums[i]);
        		count++;
        	}
        }
    }	
    
    public int add(int val) {
        if(val>min_heap.peek()){
        	min_heap.poll();
        	min_heap.add(val);
        }
        return min_heap.peek();
    }
}