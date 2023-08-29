import java.util.*;
import java.io.*;

public class Main{
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, M;
    
    static double max = 0d;
    static class Point{
        int x, y;

        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    static Point point[];
    static double calTri(Point a, Point b, Point c){
        double first = a.x * b.y + b.x * c.y + c.x * a.y;
        double second = b.x * a.y + c.x * b.y + a.x * c.y;

        return 0.5 * Math.abs(first - second);
    }
    static void BForce(){
        
        for(int i = 0; i < N - 2; i++){
            for(int j = i + 1; j < N - 1; j++){
                for(int k = j + 1; k < N; k++){
                    double temp = calTri(point[i], point[j], point[k]);
                    max = Math.max(temp, max);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException{
        N = Integer.parseInt(br.readLine());

        point = new Point[N];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            point[i] = new Point(x, y);
        }

        BForce();
        System.out.println(max);
    }

}