    import java.util.*;
    import java.io.*;

    public class Main{
        static StringBuilder sb = new StringBuilder();
        static StringTokenizer st;
        static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        static int N, M;

        public static void main(String[] args) throws IOException{
            N = Integer.parseInt(br.readLine());

            String[] arr = new String[N];
            for(int i = 0; i < N; i++){
                arr[i] = br.readLine();
            }

            int len = arr[0].length();
            for(int i = 0; i < len; i++){
                boolean flag = true;
                char c = arr[0].charAt(i);
                for(int j = 1; j < N; j++){
                    if(c != arr[j].charAt(i)){
                        flag = false;
                        break;
                    }
                }

                if(flag){
                    sb.append(c);
                } else{
                    sb.append("?");
                }
            }

            System.out.println(sb);
        }
    }