import java.util.*;
class TopKFreqElements{
	public int[] topKFrequent(int[] nums, int k) {
		//build min heap of pair<freq,number>
        PriorityQueue<Pair<Integer,Integer>> min_heap=new PriorityQueue<>((p1,p2)->p1.getKey()-p2.getKey());
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
        	if(map.containsKey(nums[i])){
        		map.put(nums[i],map.get(nums[i]+1));
        	}
        	else{
        		map.put(nums[i],1);
        	}       	
        	
        }
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
           if(min_heap.size()==K){
           	if(min_heap.peek().getKey()<entry.getValue()){
           		min_heap.poll();
           		min_heap.add(new Pair(entry.getValue(),entry.getKey()));
           	}
           }
           else{
           	min_heap.add(new Pair(entry.getValue(),entry.getKey()));
           }
        }
        int ans[]=new int[k];
        for(int i=0;i<k;i++){
        	ans[i]=min_heap.poll();
        }
    }
	public static void main(String[] args) {
	   }
	}