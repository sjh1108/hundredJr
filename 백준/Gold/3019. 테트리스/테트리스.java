import java.io.*;
import java.util.*;

public class Main{
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    static int N, M, K;

    static int[] arr;
    static int[] [][] blocks = {
        {},

        // |
        {
            { 0 },
            { 0, 0, 0, 0 }
        },

        // o
        {
            { 0, 0 }
        },

        // reverse z
        {
            { 0, 0, 1},
            { 0, -1}
        },

        // z
        {
            { 0, -1, -1 },
            { 0, 1 }
        },

        // fokyu
        {
            { 0, 0, 0 },
            { 0, 1 },
            { 0, -1, 0 },
            { 0, -1 }
        },

        // L
        {
            { 0, 0 },
            { 0, 1, 1 },
            { 0, -2 },
            { 0, 0, 0 }
        },

        // reverse L
        {
            { 0, 0 },
            { 0, 0, -1},
            { 0, 2 },
            { 0, 0, 0}
        },

    };

    public static void main(String[] args) throws IOException{

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int count = 0;
        int[][] block = blocks[M];
        for(int i = 0; i < N; i++){
            int len = arr[i];

            for(int j = 0; j < block.length; j++){
                boolean flag = true;

                for(int k = 0; k < block[j].length; k++){
                    if(i + k >= N) {
                        flag = false;
                        break;
                    }
                    int height = arr[i + k];

                    if(height - block[j][k] != len) flag = false;
                }

                if(flag) count++;
            }
        }

        System.out.println(count);
    }
}