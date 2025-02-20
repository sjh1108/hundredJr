class Solution {
    public int solution(String[] babbling) {
        String[] arr = { "aya", "ye", "woo", "ma" };
        
        int cnt = 0;
        for(String bab: babbling){
            
            for(String a : arr){
                if(bab.contains(a)){
                    bab = bab.replace(a, " ");
                }
            }
            
            bab = bab.replace(" ", "");
            if(bab.equals("")) cnt++;
        }
        
        return cnt;
    }
}