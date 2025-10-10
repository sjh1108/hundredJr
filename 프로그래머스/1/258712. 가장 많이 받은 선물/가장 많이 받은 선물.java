import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        HashMap<String, Integer> indexMap = new HashMap<>();
        
        int size = friends.length;
        for(int i = 0; i < size; i++){
            indexMap.put(friends[i], i);
        }
        
        int[][] giftMap = new int[size][size];
        StringTokenizer st;
        for(String giftRecord : gifts){
            st = new StringTokenizer(giftRecord);
            
            int sender = indexMap.get(st.nextToken());
            int reciever = indexMap.get(st.nextToken());
            
            giftMap[sender][reciever]++;
        }

        int[] score = new int[size];
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                if(i==j) continue;
                
                score[i] += giftMap[i][j];
                score[i] -= giftMap[j][i];
            }
        }
        
        int max = 0;
        int[] nMonth = new int[size];
        for(int i = 0; i < size; i++){
            int cnt = 0;
            
            for(int j = 0; j < size; j++){
                if(i==j) continue;
                
                if((giftMap[i][j] == 0 && giftMap[j][i] == 0) && score[i] > score[j]){
                    cnt++;
                } else if(giftMap[i][j] > giftMap[j][i]){
                    cnt++;
                } else if(giftMap[i][j] == giftMap[j][i] && score[i] > score[j]) cnt++;
            }
            
            max = Math.max(max, cnt);
        }
        
        return max;
    }
}