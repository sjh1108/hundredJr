import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.close();
		
		for (int i=1; i<=n; i++) {
			if (i == n) {
				for (int k=1; k<=2*i-1; k++) {
					System.out.print("*");
				}
				System.out.println();
				break;
			}
			for (int j=1; j<=n-i; j++) {
				System.out.print(" ");
			}
			for (int k=1; k<=2*i-1; k++) {
				if (k == 1 || k == 2*i-1) {
					System.out.print("*");
				} else {
					System.out.print(" ");
				}
				
			}
			System.out.println();
		}

	}

}