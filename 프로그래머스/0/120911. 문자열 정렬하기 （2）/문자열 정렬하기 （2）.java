class Solution {
    public String solution(String my_string) {
        String answer = "";
        my_string = my_string.toLowerCase();
        
        int[] arr = new int[26];
        for(int i = 0; i < my_string.length(); i++){
            char c = my_string.charAt(i);
            
            arr[c - 'a']++;
        }
        
        for(int i = 0; i < 26; i++){
            if(arr[i] == 0) continue;
            
            char c = (char)(i + 'a');
            while(arr[i]-- > 0){
                answer += c;
            }
        }
        
        return answer;
    }
}