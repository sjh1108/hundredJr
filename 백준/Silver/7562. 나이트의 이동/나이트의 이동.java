import java.util.*;
import java.io.*;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int N, M;

    static class Point{
        int x, y;
        int cnt;

        Point(int x, int y){
            this.x = x;
            this.y = y;
            this.cnt = 0;
        }
        Point(int x, int y, int cnt){
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }
    
    static boolean[][] visited;
    static Point Dest;

    public static void main(String[] args) throws IOException{
        int n = Integer.parseInt(br.readLine());

        while(n-- > 0){
            N = Integer.parseInt(br.readLine());
            visited = new boolean[N][N];

            st = new StringTokenizer(br.readLine());
            Point knight = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

            st = new StringTokenizer(br.readLine());
            Dest = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

            sb.append(bfs(knight)).append('\n');
        }
        System.out.println(sb);
    }

    static int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2};
    static int[] dy = {1, 2, 2, 1, -1, -2, -2, -1};

    static int bfs(Point knight){
        int cnt = 0;

        Queue<Point> q = new LinkedList<>();
        q.offer(knight);

        while(!q.isEmpty()){
            Point cur = q.poll();

            if(cur.x == Dest.x && cur.y == Dest.y){
                return cur.cnt;
            }

            for(int i = 0; i < 8; i++){
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
                if(visited[nx][ny]) continue;

                visited[nx][ny] = true;
                q.offer(new Point(nx, ny, cur.cnt + 1));
            }
        }

        return cnt;
    }
}