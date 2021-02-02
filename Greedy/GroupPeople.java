//GroupPeople
//Problem Link : https://leetcode.com/problems/group-the-people-given-the-group-size-they-belong-to/
class GroupPeople {
	 List<List<Integer>> ans=new ArrayList<>();
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        ArrayList<Pair> list=new ArrayList<>();
        for(int i=0;i<groupSizes.length;i++){
        	list.add(new Pair(i,groupSizes[i]));
        }
        Collections.sort(list,(p1,p2)->{
        	return p1.s-p2.s;
        });
        int i=0;
        for(;i<list.size();){
        	List<Integer> x=new ArrayList<>();
            int size=list.get(i).s;
        	while(i<list.size()&&x.size()<size){
        		x.add(list.get(i).f);
        		i++;
        	}
        	ans.add(x);
        }
        return ans;

    }
}
class Pair{
	int f,s;
	Pair(int x,int y){
		f=x;
		s=y;
	}
}