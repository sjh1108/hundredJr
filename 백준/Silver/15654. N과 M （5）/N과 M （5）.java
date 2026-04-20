import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int N, M;
    static int arr[];
    static int num[];
    static boolean visit[];

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        num = new int[N];
        arr = new int[M];
        visit = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            num[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(num);  
        DFS(0);
        
        System.out.println(sb);
    }

    public static void DFS(int count){
        if(count == M){
            for(int i = 0; i < M; i++){
                sb.append(arr[i]).append(' ');
            }
            sb.append('\n');
            return;
        }

        for(int i = 0; i < N; i++){
            if(!visit[i]){
                visit[i] = !visit[i];
                arr[count] = num[i];
                DFS(count + 1);
                visit[i] = !visit[i];
            }
        }
    }
}
