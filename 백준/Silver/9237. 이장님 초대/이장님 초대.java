import java.util.*;
import java.io.*;

public class Main{
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, M;
    
    static boolean[] visited;
    static int[] parent;
    static ArrayList<ArrayList<Integer>> list = new ArrayList<>();

    public static void main(String[] args) throws IOException{
        N = Integer.parseInt(br.readLine());

        Integer[] arr = new Integer[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(arr, Collections.reverseOrder());

        int max = Integer.MIN_VALUE;
        for(int i = 0; i < N; i++){
            max = Math.max(max, arr[i] + i);
        }

        System.out.println(max + 2);
    }

}