import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    // static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N, M, K;
    static int[] arr;

    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static LinkedList<Integer> list = new LinkedList<>();


    public static void main(String[] args) throws IOException{
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N][N];
        for(int i = 0; i < N; i++){
            String s = br.readLine();

            for(int j = 0; j < N; j++){
                map[i][j] = s.charAt(j) - '0';
            }
        }

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(!visited[i][j] && map[i][j] == 1){
                    list.add(dfs(i, j));
                }
            }
        }

        sb.append(list.size()).append('\n');
        Collections.sort(list);
        while(list.size() > 0){
            sb.append(list.poll()).append('\n');
        }
        System.out.println(sb);
    }

    public static int dfs(int x, int y){
        visited[x][y] = true;
        int size = 1;

        for(int i = 0; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
            if(visited[nx][ny] || map[nx][ny] == 0) continue;

            size += dfs(nx, ny);
        }

        return size;
    }
}