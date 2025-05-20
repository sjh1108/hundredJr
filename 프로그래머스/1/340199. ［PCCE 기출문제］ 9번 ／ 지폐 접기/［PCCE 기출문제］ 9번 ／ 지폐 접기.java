class Solution {
    static private int answer = 0;
    public int solution(int[] wallet, int[] bill) {
        if(wallet[0] > wallet[1]){
            int tmp = wallet[1];
            wallet[1] = wallet[0];
            wallet[0] = tmp;
        }
        
        while(!sol(wallet, bill)){
            func(bill);
        }
        
        return answer;
    }
    
    private void func(int[] bill){
        if(bill[0] > bill[1]){
            bill[0] /= 2;
        } else{
            bill[1] /= 2;
        }
        
        answer++;
    }
    
    private boolean sol(int[] wallet, int bill[]){
        if(bill[0] > bill[1]){
            if(wallet[1] >= bill[0]){
                if(wallet[0] >= bill[1]){
                    return true;
                }
            }
        } else{
            if(wallet[1] >= bill[1]){
                if(wallet[0] >= bill[0]){
                    return true;
                }
            }
        }
        
        return false;
    }
}