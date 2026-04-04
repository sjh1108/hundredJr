import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        String[] handle = new String[N];
        for(int i=0; i<N; i++){
            handle[i]=br.readLine();
        }

        
        Arrays.sort(handle);
        System.out.println(handle[K-1]);
    }

    public static String solution(String[] handle, int k){
        return handle[k-1];
    }
}