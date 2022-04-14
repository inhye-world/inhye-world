import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int result = 0;
        
        Arrays.sort(citations);
        
        for(int i = 0; i < citations.length; i++){
            int comp = citations.length-i;
            if(citations[i] >= comp){
                result = comp;
                break;
            }
        }
        
        return result;
    }
}