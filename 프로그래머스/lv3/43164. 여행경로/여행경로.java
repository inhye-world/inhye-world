import java.util.*;

class Solution {
    static ArrayList<String> result;
    static boolean[] visited;
    
    public String[] solution(String[][] tickets) {
        String[] answer = {};
        result = new ArrayList<>();
        visited = new boolean[tickets.length];
        
        int cnt = 0;
        
        dfs("ICN", "ICN", cnt, tickets);
        
        Collections.sort(result);
        answer = result.get(0).split(" ");
        return answer;
    }
    
    public static void dfs(String cur, String nodes, int cnt, String[][] tickets){
        if(cnt == tickets.length){
            result.add(nodes);
            return;
        }
        
        for(int i = 0; i < tickets.length; i++){
            if(!visited[i] && tickets[i][0].equals(cur)){
                visited[i] = true;
                dfs(tickets[i][1], nodes + " " + tickets[i][1], cnt+1, tickets);
                visited[i] = false;
            }
        }
    }
}