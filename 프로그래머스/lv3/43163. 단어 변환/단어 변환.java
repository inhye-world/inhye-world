import java.util.*;

class Solution {
    static boolean[] visit;
    static int answer = 0;
    
    public int solution(String begin, String target, String[] words) {
        visit = new boolean[words.length];
        
        dfs(begin, 0, target, words);
        
        return answer;
    }
    
    public static void dfs(String str, int steps, String target, String[] words){
        if(str.equals(target)){
            answer = steps;
            return;
        }
        
        
        for(int i = 0; i < words.length; i++){
            if(visit[i]){
                continue;
            }
            
            
            int cnt = 0;
            for(int j = 0; j < str.length(); j++){
                if(str.charAt(j) == words[i].charAt(j)){
                    cnt++;
                }

                if(cnt == str.length()-1){
                    visit[i] = true;
                    dfs(words[i], steps+1, target, words);
                    visit[i] = false;
                }
            }
        }
    }
}