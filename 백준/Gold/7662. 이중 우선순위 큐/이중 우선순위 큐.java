import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, M, K;
    static int[] arr;

    public static void main(String[] args) throws IOException{
        int T = Integer.parseInt(br.readLine());


        while(T-- > 0){
            N = Integer.parseInt(br.readLine());

            TreeMap<Integer,Integer> tmap = new TreeMap<>();
            while(N-- > 0){
                st = new StringTokenizer(br.readLine());

                if(st.nextToken().equals("I")){
                    int n = Integer.parseInt(st.nextToken());
                    tmap.put(n, tmap.getOrDefault(n, 0) + 1);
                } 
                else{
                    if(tmap.isEmpty()){
                        continue;
                    } 
                    else{
                        if(Integer.parseInt(st.nextToken()) < 0){
                            int min = tmap.firstKey();
                            if(tmap.get(min) == 1) {
                                tmap.remove(min);
                            }else {
                                tmap.put(min, tmap.get(min) - 1);
                            }
                        }
                        else{
                            int max = tmap.lastKey();
                            if(tmap.get(max) == 1) {
                                tmap.remove(max);
                            }else {
                                tmap.put(max, tmap.get(max) - 1);
                            }
                        }
                    }
                }
            }

            if(!tmap.isEmpty()){
                sb.append(tmap.lastKey());
                sb.append(' ');
                sb.append(tmap.firstKey());
            } else{
                sb.append("EMPTY");
            }

            sb.append('\n');
        }

        System.out.println(sb);
    }
}