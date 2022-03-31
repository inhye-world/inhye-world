import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int cnt = 0;
        PriorityQueue<Integer> q = new PriorityQueue<>();
        
        //배열 오름차순 정렬
        Arrays.sort(scoville);
        
        //배열을 하나씩 뽑아서 큐에 담는다.
        for(int s : scoville){
            q.add(s);
        }
        
        //배열에서 가장 맵지 않은 음식과 그다음으로 안매운 음식을 찾는다.
        while(cnt < scoville.length){
            if(!q.isEmpty()){
                if(q.peek() >= K){
                    break;
                }else if(q.peek() < K && q.size() == 1){
                    cnt = -1;
                    break;
                }

                int min = q.poll();
                int secmin = q.poll();

                //둘이 섞고 다시 큐에 넣는다.
                int mix = min+(secmin*2);

                q.add(mix);
                cnt++;
            }
        }
        return cnt;
    }
}