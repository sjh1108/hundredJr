import java.io.*;

public class Main {
	private static int[] cnt;
	
	public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int digit = 1;
	    int start = 1;
		int num = Integer.parseInt(br.readLine());
		
		cnt = new int[10];
		
		while(start <= num) {
			while(start % 10 != 0 && start <= num) {
				counting(start, digit);
				start++;
			}
			
			while(num % 10 != 9 && start <= num) {
				counting(num, digit);
				num--;
			}
			
			if(start > num) break;
			
			start /= 10;
			num /= 10;
			
			for(int i = 0 ; i < 10 ; ++i) {
				cnt[i] += (num - start + 1) * digit;
			}
			
			digit *= 10;
		}
		
		for(int i : cnt) {
			System.out.print(i + " ");
		}
	}

	private static void counting(int num, int digit) {
		while(num > 0) {
			cnt[num % 10] += digit;
			num /= 10;
		}
	}
}