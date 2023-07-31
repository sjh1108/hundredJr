import java.util.*;
import java.io.*;

public class Main{
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int N, M;
    static long res;
    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        res = -1;
        BFS(N, M);
        
        System.out.println(res);
    }

    static void BFS(long a, long b){
        long[] arr = new long[2];

        Queue<long[]> q = new LinkedList<>();
        q.offer(new long[]{a, 1});

        while(!q.isEmpty()){
            arr = q.poll();
            if(arr[0] == b){
                res = arr[1];
                return;
            }

            if(arr[0] * 2 <= b){
                q.offer(new long[]{arr[0] * 2, arr[1] + 1});
            }
            if(arr[0] * 10 + 1 <= b){
                q.offer(new long[]{arr[0] * 10 + 1, arr[1] + 1});
            }
        }
    }
}