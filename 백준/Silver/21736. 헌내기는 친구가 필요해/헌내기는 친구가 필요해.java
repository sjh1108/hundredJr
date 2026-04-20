import java.util.*;
import java.io.*;

public class Main{
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int N, M;

    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int arr[][] = new int[N][M];

        int x = 0, y = 0;
        for(int i = 0; i < N; i++){
            String s = br.readLine();

            for(int j = 0; j < M; j++){
                char c = s.charAt(j);

                if(c == 'O'){
                    arr[i][j] = 0;
                }
                else if(c == 'X'){
                    arr[i][j] = -1;
                }
                else if(c == 'P'){
                    arr[i][j] = 2;
                }
                else{
                    arr[i][j] = 1;
                    x = i; y = j;
                }
            }
        }

        int zx[] = new int[]{ 1, -1, 0, 0 };
        int zy[] = new int[]{ 0, 0, 1, -1 };
        boolean visit[][] = new boolean[N][M];

        int parr[] = new int[]{ x, y };
        LinkedList<int[]> bfs = new LinkedList<>();
        bfs.add(parr);
        int sum = 0;

        while(!bfs.isEmpty()){
            int p[] = bfs.pop();
            
            for(int i = 0; i < 4; i++){
                int dx = p[0] + zx[i];
                int dy = p[1] + zy[i];

                if(dx < 0 || dx >= N || dy < 0 || dy >= M) continue;
                if(visit[dx][dy]) continue;
                if(arr[dx][dy] == -1) continue;

                if(arr[dx][dy] == 2) sum++;
                visit[dx][dy] = true;
                bfs.add(new int[]{ dx, dy });
            }
        }

        if(sum == 0){
            System.out.println("TT");
            return;
        }
        System.out.println(sum);
    }
}