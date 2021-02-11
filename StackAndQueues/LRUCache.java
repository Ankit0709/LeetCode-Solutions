//LRUCache
//Problem LInk : https://leetcode.com/problems/lru-cache/
class LRUCache {
	 Deque<Integer> deque;
	HashMap<Integer,Integer> map;
	int capacity;

    public LRUCache(int capacity) {
        deque=new LinkedList<>();
        map=new HashMap<>();
        this.capacity=capacity;
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
            deque.remove(key);
            deque.addFirst(key);
            return map.get(key);
        }
        else{
            return -1;
        }
       
    }
    
    public void put(int key, int value) {
        map.put(key,value);
        if(deque.contains(key)){
        	deque.remove(key);
        }
        else if(deque.size()==capacity){
        	int last=deque.removeLast();
            map.remove(last);
        }
        deque.addFirst(key);
    }
}
