//import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int N;
    static int M;
    static int[][] arr;
    static boolean[][] visit;

    public static void main(String[] args) throws IOException{
        N = Integer.parseInt(br.readLine());

        visit = new boolean[N][N];
        M = 0;

        for(int i = 0; i < N; i++){
            DFS(0, i);
        }

        System.out.println(M);
    }

    static void DFS(int x, int y){
        visit[x][y] = true;

        if(sero(x, y)){
            visit[x][y] = false;
            return;
        } else if(lup(x, y)){
            visit[x][y] = false;
            return;
        } else if(rup(x, y)){
            visit[x][y] = false;
            return;
        }
        
        else{
            if(x + 1 < N){
                for(int i = 0; i < N; i++){
                    if(i == y) continue;
                    DFS(x + 1, i);
                }
            } else{
                M++;
            }
        }

        visit[x][y] = false;

        return;
    }
    static boolean sero(int x, int y){

        for(int i = 1; i <= x; i++){
            if(visit[x - i][y]){
                return true;
            }
        }

        return false;
    }

    static boolean lup(int x, int y){

        for(int i = 1; i <= x && i <= y; i++){
            if(visit[x - i][y - i]){
                return true;
            }
        }

        return false;
    }

    static boolean rup(int x, int y){

        for(int i = 1; i <= x && i + y < N; i++){
            if(visit[x - i][y + i]){
                return true;
            }
        }

        return false;
    }
}