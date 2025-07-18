import java.util.*;
import java.io.*;

public class Main{
    private static int N, P, Q;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());
        
        sb.append("YES\n");
        StringTokenizer berryToken = new StringTokenizer(br.readLine());
        StringTokenizer grapeToken = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            int p = Integer.parseInt(berryToken.nextToken());
            int q = Integer.parseInt(grapeToken.nextToken());

            try{
                sb.append(check(p, q)).append(' ');
            } catch(Exception e){
                System.out.println("NO");
                return;
            }
        }

        System.out.println(sb);
    }

    private static int check(int p, int q) throws Exception{
        int g = p - q;
        if(g == 0) return 0;
        if(P-Q == 0 && p != q) throw new Exception();

        if(g * (P-Q) > 0) {
            throw new Exception();
        }

        int t = 0;
        while(t++ < 10000){
            p += P;
            q += Q;

            if(p == q) return t;
        }
        throw new Exception();
    }
}