import java.util.*;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        List<Integer> lottolist = new ArrayList<>();
        List<Integer> lottolist2 = new ArrayList<>();
        List<Integer> winnumlist = new ArrayList<>();
       
        int cntzro = 0;
        
        for(int i = 0; i < 6; i++){
            lottolist.add(lottos[i]);
            lottolist2.add(lottos[i]);
            winnumlist.add(win_nums[i]);
        }
        
        lottolist2.retainAll(winnumlist);
        int same = lottolist2.size();
        
        for(int i = 0; i < lottos.length; i++){
            if(lottos[i] == 0){
                cntzro++;
            }
        }
        
        System.out.println("cntzro : "+cntzro);
        System.out.println("same : "+same);
        
        int max = same+cntzro;
        int min = 6-same;
        
        
            if(max == 6){
                answer[0] = 1;
            }else if(max == 5){
                answer[0] = 2;
            }else if(max == 4){
                answer[0] = 3;
            }else if(max == 3){
                answer[0] = 4;
            }else if(max == 2){
                answer[0] = 5;
            }else{
                answer[0] = 6;
            }
            
        System.out.println("min : "+min);
        
        if(min >= 5){
            answer[1] = 6;
        }else if(min == 4){
            answer[1] = 5;
        }else if(min == 3){
            answer[1] = 4; 
        }else if(min == 2){
            answer[1] = 3;
        }else if(min == 1){
            answer[1] = 2;
        }else{
            answer[1] = 1;
        }
        
        return answer;
    }
}