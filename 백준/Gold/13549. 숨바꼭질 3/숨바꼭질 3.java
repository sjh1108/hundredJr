import java.util.*;
import java.io.*;

public class Main{
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, M;

    static int min = Integer.MAX_VALUE;
    static boolean visited[] = new boolean[100001];
    static class Node{
        int idx, time;

        Node(int idx, int time){
            this.idx = idx;
            this.time = time;
        }
    }
    static void BFS(){
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(N, 0));

        while(!q.isEmpty()){
            Node cur = q.poll();
            visited[cur.idx] = true;
            if(cur.idx == M) min = Math.min(min, cur.time);

            if(cur.idx * 2 <= 100000 && visited[cur.idx * 2] == false) q.add(new Node(cur.idx * 2, cur.time));
            if(cur.idx + 1 <= 100000 && visited[cur.idx + 1] == false) q.add(new Node(cur.idx + 1, cur.time+1));
            if(cur.idx - 1 >= 0 && visited[cur.idx - 1] == false) q.add(new Node(cur.idx - 1, cur.time+1));
        }
    }
    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visited = new boolean[100001];
        BFS();

        System.out.println(min);
    }

}