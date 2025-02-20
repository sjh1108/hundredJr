import java.util.ArrayList;

class Solution {
    public String[] solution(String my_str, int n) {
        ArrayList<String> list = new ArrayList<>();
        
        int size = my_str.length() / n;
        for(int i = 0; i < size; i++){
            list.add(my_str.substring(0, n));
            my_str = my_str.substring(n);
        }
        if(!my_str.equals("")){
            list.add(my_str);
        }
        
        int i = 0;
        String[] answer = new String[list.size()];
        for(String str: list){
            answer[i++] = str;
        }
        
        return answer;
    }
}