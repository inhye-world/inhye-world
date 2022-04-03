import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        
        HashMap<String, Integer> map = new HashMap<>();
        
        //의상 종류는 반복할 수 있음
        int cnt = 0;
        for(int i = 0; i < clothes.length; i++){
            if(map.containsKey(clothes[i][1])){
                map.put(clothes[i][1], map.get(clothes[i][1])+1);
            }else{
                map.put(clothes[i][1], 1);
            }
        }
        
        System.out.println(map);
        
        Iterator<Integer> it = map.values().iterator();
        while(it.hasNext()){
            answer *= it.next().intValue() + 1; 
        }
        
        return answer-1;
    }
}