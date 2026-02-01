import java.io.*;
import java.util.*;

class Main {

    private static long[] num, tree;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        num = new long[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) num[i] = Integer.parseInt(st.nextToken());
        
        makeTree(N);

        StringBuilder sb = new StringBuilder();
        while(Q-- > 0){
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;

            if(x > y){
                int tmp = x;
                x = y;
                y = tmp;
            }

            long sum = getSum(0, N-1, 1, x, y);
            sb.append(sum + "\n");

            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken());

            long dif = b - num[a];
            update(0, N-1, 1, a, dif);
            num[a] = b;
        }

        System.out.println(sb);
    }

    private static void makeTree(int N){
        int h = (int)Math.ceil(Math.log(N) / Math.log(2));

        int treeSize = (int)Math.pow(2, h+1);

        tree = new long[treeSize];

        init(0, N-1, 1);
    }

    private static long init(int s, int e, int node){
        if(s==e){
            return tree[node] = num[s];
        }

        int mid = (s+e) / 2;

        return tree[node] = init(s, mid, node*2) + init(mid+1, e, node*2 + 1);
    }

    private static void update(int s, int e, int node, int idx, long dif){
        if(s <= idx && idx <= e) tree[node] += dif;
        else return;

        if(s == e) return;

        int mid = (s+e) / 2;
        update(s, mid, node*2, idx, dif);
        update(mid+1, e, node*2 + 1, idx, dif);
    }

    private static long getSum(int s, int e, int node, int l, int r){
		if(e < l || r < s) return 0;
		if(l <= s && e <= r) {
			return tree[node];
		}
		
		int mid = (s+e)/2;
		return getSum(s, mid, node*2, l, r)+ getSum(mid+1, e, node*2+1, l, r);
    }
}