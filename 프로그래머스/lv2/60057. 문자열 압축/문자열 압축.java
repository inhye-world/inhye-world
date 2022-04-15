import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = Integer.MAX_VALUE;
        
        StringBuilder sb = new StringBuilder();
        
        //자를 문자열이 반절이상이면 반복할 수 없음
        int maxp = s.length()/2;
        
        if(s.length() == 1){
            answer  = 1;
        }
        
        for(int i = 1; i <= maxp; i++){
            String makestr = "";
            String cur = "";
            
            //문자열은 무조건 1개 이상
            int cnt = 1;
            
            for(int j = 0; j < s.length()/i; j++){
                //저장해둔 문자열과 다음 자른 문자열이 동일한지 확인
                if(cur.equals(s.substring(j*i, (j*i)+i))){
                    cnt++;
                    continue;
                }
                
                if(cnt > 1){
                    //문자열 붙임
                    makestr += cnt+cur;
                    cnt = 1;
                }else{
                    makestr += cur;
                }
                cur = s.substring(i*j, (i*j)+i);
            }
            if(cnt > 1){
                makestr += cnt+cur;
                cnt = 1;
            }else{
                makestr += cur;
            }
        
            //i로 정확히 나눠 떨어지지 않는 경우
            if(s.length() % i != 0){
                makestr += s.substring(s.length()-s.length()%i, s.length());
            }
            answer = answer > makestr.length() ? makestr.length() : answer; 
        }
        
        
        return answer;
    }
}