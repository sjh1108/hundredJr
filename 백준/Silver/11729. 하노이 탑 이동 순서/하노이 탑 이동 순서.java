//import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException{

        int N = Integer.parseInt(br.readLine());

        sb.append((int) (Math.pow(2, N) - 1)).append('\n');

        Hanoi(N, 1, 2, 3);

        System.out.println(sb);
    }
    /**
     * @param N     옮기는 블럭 수
     * @param start 시작 위치
     * @param mid   중간 위치
     * @param to    도착 위치
     */
    static void Hanoi(int N, int start, int mid, int to){
        if(N == 1){
            sb.append(start + " " + to + "\n");
            return;
        }

        Hanoi(N - 1, start, to, mid);

        sb.append(start + " " + to + "\n");

        Hanoi(N - 1, mid, start, to);
    }


}