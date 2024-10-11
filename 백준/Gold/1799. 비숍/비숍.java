import java.io.*;
import java.util.*;

public class Main{
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    static int N, M, K;

    static class Point{
        int x, y;
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    static int[][] map;

    static List<Point> bList = new ArrayList<>();
    static List<Point> wList = new ArrayList<>();

    static int bSize = 0, wSize = 0;
    static void Bfs(int cur, List<Point> list){
        Point p = bList.get(cur);
        for(Point before: list){
            if(Math.abs(p.x - before.x) == Math.abs(p.y - before.y)){
                return;
            }
        }

        list.add(p);
        bSize = Math.max(bSize, list.size());
        for(int i = cur + 1; i < bList.size(); i++){
            Bfs(i, list);
        }
        list.remove(list.size() - 1);
    }
    static void Wfs(int cur, List<Point> list){
        Point p = wList.get(cur);
        for(Point before: list){
            if(Math.abs(p.x - before.x) == Math.abs(p.y - before.y)){
                return;
            }
        }

        list.add(p);
        wSize = Math.max(wSize, list.size());
        for(int i = cur + 1; i < wList.size(); i++){
            Wfs(i, list);
        }
        list.remove(list.size() - 1);
    }

    public static void main(String[] args) throws IOException{
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());

                if(map[i][j] == 1){
                    if((i + j) % 2 == 0) wList.add(new Point(i, j));
                    else bList.add(new Point(i, j));
                }
            }
        }

        for(int i = 0; i < bList.size(); i++){
            Bfs(i, new ArrayList<>());
        }
        for(int i = 0; i < wList.size(); i++){
            Wfs(i, new ArrayList<>());
        }
        System.out.println(bSize + wSize);
    }
}