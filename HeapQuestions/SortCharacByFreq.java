import java.util.*;
class SortCharacByFreq{
	 public String frequencySort(String s) {
        StringBuilder ans=new StringBuilder();
        PriorityQueue<Pair<Integer,Character>> max_heap=new PriorityQueue<>((p1,p2)->p2.getKey()-p1.getKey());
        HashMap<Character,Integer> freq=new HashMap<>();
        for(int i=0;i<s.length();i++){
        	if(freq.containsKey(s.charAt(i))){
        		freq.put(s.charAt(i),freq.get(s.charAt(i))+1);
        	}
        	else{
        		freq.put(s.charAt(i),1);
        	}        	
        }
        for(Map.Entry<Character,Integer> entry:freq.entrySet()){
        	max_heap.add(new Pair(entry.getValue(),entry.getKey()));
        }
         System.out.println(max_heap);
        while(max_heap.size()!=0){
        	Pair<Integer,Character> rp=max_heap.peek();
        	for(int i=1;i<=rp.getKey();i++){
        		ans.append(rp.getValue());
        	}
        	max_heap.poll();
        } 
        return ans.toString();
    }
	public static void main(String[] args) {
	   }
	}