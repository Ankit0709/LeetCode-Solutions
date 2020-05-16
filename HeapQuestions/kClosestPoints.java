//kClosestPoints
import java.util.*;
import javafx.util.Pair; 
class kClosestPoints{
	public int[][] kClosest(int[][] points, int K) {
         PriorityQueue<Pair<Double,Integer>> heap = new PriorityQueue<>(K,new Comparator<Pair<Double,Integer>>(){
         public int compare(Pair p1,Pair p2){
            if(p1.getKey()<p2.getKey()) return -1;
            if(p1.getKey()>p2.getKey()) return 1;
             return 0;                
         } 
      });
      int count=0;
      for(int i=0;i<points.length;i++){
      	double dist=Math.sqrt(points[i][0]*points[i][0]+points[i][1]*points[i][1]);
      		if(count==k){
      			if(heap.peek().getKey()>dist){
      				heap.pop();
      				heap.add(new Pair(dist,i));
      			}
      	    }
        	else{
      		heap.add(new Pair(dist,i));      		
      	    }
      }
    }
	public static void main(String[] args) {
	   }
	}