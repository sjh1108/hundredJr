import java.io.*;
import java.util.*;

public class Main{
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    static int N, M, K;
    static int[][] map;

    static void endPrint(){
        if(isEnd()){
            printMap();
            System.exit(0);
        }
    }
    static boolean isEnd(){
        return K == 0;
    }

    static void backTracking(int idx){
        endPrint();

        int x = (idx-1)/9 + 1;
        int y = (idx-1)%9 + 1;

        if(map[x][y] != 0){
            backTracking(idx+1);
        }else{
            for(int i = 1; i < 10; i++){
                if(isPossible(x, y, i)){
                    map[x][y] = i;
                    K--;
                    backTracking(idx+1);
                    map[x][y] = 0;
                    K++;
                }
            }
        }
    }

    static boolean isPossible(int x, int y, int k){
        for(int i = 1; i < 10; i++){
            if(map[x][i] == k || map[i][y] == k){
                return false;
            }

            int nx = (x-1)/3*3 + 1 + (i-1)/3;
            int ny = (y-1)/3*3 + 1 + (i-1)%3;
            if(map[nx][ny] == k && !(nx == x && ny == y)) return false;
        }

        return true;
    }
    static void printMap(){
        for(int i = 1; i < 10; i++){
            for(int j = 1; j < 10; j++){
                sb.append(map[i][j]);
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

    public static void main(String[] args) throws IOException{
        map = new int[10][10];
        K = 0;

        for(int i = 1; i < 10; i++){
            String s = br.readLine();
            for(int j = 1; j < 10; j++){
                map[i][j] = (int)(s.charAt(j-1) - '0');
                if(map[i][j] == 0){
                    K++;
                }
            }
        }

        backTracking(1);
    }
}