import java.util.*;
import java.io.*;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int N, M;

    static class Point{
        int x, y;

        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    static int[][] map;
    static ArrayList<Point> chicken = new ArrayList<>();
    static ArrayList<Point> house = new ArrayList<>();

    static boolean[] visited;
    static int ans = Integer.MAX_VALUE;
    
    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); M = Integer.parseInt(st.nextToken());

        map = new int[N][N];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());

                if(map[i][j] == 1) house.add(new Point(i, j));
                else if(map[i][j] == 2) chicken.add(new Point(i, j));
            }
        }

        visited = new boolean[chicken.size()];
        dfs(0, 0);

        System.out.println(ans);
    }

    static void dfs(int start, int cnt){
        if(cnt == M){
            int sum = 0;

            for(int i = 0; i < house.size(); i++){
                int min = Integer.MAX_VALUE;

                for(int j = 0; j < chicken.size(); j++){
                    if(visited[j]){
                        int dist = Math.abs(house.get(i).x - chicken.get(j).x) + Math.abs(house.get(i).y - chicken.get(j).y);
                        min = Math.min(min, dist);
                    }
                }

                sum += min;
            }

            ans = Math.min(ans, sum);
            return;
        }

        for(int i = start; i < chicken.size(); i++){
            visited[i] = true;
            dfs(i + 1, cnt + 1);
            visited[i] = false;
        }
    }
}