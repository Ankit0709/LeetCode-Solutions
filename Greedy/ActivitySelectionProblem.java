//ActivitySelectionProblem
//Problem Link : https://www.interviewbit.com/tutorial/activity-selection-problem/
class Pair{
	int f,s;
	Pair(int x,int y){
		f=x;
		s=y;
	}
}
class ActivitySelectionProblem{
	public int solution(int[] start,int[] endtime,int n){
		int cnt=1;
		int indx=0;
		ArrayList<Pair> list=new ArrayList<>();
		for(int i=0;i<n;i++){
			list.add(new Pair(start[i],end[i]));
		}
		//sort on basis of endtime
		Collections.sort(list,(p1,p2)->{
			return p1.s-p2.s;
		});
		for(int i=1;i<n;i++){
			//check if starting time of curr is greater than or eqaul to prev endtime so we can do that activity
			if(list.get(i).f>=list.get(indx).s){
				cnt++;
				indx=i;
			}
		}
		return cnt;
	}
}