import java.io.*;
import java.util.*;
 
public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int[] a = new int[100001];
        int[] b = new int[100001];
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();
        for(int i=0;i<s1.length();i++) {
            a[i] = s1.charAt(i)-'0';
            b[i] = s2.charAt(i)-'0';
        }
        StringBuilder sb = new StringBuilder();
        // A&B
        for(int i=0;i<s1.length();i++)
            sb.append(a[i]&b[i]);
        sb.append("\n");
        // A|B
        for(int i=0;i<s1.length();i++)
            sb.append(a[i]|b[i]);
        sb.append("\n");
        // A^B
        for(int i=0;i<s1.length();i++)
            sb.append(a[i]^b[i]);
        sb.append("\n");
        // ~A
        for(int i=0;i<s1.length();i++)
            sb.append(a[i]^1);
        sb.append("\n");
        // ~B
        for(int i=0;i<s1.length();i++)
            sb.append(b[i]^1);
        sb.append("\n");
        System.out.println(sb);
    }
}
