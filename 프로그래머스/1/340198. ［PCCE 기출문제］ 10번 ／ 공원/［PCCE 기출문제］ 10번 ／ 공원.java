import java.util.*;

class Solution {
    public int solution(int[] mats, String[][] park) {
        // mats sort
        boolean flag = true;
        while(flag){
            flag = false;
            
            for(int i = 0; i < mats.length - 1; i++){
                if(mats[i] < mats[i+1]){
                    int tmp = mats[i];
                    mats[i] = mats[i+1];
                    mats[i+1] = tmp;
                    
                    flag = true;
                }
            }
        }
        
        // get answer
        for(int size: mats){
            
            for(int i = 0; i < park.length - size+1; i++){
                for(int j = 0; j < park[i].length - size+1; j++){
                    
                    if(park[i][j].equals("-1") 
                       && check(i, j, park, size)){
                        
                        System.out.println(size);
                        return size;
                    }
                }
            }
        }
        
        return -1;
    }
    
    private boolean check(int x, int y, String[][] park, int size){
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                if(!park[x+i][y+j].equals("-1")){
                    return false;
                }
            }
        }
        
        return true;
    }
}