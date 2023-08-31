import java.util.*;
import java.io.*;

public class Main{
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, M;

    static class Point{
        int x, y;
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException{
        double min = Double.MAX_VALUE;
        double max = Double.MIN_VALUE;

        Point[] points = new Point[3];
        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < 3; i++)
            points[i] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

        if((points[1].y - points[0].y)*(points[2].x - points[1].x) == (points[1].x - points[0].x)*(points[2].y - points[1].y)){
            System.out.println(-1);
            return;
        }

        double[] len = new double[3];
        double one = Math.sqrt(Math.pow(points[1].y - points[0].y, 2) + Math.pow(points[1].x - points[0].x, 2));
        double two = Math.sqrt(Math.pow(points[2].y - points[1].y, 2) + Math.pow(points[2].x - points[1].x, 2));
        double three = Math.sqrt(Math.pow(points[2].y - points[0].y, 2) + Math.pow(points[2].x - points[0].x, 2));
            
        len[0] = one + two;
        len[1] = two + three;
        len[2] = three + one;

        for(int i = 0; i < 3; i++){
            min = Math.min(min, len[i]);
            max = Math.max(max, len[i]);
        }

        System.out.println(max*2 - min*2);
    }

}