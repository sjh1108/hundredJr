import java.util.*;
import java.io.*;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int N, M;

    public static void main(String[] args) throws IOException{

        N = Integer.parseInt(br.readLine());
        String[] arr = new String[N];
        for(int i=0; i<N; i++){
            arr[i] = br.readLine();
        }

        Arrays.sort(arr, new Comparator<String>(){
            public int compare(String s1, String s2){
                return Integer.compare(s2.length(), s1.length());
            }
        });

        HashSet<String> set = new HashSet<>();
        for(String s1 : arr){
            if(set.size() == 0){
                set.add(s1);
                continue;
            }

            boolean flag = true;
            for(String s2 : set){
                if(s2.indexOf(s1) == 0){
                    flag = false;
                    break;
                }
            }
            if(flag){
                set.add(s1);
            }
        }

        System.out.println(set.size());
    }
}