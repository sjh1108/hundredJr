import java.io.BufferedReader;
// import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Solution {
    private static int N;
    private static int cnt;

    private static int[] ingredient;

    private static void subSet(int n, int count, int visit){
        if(count == N){
            ++cnt;
            return;
        }

        if((visit & ingredient[n]) == 0){
            subSet(n+1, count+1, visit + (1 << n));
        }
        subSet(n+1, count+1, visit);
    } 
 
    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("./input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
        int T = Integer.parseInt(br.readLine());
 
        StringBuilder sb = new StringBuilder();
        for(int t = 1; t <= T; t++){
            sb.append("#" + t).append(' ');
 
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
 
            cnt = 0;
            ingredient = new int[N+1];
            for(int i = 0; i < M; i++){
                st = new StringTokenizer(br.readLine());
 
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                
                ingredient[a] |= (1<<b);
                ingredient[b] |= (1<<a);
            }
 
            subSet(1, 0, 0);
            
            sb.append(cnt);
            sb.append('\n');
        }
 
        System.out.println(sb);
    }
 
}