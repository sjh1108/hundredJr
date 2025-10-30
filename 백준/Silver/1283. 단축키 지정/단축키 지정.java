import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        HashSet<Character> registered = new HashSet<>();
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < N; i++){
            String option = br.readLine();
            String[] split = option.split(" ");

            int wordIdx = -1; 
            int charIdx = -1;
            boolean found = false;

            for (int j = 0; j < split.length; j++) {
                if (split[j].length() == 0) continue; 
                
                char firstChar = split[j].charAt(0);
                if (!registered.contains(firstChar)) {
                    registered.add(Character.toUpperCase(firstChar));
                    registered.add(Character.toLowerCase(firstChar));
                    
                    wordIdx = j;
                    charIdx = 0;
                    found = true;
                    break;
                }
            }

            if (!found) {
                for (int j = 0; j < split.length; j++) {
                    if (split[j].length() == 0) continue;
                    
                    for (int k = 0; k < split[j].length(); k++) {
                        char c = split[j].charAt(k);
                        if (!registered.contains(c)) {
                            registered.add(Character.toUpperCase(c));
                            registered.add(Character.toLowerCase(c));
                            
                            wordIdx = j;
                            charIdx = k;
                            found = true;
                            break;
                        }
                    }
                    if (found) break;
                }
            }

            for (int j = 0; j < split.length; j++) {
                if (j == wordIdx) {
                    String word = split[j];
                    sb.append(word.substring(0, charIdx)); 
                    sb.append('[').append(word.charAt(charIdx)).append(']'); 
                    sb.append(word.substring(charIdx + 1)); 
                } else {
                    sb.append(split[j]);
                }
                
                if (j < split.length - 1) {
                    sb.append(" ");
                }
            }
            sb.append('\n');
        }

        System.out.println(sb);
    }
}