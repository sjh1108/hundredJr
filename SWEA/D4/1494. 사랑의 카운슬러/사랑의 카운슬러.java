import java.util.*;
import java.io.*;

class Solution {
    static class Point{
        long x, y;
        
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static int N;
    private static int visited;
    private static long res;

    private static Point[] points;

    private static void getMin(){
        long x = 0;
        long y = 0;

        for(int i = 0; i < N; i++){
            if((visited & (1 << i)) != 0){
                x += points[i].x;
                y += points[i].y;
            } else{
                x -= points[i].x;
                y -= points[i].y;
            }
        }

        res = Math.min(res, (x*x) + (y*y));
    }

    private static void dfs(int depth, int start){
        if(depth == points.length >> 1){
            getMin();
            return;
        }

        for(int i = start; i < N; i++){
            if((visited & (1 << i)) != 0) continue;

            visited |= 1 << i;
            dfs(depth+1, i+1);
            visited ^= 1 << i;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; ++t) {
            N = Integer.parseInt(br.readLine());
            visited = 0;
            res = Long.MAX_VALUE;

            points = new Point[N];
            StringTokenizer st;
            for(int i = 0; i < N; i++){
                st = new StringTokenizer(br.readLine());
                
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                points[i] = new Point(x, y);
            }

            dfs(0, 0);

            System.out.println("#" + t + " " + res);
        }
    }
}