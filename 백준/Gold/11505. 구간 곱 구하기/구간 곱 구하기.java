import java.io.*;
import java.util.*;

class Main {
    private static final long MOD = 1_000_000_007;

    private static int N;
    
    private static long[] arr, tree;

    private static long mul(int start, int end, int node, int left, int right){
        if(end < left || start > right) return 1;

        if(left <= start && right >= end) return tree[node];

        int mid = (start + end) / 2;
        return (mul(start, mid, node*2, left, right) * mul(mid+1, end, node*2 + 1, left, right)) % MOD;
    }

    private static long update(int start, int end, int node, int index, long value){
        if(index < start || index > end) return tree[node];

        if(start == end) return tree[node] = value;

        int mid = (start + end) / 2;
        return tree[node] = (update(start, mid, node*2, index, value) * update(mid+1, end, node*2 + 1, index, value)) % MOD;
    }

    private static long initTree(int start, int end, int node){
        if(start == end) return tree[node] = arr[start];

        int mid = (start + end) / 2;
        return tree[node] = (initTree(start, mid, node * 2) * initTree(mid+1, end, node*2 + 1)) % MOD;
    }
    private static void init(){
		int k = (int) Math.ceil(Math.log(N) / Math.log(2)) + 1;
		int size = (int) Math.pow(2, k);
		
		tree = new long[size];

        initTree(1, N, 1);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        arr = new long[N+1];
        for(int i = 1; i <= N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        init();

        StringBuilder sb = new StringBuilder();
        while(M > 0 || K > 0){
            st = new StringTokenizer(br.readLine());

            int cmd = Integer.parseInt(st.nextToken());
            if(cmd == 1){
                M--;
                int b = Integer.parseInt(st.nextToken());
                long c = Long.parseLong(st.nextToken());

                update(1, N, 1, b, c);
            } else{
                K--;
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());

                sb.append(mul(1, N, 1, b, c) + "\n");
            }
        }

        System.out.print(sb);
    }
}