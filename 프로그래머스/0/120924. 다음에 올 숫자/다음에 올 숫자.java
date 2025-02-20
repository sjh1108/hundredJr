class Solution {
    public int solution(int[] common) {
        int answer = 0;
        if(common.length == 2){
            return common[1] + (common[1] - common[0]);
        }
        
        boolean flag = false;
        if(common[2] - common[1] == common[1] - common[0]) flag = true;
        
        int len = common.length;
        
        if(flag){
            answer = common[len - 1] + (common[1] - common[0]);
        } else{
            int r = common[1] / common[0];
            
            answer = common[len-1] * r;
        }
        
        return answer;
    }
}