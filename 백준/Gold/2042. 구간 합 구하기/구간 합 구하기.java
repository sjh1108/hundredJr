import java.io.*;
import java.util.*;

class Main {
    private static int N, M, K;

    private static long[] arr, tree;

    private static long init(int start, int end, int node){
        if(start == end) return tree[node] = arr[start];

        int mid = (start + end) / 2;

        return tree[node] = init(start, mid, node * 2) + init(mid+1, end, node*2 + 1);
    }

    private static long sum(int start, int end, int node, int left, int right){
        if(left > end || right < start) return 0;

        if(left <= start && end <= right){
            return tree[node];
        }

        int mid = (start + end) / 2;
        return sum(start, mid, node * 2, left, right) + sum(mid+1, end, node*2 + 1, left, right);
    }

    private static void update(int start, int end, int node, int idx, long dif){
        if(idx < start || idx > end) return;

        tree[node] += dif;
        if(start == end) return;

        int mid = (start + end) / 2;

        update(start, mid, node*2, idx, dif);
        update(mid+1, end, node*2+1, idx, dif);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new long[N+1];

        int tmp = (int)Math.ceil(Math.log(N) / Math.log(2)) + 1;
        int size = (int)(Math.pow(2, tmp));
        tree = new long[size];

        for(int i = 1; i <= N; i++){
            arr[i] = Long.parseLong(br.readLine());
        }

        init(1, N, 1);

        StringBuilder sb = new StringBuilder();
        while(M > 0 || K > 0){
            st = new StringTokenizer(br.readLine());

            int cmd = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            long b = Long.parseLong(st.nextToken());

            if(cmd == 1){
                M--;

                long dif = b - arr[a];
                arr[a] = b;

                update(1, N, 1, a, dif);
            } else{
                K--;
                sb.append(sum(1, N, 1, a, (int) b) + "\n");
            }
        }

        System.out.print(sb);
    }
}