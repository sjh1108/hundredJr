import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N;
    static int M;
    static long K;
    
    static int[] arr;
    static int[] f;
    static boolean[] brr;
    static int[][] dp;

    public static void main(String[] args) throws IOException{
        N = Integer.parseInt(br.readLine());

        arr = new int[N];
        int ftmp = -1;
        int btmp = -1;
        int size = 0;

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();

            if(s.equals("push")){
                if(ftmp < 0) ftmp = 0;
                arr[++btmp] = Integer.parseInt(st.nextToken());
                size++;
            }

            else if(s.equals("pop")){
                if(size < 1){
                    sb.append(-1).append('\n');
                } else{
                    int tmp = arr[ftmp++];
                    size--;
                    sb.append(tmp).append('\n');

                    if(size == 0){
                        ftmp = -1;
                        btmp = -1;
                    }
                }
            }

            else if(s.equals("size")){
                sb.append(size).append('\n');
            }

            else if(s.equals("empty")){
                if(size == 0){
                    sb.append(1);
                } else{
                    sb.append(0);
                }
                sb.append('\n');
            }

            else if(s.equals("front")){
                if(size < 1){
                    sb.append(-1);
                } else{
                    sb.append(arr[ftmp]);
                }
                sb.append('\n');
            }

            else if(s.equals("back")){
                if(size < 1){
                    sb.append(-1);
                } else{
                    sb.append(arr[btmp]);
                }
                sb.append('\n');
            }
        }

        System.out.println(sb);
    }
}