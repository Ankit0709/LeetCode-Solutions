//MedianFromDataStream
import java.util.*;
class MedianFinder {
    PriorityQueue<Integer> max_heap;
    PriorityQueue<Integer> min_heap;
    /** initialize your data structure here. */
    public MedianFinder() {
        max_heap = new PriorityQueue<>(Collections.reverseOrder());
        min_heap = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        max_heap.add(num);
        if(max_heap.size()-min_heap.size()>=1){
        	min_heap.add(max_heap.poll());
        }
        if(min_heap.size()>max_heap.size()){
        	max_heap.add(min_heap.poll());
        }
    }
    
    public double findMedian() {
        if((max_heap.size()+min_heap.size())%2==0){
        	return (max_heap.peek()+min_heap.peek())/2;
        }
        else{
        	return max_heap.peek();
        }
    }
}

class MedianFromDataStream{
	public static void main(String[] args) {
	   }
	}