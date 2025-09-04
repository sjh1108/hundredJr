import java.util.*;

class Main{
    public static void main(String[] args) {
        int N = new Scanner(System.in).nextInt() + (2400 - 2013);

        char c = (char)('A' + ((N+5)%12));
        int d = (N+9)%10;

        System.out.println(c+""+d);
    }
}