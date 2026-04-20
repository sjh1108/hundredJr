import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int N, M;
    static int num[][];
    static int arr[][];
    static boolean visit[][];
    static int[] dx = { 1, -1, 0, 0 };
    static int[] dy = { 0, 0, 1, -1 };
    static int x, y;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        num = new int[N][M];
        visit = new boolean[N][M];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());

            for(int j = 0; j < M; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j] == 2){
                    x = i;
                    y = j;
                }
            }
        }
        BFS();

        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(num[i][j] == 0){
                    if(arr[i][j] == 0 || arr[i][j] == 2){
                        sb.append(0);
                    } else{
                        sb.append(-1);
                    }
                    sb.append(' ');
                    continue;
                }
                sb.append(num[i][j]).append(' ');
            }
            sb.append('\n');
        }

        System.out.println(sb);
    }

    public static void BFS(){
        LinkedList<int[]> path = new LinkedList<>();
        path.add(new int[]{ x, y });
        visit[x][y] = true;
        num[x][y] = 0;

        while(!path.isEmpty()){
            int xy[] = path.poll();
            x = xy[0];
            y = xy[1];

            for(int i = 0; i < 4; i++){
                int zx = x + dx[i];
                int zy = y + dy[i];

                if(zx < 0 || zx >= N || zy < 0 || zy >= M){
                    continue;
                }
                if(visit[zx][zy]){
                    continue;
                }
                if(arr[zx][zy] == 0){
                    num[zx][zy] = 0;
                    visit[zx][zy] = true;
                    continue;
                }

                num[zx][zy] = num[x][y] + 1;
                visit[zx][zy] = true;

                path.add(new int[]{ zx, zy });
            }
        }
    }
}
