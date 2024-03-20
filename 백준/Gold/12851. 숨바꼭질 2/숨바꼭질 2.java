import java.util.*;
import java.io.*;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int N, M;

    static int[] arr = new int[100001];
    static int minTime = Integer.MAX_VALUE;
    static int cnt = 0;
    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); M = Integer.parseInt(st.nextToken());
        if(N >= M){
            System.out.println(N - M);
            System.out.println(1);
            return;
        }

        bfs();
        System.out.println(minTime);
        System.out.println(cnt);
    }

    static void bfs(){
        Queue<Integer> q = new LinkedList<>();
        q.add(N);

        arr[N] = 1;

        while(!q.isEmpty()){
            int cur = q.poll();

            if(minTime < arr[cur]) return;
            
            for(int i = 0; i < 3; i++){
                int next = 0;
                if(i == 0)      next = cur + 1;
                else if(i == 1) next = cur - 1;
                else            next = cur * 2; 

                if(next < 0 || next > 100000) continue;

                if(next == M){
                    minTime = arr[cur];
                    cnt++;
                }

                if(arr[next] == 0 || arr[next] >= arr[cur] + 1){
                    arr[next] = arr[cur] + 1;
                    q.add(next);
                }
            }
        }
    }
}