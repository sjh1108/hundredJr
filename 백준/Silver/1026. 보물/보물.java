import java.util.*;
import java.io.*;

public class Main{
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, M;

    public static void main(String[] args) throws IOException{
        N = Integer.parseInt(br.readLine());
        int[] a = new int[N], b = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) a[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(a);
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) b[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(b);

        int sum = 0;
        for(int i = 0; i < N; i++){
            sum += a[i] * b[N - i - 1];
        }

        System.out.println(sum);
    }

}