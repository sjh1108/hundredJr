import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        long[] arr = new long[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(arr);

        long[] result = {1000000000, 1000000000, 1000000000};
        long min = result[0] + result[1] + result[2];
        for(int i = 0; i < N-2; i++){
            long start = arr[i];

            int left = i+1, right = N-1;
            while(left < right){
                long l = arr[left];
                long r = arr[right];
                long sum = start + l + r;

                if(Math.abs(sum) < Math.abs(min)){
                    result[0] = start;
                    result[1] = l;
                    result[2] = r;

                    min = 0;
                    for(long t: result){
                        min += t;
                    }
                }

                if(sum > 0){
                    right -= 1;
                }
                else if(sum < 0){
                    left += 1;
                } else{
                    break;
                }
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for(long l : result){
            sb.append(l).append(' ');
        }

        System.out.println(sb);
    }
}