import java.util.*;
import java.io.*;

public class Main{
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static StringBuilder sb = new StringBuilder();
  static StringTokenizer st;

  static int N, M;

  public static void main(String[] args) throws IOException{
    String s = br.readLine();
    int[] alpha = new int[26];
    for(int i = 0; i < s.length(); i++){
      alpha[s.charAt(i) - 'a']++;
    }

    for(int i = 0; i < 26; i++){
      sb.append(alpha[i] + " ");
    }
    System.out.println(sb);
  }
}