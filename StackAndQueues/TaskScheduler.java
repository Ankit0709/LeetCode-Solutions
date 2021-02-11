// /TaskScheduler
//Problem LInk : https://leetcode.com/problems/task-scheduler/
class TaskScheduler {
    public int leastInterval(char[] tasks, int n) {
        HashMap<Character,Integer> freq=new HashMap<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a.b)->{return b-a;});
        for(int i=0;i<tasks.length;i++){
        	freq.put(tasks[i],map.getOrDefault(tasks[i],0)+1);
        }
        maxHeap.addAll(freq.values());
        int cycles=0;
        while(!maxHeap.isEmpty()){
        	List<Integer> list=new ArrayList<>();
        	for(int i=0;i<=n;i++){
        		if(!maxHeap.isEmpty()){
        			int rp=maxHeap.remove();
        			list.add(rp);
        		}
        	}

        	for(Integer x:list){
        		if(--x>0){
        			maxHeap.add(x);
        		}
        	}
        	cycles+=maxHeap.isEmpty()?list.size():n+1;

        }
        return cycles;

    }
    //T(n)--> O(n) and S(n)--> O(1)
    public int leastIntervalOptimised(char[] tasks,int n){
    	int[] freq=new int[26];
    	int maxCount=0,maxnum=0;
    	for(int i=0;i<tasks.length;i++){
            int indx=tasks[i]-'A';
    		freq[indx]++;
    		maxCount=Math.max(maxCount,freq[indx]);
    	}    	
    	for(int i=0;i<26;i++){
    		if(maxCount==freq[i]){
    			maxnum++;
    		}
    	}
    	return Math.max(tasks.length,(maxCount-1)*(n+1)+maxnum);


    }
}

