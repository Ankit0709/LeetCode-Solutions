//MeetingRooms
//Problem LInk : https://www.interviewbit.com/problems/meeting-rooms/
public class MeetingRooms {
     public int solve(ArrayList<ArrayList<Integer>> A) {
    	Collections.sort(A,(x1,x2)->{
    		return x1.get(0)-x2.get(0);
    	});
    	int prev=0;
    	int i=1;
    	int cnt=1;
    	PriorityQueue<Integer> heap = new PriorityQueue<>();
    	heap.add(A.get(0).get(1));
    	while(i<A.size()){
    		//start time greater than prev end time then 
    		if(A.get(i).get(0)<heap.peek()){
    			cnt++;
    		}
    		else{
    			heap.poll();
    		}
    		heap.add(A.get(i).get(1));
    		i++;
       	}
    	return cnt;
    }
    public int solveOptimised(ArrayList<ArrayList<Integer>> A){
    	int[] start=new int[A.size()];
    	int[] end=new int[A.size()];
    	int indx=0;
    	for(int i=0;i<start.length;i++){
    		start[i]=A.get(i).get(0);
    		end[i]=A.get(i).get(1);
    	}
    	Arrays.sort(start);
    	Arrays.sort(end);
    	for(int i=0;i<start.length;i++){
    		if(start[i]>=end[indx]){
    			indx++;
    		}
    	}
    	return end.length-indx;
    }
}
