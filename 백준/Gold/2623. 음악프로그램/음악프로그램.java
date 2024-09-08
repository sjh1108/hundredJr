import java.io.*;
import java.util.*;

public class Main{
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    static int N, M, K;

    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for(int i = 0; i <= N; i++)
            list.add(new ArrayList<>());

        int[] arr = new int[N+1];
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            for(int j = 1; j < n; j++){
                int t = Integer.parseInt(st.nextToken());

                list.get(b).add(t);
                arr[t]++;

                b = t;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        ArrayList<Integer> result = new ArrayList<>();

        for(int i = 1; i <= N; i++){
            if(arr[i] == 0)
                q.offer(i);
        }

        while(!q.isEmpty()){
            int cur = q.poll();
            result.add(cur);

            for(int next : list.get(cur)){
                arr[next]--;
                if(arr[next] == 0)
                    q.offer(next);
            }
        }

        if(result.size() != N){
            System.out.println(0);
            return;
        }
        else{
            for(int i : result){
                sb.append(i).append("\n");
            }
            
            System.out.println(sb);
        }
    }
}