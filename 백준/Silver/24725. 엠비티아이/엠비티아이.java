import java.util.*;
import java.io.*;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int N, M, K;
    
    static int count = 0;
    static char[][] map;
    
    static int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};
    static int[] dy = {1, 1, 0, -1, -1, -1, 0, 1};
    static void find(int x, int y, int depth){
        int cnt = 0;

        for(int i = 0; i < 8; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
            if(map[nx][ny] == 'N' || map[nx][ny] == 'S'){
                nx += dx[i];
                ny += dy[i];
                if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;

                if(map[nx][ny] == 'T' || map[nx][ny] == 'F'){
                    nx += dx[i];
                    ny += dy[i];

                    if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                    if(map[nx][ny] == 'P' || map[nx][ny] == 'J'){
                        cnt++;
                    }
                }
            }
        }

        count += cnt;
    }
    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][];
        for(int i = 0; i < N; i++){
            map[i] = br.readLine().toCharArray();
        }

        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(map[i][j] == 'E' || map[i][j] == 'I'){
                    find(i, j, 0);
                }
            }
        }

        System.out.println(count);
    }
}