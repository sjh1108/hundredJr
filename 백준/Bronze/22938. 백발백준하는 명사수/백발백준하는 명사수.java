import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int x1 = sc.nextInt();
		int y1 = sc.nextInt();
		int r1 = sc.nextInt();
		

		int x2 = sc.nextInt();
		int y2 = sc.nextInt();
		int r2 = sc.nextInt();
		
		if(Math.sqrt((Math.pow(x1-x2, 2) + Math.pow(y1-y2, 2))) < r1+r2) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}
		
		sc.close();
	}
}
