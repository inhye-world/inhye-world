import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        HashMap<String, Integer> map = new HashMap<>();
        
        Arrays.sort(phone_book);
        
        int idx = 0;
        for(String s : phone_book){
            //문자열을 맵에 전부 넣는다
            idx++;
            map.put(s, idx);
        }
        
        //문자열을 하나씩 돌면서 맵의 key에 포함되는지 확인
        for(int i = 0; i < phone_book.length; i++){
            for(int j = 0; j < phone_book[i].length(); j++){
                if(map.containsKey(phone_book[i].substring(0, j))){
                    return false;
                }
            }
        }
        
        return answer;
    }
}