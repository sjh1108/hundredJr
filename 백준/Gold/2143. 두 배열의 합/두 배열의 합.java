import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    // static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N, M, K;

    static int[] A, B;

    public static void main(String[] args) throws IOException {
        K = Integer.parseInt(br.readLine());

        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        for(int i = 1; i < N; i++){
            A[i] += A[i-1];
        }

        M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        B = new int[M];
        for (int i = 0; i < M; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }
        for(int i = 1; i < M; i++){
            B[i] += B[i-1];
        }

        int lenA = N*(N+1)/2;
        int lenB = M*(M+1)/2;
        long[] sumA = new long[lenA];
        long[] sumB = new long[lenB];

        int idx = 0;
        for(int i = 0; i < N; i++){
            for(int j = i; j < N; j++){
                sumA[idx++] = A[j] - (i == 0 ? 0 : A[i-1]);
            }
        }

        idx = 0;
        for(int i = 0; i < M; i++){
            for(int j = i; j < M; j++){
                sumB[idx++] = B[j] - (i == 0 ? 0 : B[i-1]);
            }
        }

        Arrays.sort(sumA);
        Arrays.sort(sumB);
        int l = 0, r = lenB-1;
        long ans = 0;
        while(l < lenA && r >= 0){
            long a = sumA[l], b = sumB[r];
            long sum = a + b;

            if(sum == K){
                long cntA = 0, cntB = 0;
                
                while(l < lenA && a == sumA[l]){
                    cntA++;
                    l++;
                }

                while(r >= 0 && b == sumB[r]){
                    cntB++;
                    r--;
                }

                ans += cntA * cntB;
            }

            else if(sum < K)
                l++;
            else
                r--;
        }

        System.out.println(ans);
    }
}