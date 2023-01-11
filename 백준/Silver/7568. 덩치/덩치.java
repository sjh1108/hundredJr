//import java.util.*;
import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException{
        int N = Integer.parseInt(br.readLine());
        
        int[][] p = new int[N][3];
        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            p[i][0] = Integer.parseInt(st.nextToken());
            p[i][1] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < N; i++){
            int rank = 1;

            for(int j = 0; j < N; j++){
                if(i == j) continue;
                if(p[i][0] < p[j][0] && p[i][1] < p[j][1]){
                    rank++;
                }
            }

            sb.append(rank).append(' ');
        }
        
        System.out.println(sb);
    }
}