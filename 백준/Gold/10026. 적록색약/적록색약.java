import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    // static BufferedWriter bw = new BufferedWriter(new
    // OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N, M, K;
    static int[] arr;


    static int[][] rgb;
    static int[][] rgb1;
    static boolean[][] visit;
    static boolean[][] visit1;
    static int[][] map;
    static int[][] map1;
    static int dx[] = { -1, 1, 0, 0 };
    static int dy[] = { 0, 0, -1, 1 };
    static int num = 0, num1 = 0;

    static void DFS(int x, int y){
        if(visit[x][y]){
            return;
        }

        visit[x][y] = true;
        if(map[x][y] == 0){
            map[x][y] = ++num;
        }

        for(int k = 0; k < 4; k++){
            int nx = x + dx[k];
            int ny = y + dy[k];

            if(nx < 0 || nx >= N || ny < 0 || ny >= N){
                continue;
            }

            if(rgb[x][y] == rgb[nx][ny]){
                map[nx][ny] = map[x][y];
                DFS(nx, ny);
            }
        }
    }
    static void DFS1(int x, int y){
        if(visit1[x][y]){
            return;
        }

        visit1[x][y] = true;
        if(map1[x][y] == 0){
            map1[x][y] = ++num1;
        }

        for(int k = 0; k < 4; k++){
            int nx = x + dx[k];
            int ny = y + dy[k];

            if(nx < 0 || nx >= N || ny < 0 || ny >= N){
                continue;
            }

            if(rgb1[x][y] == rgb1[nx][ny]){
                map1[nx][ny] = map1[x][y];
                DFS1(nx, ny);
            }
        }
    }
    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());

        rgb = new int[N][N];
        rgb1 = new int[N][N];
        for(int i = 0; i < N; i++){
            String s = br.readLine();
            for(int j = 0; j < N; j++){
                char c = s.charAt(j);

                if(c == 'R'){
                    rgb[i][j] = 1;
                    rgb1[i][j] = 1;
                }
                if(c == 'G'){
                    rgb[i][j] = 2;
                    rgb1[i][j] = 1;
                }
                if(c == 'B'){
                    rgb[i][j] = 3;
                    rgb1[i][j] = 2;
                }
            }
        }

        visit = new boolean[N][N];
        visit1 = new boolean[N][N];
        map = new int[N][N];
        map1 = new int[N][N];

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                DFS(i, j);
                DFS1(i, j);
            }
        }

        sb.append(num).append(' ').append(num1);

        System.out.println(sb);
    }
}