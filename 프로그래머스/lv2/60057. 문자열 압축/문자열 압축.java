import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = Integer.MAX_VALUE;
        
        //반절 이하여야만 반복하니까
        int part = s.length()/2;
        
        String temp;
        String make;
        int cnt = 0;
        
        if(s.length() == 1){
            return 1;
        }
        
        for(int i = 1; i <= part; i++){
            temp = "";
            make = "";
            cnt = 1;
            for(int j = 0; j < s.length()/i; j++){
                if(temp.equals(s.substring(i*j, (i*j)+i))){
                    cnt++;
                    continue;
                }
                
                if(cnt > 1){
                    make += cnt + temp;
                    
                }else{
                    make += temp;
                }
                
                cnt = 1;
                temp = s.substring(i*j, (i*j)+i);
            }
            
            if(cnt > 1){
                make += cnt + temp;
            }else{
                make += temp;
            }
            
            if(s.length()%i != 0){
                make += s.substring(s.length()-s.length()%i, s.length());
            }
            
            answer = answer > make.length() ? make.length() : answer;
        }
        
        return answer;
    }
}