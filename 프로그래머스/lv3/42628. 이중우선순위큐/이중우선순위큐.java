import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        
        //내림차순 큐
        PriorityQueue<Integer> dq = new PriorityQueue<>(Collections.reverseOrder());
        
        //오름차순 큐
        PriorityQueue<Integer> aq = new PriorityQueue<>();
        
        //배열 요소 1개씩 추출
        String[] str = new String[2];
        int num = 0;
        int cal = 0;
        
        for(String s : operations){
            str = s.split(" ");
            //I일 때 숫자는 다 담아둔다
            if(str[0].equals("I")){
                num = Integer.parseInt(str[1]);
                dq.offer(num);
                aq.offer(num);
            }
            
            if(str[0].equals("D")){
                if(dq.isEmpty() || aq.isEmpty()){
                    continue;
                }
                
                cal = Integer.parseInt(str[1]);
                
                if(cal == 1){
                    int max = dq.poll();
                    aq.remove(max);
                }    
                
                if(cal == -1){
                    int min = aq.poll();
                    dq.remove(min);
                }
            }
        }
        
        //System.out.println(dq);
        //System.out.println(aq);
        
        if(dq.isEmpty()&&aq.isEmpty()){
            answer[0] = 0;
            answer[1] = 0;
        }else{
            answer[0] = dq.peek();
            answer[1] = aq.peek();
        }
        
        return answer;
    }
}