import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        
        int[] targets = new int[M];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++){
            targets[i] = Integer.parseInt(st.nextToken());
        }
        
        int[] points = new int[N];
        for(int i = 0; i < M; i++){
            int miss = 0;
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                int pred = Integer.parseInt(st.nextToken());
                
                if(pred == targets[i]){
                    points[j]++;
                } else{
                    miss++;
                }
            }
            
            points[targets[i]-1] += miss;
        }
        
        for(int i: points){
            System.out.println(i);
        }
    }
}