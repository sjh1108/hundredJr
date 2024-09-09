import java.util.*;
import java.io.*;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int N, M, K;
    
    static int count;
    static class Point{
        int x, y;
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    static ArrayList<ArrayList<Point>> gates;
    static char[][] map;
    static boolean[][] visited;
    static boolean[] key;

    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static void bfs(){
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(0, 0));
        visited[0][0] = true;

        while(!q.isEmpty()){
            Point cur = q.poll();
            int x = cur.x;
            int y = cur.y;

            for(int i = 0; i < 4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx < 0 || ny < 0 || nx >= N+2 || ny >= M+2) continue;
                if(visited[nx][ny] || map[nx][ny] == '*') continue;

                visited[nx][ny] = true;
                if(map[nx][ny] == '$'){
                    count++;
                    map[nx][ny] = '.';
                }
                
                if(map[nx][ny] >= 'A' && map[nx][ny] <= 'Z'){
                    if(key[map[nx][ny] - 'A']){
                        map[nx][ny] = '.';
                        q.add(new Point(nx, ny));
                    }else{
                        gates.get(map[nx][ny] - 'A').add(new Point(nx, ny));
                    }
                }
                
                else if(map[nx][ny] >= 'a' && map[nx][ny] <= 'z'){
                    key[map[nx][ny] - 'a'] = true;
                    q.add(new Point(nx, ny));
                    for(Point p : gates.get(map[nx][ny] - 'a')){
                        q.add(p);
                    }
                    gates.get(map[nx][ny] - 'a').clear();
                }
                
                else{
                    q.add(new Point(nx, ny));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException{
        K = Integer.parseInt(br.readLine());

        while(K-- > 0){
            st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            map = new char[N+2][M+2];
            visited = new boolean[N+2][M+2];

            key = new boolean[26];
            gates = new ArrayList<>();
            for(int i = 0; i < 26; i++){
                gates.add(new ArrayList<>());
            }

            for(int i = 0; i < N+2; i++){
                for(int j = 0; j < M+2; j++){
                    map[i][j] = '.';
                }
            }

            for(int i = 1; i <= N; i++){
                String str = br.readLine();
                for(int j = 1; j <= M; j++){
                    map[i][j] = str.charAt(j-1);
                }
            }

            String keys = br.readLine();
            if(!keys.equals("0")){
                for(int i = 0; i < keys.length(); i++){
                    key[keys.charAt(i) - 'a'] = true;
                }
            }
            count = 0;
            bfs();
            sb.append(count).append("\n");
        }
        System.out.println(sb);
    }

}