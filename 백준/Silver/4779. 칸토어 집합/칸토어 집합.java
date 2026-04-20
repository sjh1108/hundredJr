import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int N, M;

    static char[] arr;

    public static void main(String[] args) throws IOException {
        String str;

        while((str = br.readLine()) != null){
            N = Integer.parseInt(str);

            M = (int) Math.pow(3, N);
            arr = new char[M];
            for(int i = 0; i < M; i++) arr[i] = '-';

            func(M, 0);

            for(int i = 0; i < M; i++) bw.write(arr[i]);
            bw.write('\n');
            bw.flush();
        }
    }

    static void func(int size, int start){
        if(size < 3) return;

        for(int i = start + size/3; i < start + (size/3) * 2; i++) arr[i] = ' ';

        func(size / 3, start);
        func(size / 3, start + (size/3) * 2);
    }
}
