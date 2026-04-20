import java.util.*;
import java.io.*;

public class Main{
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int N, M;

    public static void main(String[] args) throws IOException{
        N = Integer.parseInt(br.readLine());

        while(N-- > 0){
            int n = Integer.parseInt(br.readLine());

            st = new StringTokenizer(br.readLine());
            
            int m = n > 32 ? 33 : n;
            String[] mbti = new String[n];
            for(int i = 0; i < m; i++) mbti[i] = st.nextToken();

            int minDistance = 12;

outerLoop : for(int i = 0; i < m; ++i){
                for(int j = i + 1; j < m; ++j){
                    for(int k = j + 1; k < m; ++k){
                        minDistance = Math.min(minDistance, calcDistance(mbti[i], mbti[j], mbti[k]));
                        if(minDistance == 0){
                            break outerLoop;
                        }
                    }
                }
            }

            sb.append(minDistance).append('\n');
        }

        System.out.println(sb);
    }

    static int calcDistance(String p1, String p2, String p3) {
        int distance = 0;
        for (int i = 0; i < 4; ++i) {
            distance += (p1.charAt(i) != p2.charAt(i) ? 1 : 0);
            distance += (p2.charAt(i) != p3.charAt(i) ? 1 : 0);
            distance += (p3.charAt(i) != p1.charAt(i) ? 1 : 0);
        }
        return distance;
    }
}