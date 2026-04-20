import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int N, M;
    static int[] arr;
    static int[] result;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        result = new int[M];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        
        DFS(0, 0);

        System.out.println(sb);
    }

    static void DFS(int cnt, int last){
        if(cnt == M){
            for(int i = 0; i < M; i++){
                sb.append(result[i]).append(" ");
            }
            sb.append("\n");
        } else{
            for(int i = last; i < N; i++){
                result[cnt] = arr[i];
                DFS(cnt + 1, i);
            }
        }

    }
}
