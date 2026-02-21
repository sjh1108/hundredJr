import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        char[][] floor = new char[N][M];
        for (int i = 0; i < N; i++) {
            floor[i] = br.readLine().toCharArray();
        }
        
        int count = 0;
        
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(floor[i][j] == '-'){
                    if(j == 0 || floor[i][j - 1] != '-'){
                        count++;
                    }
                } else{
                    if(i == 0 || floor[i - 1][j] != '|'){
                        count++;
                    }
                }
            }
        }
        
        System.out.println(count);
    }
}