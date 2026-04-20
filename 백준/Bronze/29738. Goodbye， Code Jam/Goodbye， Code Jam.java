import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		for(int i = 1; i <= N; i++) {
			int n = sc.nextInt();
			
			System.out.print("Case #" + i + ": ");
			if(n > 4500) {
				System.out.println("Round 1");
			}else if(n > 1000) {
				System.out.println("Round 2");
			}else if(n > 25) {
				System.out.println("Round 3");
			}else {
				System.out.println("World Finals");
			}
		}
		sc.close();
	}
}