import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N;
    static int M;
    static int K;

    static int[] arr;
    static int[] visited = new int[100001];

    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        System.out.println(find(N));
    }

    static int find(int start){
        Queue<Integer> q = new LinkedList<>();

        q.add(start);
        int index = start;
        int n = 0;
        visited[index] = 1;

        while(!q.isEmpty()){
            n = q.remove();

            if(n == M){
                return visited[n] - 1;
            }

            if(n - 1 >= 0 && visited[n - 1] == 0){
                visited[n - 1] = visited[n] + 1;
                q.add(n - 1);
            }
            if (n+1 <= 100000 && visited[n+1] == 0)
			{
				visited[n + 1] = visited[n] + 1;
				q.add(n+1);
			}
			if (n * 2 <= 100000 && visited[n * 2] == 0)
			{
				visited[n * 2] = visited[n] + 1;
				q.add(n * 2);
			}
        }

        return -1;
    }
}