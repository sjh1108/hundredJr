import java.util.*;
import java.io.*;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int N, M;

    public static void main(String[] args) throws IOException{
		int sum = 0;
		int min = 100;
		for(int i = 0; i < 7; i++){
			int num = Integer.parseInt(br.readLine());
			if(num % 2 == 1){
				sum += num;
				min = Math.min(min, num);
			}
		}
		if(sum == 0)
			System.out.println(-1);
		else
			System.out.println(sum + "\n" + min);
	}
}