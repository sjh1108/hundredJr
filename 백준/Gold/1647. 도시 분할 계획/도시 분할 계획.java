import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    // static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N, M, K;

    static int[] parent;
    static class Line implements Comparable<Line> {
        int start, end, weight;
        Line(int start, int end, int weight){
            this.start = start;
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Line o) {
            return this.weight - o.weight;
        }
    }

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        ArrayList<Line> lines = new ArrayList<>();
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            lines.add(new Line(start, end, weight));
        }

        parent = new int[N+1];
        for(int i = 1; i <= N; i++){
            parent[i] = i;
        }

        Collections.sort(lines);

        int sum = 0;
        int big = 0;
        for(Line line: lines){
            int start = line.start;
            int end = line.end;
            int weight = line.weight;

            if(find(start) != find(end)){
                union(start, end);
                sum += weight;
                big = weight;
            }
        }

        System.out.println(sum - big);
    }

    static int find(int x){
        if(parent[x] == x) return x;

        return parent[x] = find(parent[x]);
    }

    static void union(int x, int y){
        x = find(x);
        y = find(y);

        if(x != y){
            parent[y] = x;
        }
    }
}