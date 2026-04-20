import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    // static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N, M, K;

    static final int aks = 10000;
    static char DSLR[] = new char[]{ 'D', 'S', 'L', 'R' };
    static int D(int b){
        return (b * 2) % aks;
    }
    static int S(int b){
        if(b == 0) return 9999;
        return b - 1;
    }
    static int L(int b){
        b = b * 10;
        if(b >= aks){
            b = (b % aks) + (b / aks);
        }
        return b;
    }
    static int R(int b){
        return b = (b / 10) + ((b % 10) * 1000);
    }
    static int func(int b, int i){
        if(i == 0){
            return D(b);
        } else if(i == 1){
            return S(b);
        } else if(i == 2){
            return L(b);
        } else{
            return R(b);
        }
    }

    static String BFS(int a, int b){
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[aks];
        String[] dslr = new String[aks];

        q.add(a);
        visited[a] = true;
        Arrays.fill(dslr, "");
        while(!q.isEmpty() && !visited[b]){
            int now = q.poll();

            for(int i = 0; i < 4; i++){
                int tmp = func(now, i);

                if(!visited[tmp]){
                    q.add(tmp);
                    visited[tmp] = true;
                    dslr[tmp] = dslr[now] + i;
                }
            }
        }
        return dslr[b];
    }
    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());

        while(N-- > 0){
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            String ans = BFS(start, end);

            for(int i = 0; i < ans.length(); i++){
                char c = ans.charAt(i);

                if(c == '0') sb.append('D');
                if(c == '1') sb.append('S');
                if(c == '2') sb.append('L');
                if(c == '3') sb.append('R');
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }

}