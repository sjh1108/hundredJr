import java.util.*;

public class Main {

    private static int countVowels(String s) {
        int cnt = 0;

		/* ------------------- INSERT CODE HERE ---------------------*/
        for(char c: s.toCharArray()){
            if(c == 'a' || c == 'e' || c == 'o' || c == 'i' || c == 'u')
                cnt++;
        }
		/* -------------------- END OF INSERTION --------------------*/

        return cnt;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int numCases = sc.nextInt();

		for(int i = 0; i < numCases; i++)
		{
			String s = sc.next();
            System.out.println("The number of vowels in " + s + " is " + countVowels(s) + ".");
		}
		
		sc.close();
	}
}
