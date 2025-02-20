class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;
        int workers = schedules.length;
        
        for(int i = 0 ; i < workers; i++){
            int tmp = schedules[i] + 10;
            if(tmp % 100 > 59){
                int hh = tmp / 100;
                int mm = tmp % 100;
                hh += 1;
                mm = mm % 60;
                
                tmp = hh * 100 + mm;
            }
            
            schedules[i] = tmp;
        }
        
        int sat = (13 - startday) % 7;
        int sun = 7 - startday;
        
        for(int i = 0; i < workers; i++){
            int cnt = 0;
            
            for(int j = 0; j < 7; j++){
                if(j == sat || j == sun) continue;
                
                if(timelogs[i][j] <= schedules[i]) cnt++;
            }
            
            if(cnt == 5) answer++;
        }
        
        return answer;
    }
}