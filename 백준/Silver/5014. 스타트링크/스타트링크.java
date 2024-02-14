import java.util.*;
import java.io.*;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int N, M;
    static int[] arr;

    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());

        int f = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int g = Integer.parseInt(st.nextToken());
        int u = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        int[] arr = new int[f+1];
        boolean[] visited = new boolean[f+1];
        Queue<Integer> q = new LinkedList<>();
        q.add(s);

        while(!q.isEmpty()){
            int cur = q.poll();
            if(cur == g){
                System.out.println(arr[cur]);
                return;
            }
            
            int nextU = cur + u;
            int nextD = cur - d;

            if(nextU <= f && !visited[nextU] && u > 0){
                arr[nextU] = arr[cur] + 1;
                visited[nextU] = true;
                q.add(nextU);
            }
            if(nextD > 0 && !visited[nextD] && d > 0){
                arr[nextD] = arr[cur] + 1;
                visited[nextD] = true;
                q.add(nextD);
            }
        }
        System.out.println("use the stairs");
    }
}