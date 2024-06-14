import java.util.*;
import java.io.*;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int N, M;

    static class Node{
        int x, y;
        Node(int x, int y){
            this.x = x;
            this.y = y;
        }

        double getDistance(Node n){
            return Math.sqrt(Math.pow(this.x - n.x, 2) + Math.pow(this.y - n.y, 2));
        }
    }

    public static void main(String[] args) throws IOException{
        N = Integer.parseInt(br.readLine());
        
        Node[] nodes = new Node[N];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            nodes[i] = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        double[][] dist = new double[N][N];
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(i == j || dist[i][j] != 0) continue;
                double tmp = nodes[i].getDistance(nodes[j]);
                dist[i][j] = tmp;
                dist[j][i] = tmp;
            }
        }
        double min = Double.MAX_VALUE;
        for(int i = 0; i < N; i++){
            double tmp = 0;
            for(int j = 0; j < N; j++){
                tmp += dist[i][j];
            }
            tmp /= N-1;
            min = Math.min(min, tmp);
        }

        System.out.println(min);
    }
}