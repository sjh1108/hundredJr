import java.util.*;
import java.io.*;

class tomato {
    int x, y, z;

    public tomato(int z, int x, int y) {
        this.z = z;
        this.x = x;
        this.y = y;
    }
}

public class Main {
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    // static BufferedWriter bw = new BufferedWriter(new
    // OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N, M, K;
    static int[] arr;

    static int[] dx = { -1, 1, 0, 0, 0, 0 };
    static int[] dy = { 0, 0, -1, 1, 0, 0 };
    static int[] dz = { 0, 0, 0, 0, -1, 1 };
    static int[][][] board;
    static Queue<tomato> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        board = new int[K][N][M];
        for (int l = 0; l < K; l++) {
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());

                for (int j = 0; j < M; j++) {
                    board[l][i][j] = Integer.parseInt(st.nextToken());
                    if (board[l][i][j] == 1) {
                        q.add(new tomato(l, i, j));
                    }
                }
            }
        }

        System.out.println(BFS());
    }

    static int BFS(){
        while(!q.isEmpty()){
            tomato t = q.poll();

            int z = t.z;
            int x = t.x;
            int y = t.y;

            for(int i = 0; i < 6; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                int nz = z + dz[i];

                if(nx < 0 || nx >= N || ny < 0 || ny >= M || nz < 0 || nz >= K) continue;

                if(board[nz][nx][ny] == 0){
                    q.add(new tomato(nz, nx, ny));

                    board[nz][nx][ny] = board[z][x][y] + 1;
                }
            }

        }

        int result = -1;

        for(int i = 0; i < K; i++){
            for(int j = 0; j < N; j++){
                for(int k = 0; k < M; k++){
                    if(board[i][j][k] == 0) return - 1;

                    result = Math.max(result, board[i][j][k]);
                }
            }
        }

        if(result == 1) return 0;
        else return result - 1;
    }
}