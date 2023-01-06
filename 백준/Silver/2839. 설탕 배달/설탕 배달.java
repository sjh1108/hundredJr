import java.util.*;


public class Main {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        
        int n = s.nextInt();

        int[] sugar = new int[n + 1];
        for(int i = 3; i < n + 1; i++){
            if((i == 3) || (i == 5)){
                sugar[i] = 1;
                continue;
            } else if(i < 5){
                continue;
            }
            if((sugar[i- 3] == 0) && sugar[i - 5] == 0){
                continue;
            } else if(sugar[i - 3] == 0){
                sugar[i] = sugar[i-5] + 1;
                continue;
            } else if(sugar[i - 5] == 0){
                sugar[i] = sugar[i-3] + 1;
                continue;
            } 
            sugar[i] = Math.min(sugar[i-3], sugar[i-5]) + 1;
        }
        if(sugar[n] != 0){
            System.out.println(sugar[n]);
        } else{
            System.out.println(-1);
        }

        s.close();
    }
}
