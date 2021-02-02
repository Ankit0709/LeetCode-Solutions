// /MinCostToMoveChipsToSamePos
//Problem LInk : https://leetcode.com/problems/minimum-cost-to-move-chips-to-the-same-position/
class MinCostToMoveChipsToSamePos {
    public int minCostToMoveChips(int[] position) {
        int cost=0;
        int odd=0,even=0;
        for(int i=0;i<position.length;i++){
            if((position[i]&1)==1){
                odd++;
            }
            else{
                even++;
            }
        }
        if(odd==0||even==0){
            return 0;
        }
        return Math.min(odd,even)*1;
        
    }
}