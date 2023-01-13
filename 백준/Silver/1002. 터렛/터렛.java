import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException{
        int n = Integer.parseInt(br.readLine());
        int[][] x = new int[n][2];
        int[][] y = new int[n][2];
        int[][] r = new int[n][2];

        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            x[i][0] = Integer.parseInt(st.nextToken());
            y[i][0] = Integer.parseInt(st.nextToken());
            r[i][0] = Integer.parseInt(st.nextToken());

            x[i][1] = Integer.parseInt(st.nextToken());
            y[i][1] = Integer.parseInt(st.nextToken());
            r[i][1] = Integer.parseInt(st.nextToken());
                

            if(x[i][0] == x[i][1] && y[i][0] == y[i][1]){
                if(r[i][0] == r[i][1]) sb.append(-1);
                else sb.append(0);
                sb.append('\n');
                continue;
            }

            double range;
            double xrange, yrange;
            xrange = Math.pow(x[i][0] - x[i][1], 2);
            yrange = Math.pow(y[i][0] - y[i][1], 2);
            range = Math.sqrt(xrange + yrange);

            double sum = r[i][0] + r[i][1];

            // 두 원의 반지름이 점 사이의 길이보다 길 경우
            if(range < r[i][0] && range < r[i][1]){
                sum = Math.min(r[i][0], r[i][1]) + range;
                if(sum < r[i][1] || sum < r[i][0]){
                    sb.append(0);
                } else if(sum == r[i][0] || sum == r[i][1]){
                    sb.append(1);
                } else{
                    sb.append(2);
                }
            } 
            // 둘 중 하나의 반지름이 길이보다 길 경우
            else if(range < r[i][0]){
                double nrange = range + r[i][1];
                if(nrange == r[i][0]){
                    sb.append(1);
                } else if(nrange > r[i][0]){
                    sb.append(2);
                } else{
                    sb.append(0);
                }
            } else if(range < r[i][1]){
                double nrange = range + r[i][0];
                if(nrange == r[i][1]){
                    sb.append(1);
                } else if(nrange > r[i][1]){
                    sb.append(2);
                } else{
                    sb.append(0);
                }
            }
            // 하나의 반지름이 점 사이의 길이와 같을 경우
            else if(range == r[i][0] || range == r[i][1]){
                sb.append(2);
            }
            // 두 반지름이 길이보다 짧을경우
            else if(range > r[i][0] && range > r[i][1]){
                if(sum == range){
                    sb.append(1);
                } else if(sum < range){
                    sb.append(0);
                } else{
                    sb.append(2);
                }
            } 


            sb.append('\n');
        }

        System.out.println(sb);
    }
}