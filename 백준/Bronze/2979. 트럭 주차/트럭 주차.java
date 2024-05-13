import java.util.*;
import java.io.*;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int N, M;

    public static void main(String[] args) throws IOException{
		st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());

		int[] arr = new int[103];
		for(int i = 0; i < 3; i++){
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			for(int j = s; j < e; j++){
				arr[j]++;
			}
		}

		int sum = 0;
		for(int i = 0; i < 103; i++){
			if(arr[i] == 1){
				sum += a;
			}else if(arr[i] == 2){
				sum += b * 2;
			}else if(arr[i] == 3){
				sum += c * 3;
			}
		}
		System.out.println(sum);
	}
}