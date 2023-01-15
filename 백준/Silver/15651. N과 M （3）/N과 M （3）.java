import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int N;
    static int M;
    static int[] arr;
    static boolean[] visited;

    public static void main(String[] args) throws IOException{
        StringTokenizer st = new StringTokenizer(br.readLine());


        // n 최댓값
        N = Integer.parseInt(st.nextToken());
        // m 1열당 숫자 개수
        M = Integer.parseInt(st.nextToken());

        arr = new int[M];
        visited = new boolean[N];

        DFS(1, 0);

        System.out.println(sb);
    }

    static void DFS(int at, int cnt){
        if(cnt == M){
            for(int val: arr){
                sb.append(val).append(' ');
            }
            sb.append('\n');
            return;
        }

        for(int i = 1; i <= N; i++){
            arr[cnt] = i;
            DFS(i + 1, cnt + 1);
        }

        return;
    }
}