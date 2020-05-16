//MeetingRooms2
import java.util.*;
 class Interval {
      int start, end;
     Interval(int start, int end) {
        this.start = start;
        this.end = end;
     }
     public String toString(){
     	return "{"+start+":"+end+"}";
     }
}
class MeetingRooms2{
	
	 public int minMeetingRooms(List<Interval> intervals) {
       PriorityQueue<Integer> heap = new PriorityQueue<>();
		Collections.sort(intervals,(i1,i2)->i1.start-i2.start);
		heap.add(intervals.get(0).end);
		for(int i=1;i<intervals.size();i++){
			if(heap.peek()<intervals.get(i).end){
				heap.poll();
				heap.add(intervals.get(i).end);
			}
			else{
				heap.add(intervals.get(i).end);
			}
		}
		return heap.size();
    }
	public static void main(String[] args) {
		List<Intervals> list=new ArrayList<>();
		list.add(new Interval((6,15)));
		[,(13,20),(6,17)];
	}
}