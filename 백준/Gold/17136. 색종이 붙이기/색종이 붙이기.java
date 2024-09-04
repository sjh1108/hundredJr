import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    
    static int[][] map = new int[10][10];
    static int[] p = {0, 5, 5, 5, 5, 5};
    static int min = 100;
    static boolean isEnd;

    public static void main(String[] args) throws IOException{
        for(int i = 0; i < 10; i++){
            st = new StringTokenizer(br.readLine());

            for(int j = 0; j < 10; j++){
                if(st.nextToken().equals("0")){
                    map[i][j] = 0;
                } else{
                    map[i][j] = 1;
                }
            }
        }

        dfs(0, 0, 0);
        if(min == 100) System.out.println(-1);
        else System.out.println(min);
    }

    static boolean isPossible(int x, int y, int size){

        for(int i = x; i < x + size; i++){
            for(int j = y; j < y + size; j++){
                if(i > 9 || j > 9) return false;
                if(map[i][j] != 1) return false;
            }
        }

        return true;
    }

    static void fillMap(int x, int y, int size){
        for(int i = x; i < x + size; i++){
            for(int j = y; j < y + size; j++){
                map[i][j] = 2;
            }
        }
    }
    static void unfillMap(int x, int y, int size){
        for(int i = x; i < x + size; i++){
            for(int j = y; j < y + size; j++){
                map[i][j] = 1;
            }
        }
    }

    static void dfs(int x, int y, int count){
        if(x == 9 && y == 10){
            min = Math.min(min, count);
            return;
        }

        if(y == 10){
            dfs(x+1, 0, count);
            return;
        }

        if(count >= min) return;

        if(map[x][y] == 1){
            for(int i = 5; i > 0; i--){
                if(isPossible(x, y, i) && p[i] > 0){
                    fillMap(x, y, i);
                    p[i]--;

                    dfs(x, y+1, count+1);

                    unfillMap(x, y, i);
                    p[i]++;
                }
            }
        } else{
            dfs(x, y+1, count);
        }
    }
}
