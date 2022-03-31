import java.util.*;

class Solution {
    public class Job{
        int reqTime;
        int runTime;
        
        public Job(int req, int run){
            this.reqTime = req;
            this.runTime = run;
        }
    
    }
    public int solution(int[][] jobs) {
        //대기열 -> '작업이 요청되는 시점'이 빠른 순으로 정렬
        int answer = 0;
        PriorityQueue<Job> q = new PriorityQueue(new Comparator<Job>(){
            @Override
            public int compare(Job j1, Job j2){
                return j1.reqTime-j2.reqTime;
            }
        });
        
        for(int[] job : jobs){
            q.offer(new Job(job[0] , job[1]));
        }
        
        PriorityQueue<Job> pq = new PriorityQueue(new Comparator<Job>(){
            @Override
            public int compare(Job j1, Job j2){
                return j1.runTime-j2.runTime;
            }
        });
        
        int cnt = 0;
        int sum = 0;
        int time = 0;
        
        while(cnt < jobs.length){
            while(!q.isEmpty() && time >= q.peek().reqTime){
                pq.offer(q.poll());
            }
            
            if(!pq.isEmpty()){
                Job j = pq.poll();
                sum += j.runTime + (time - j.reqTime);
                time += j.runTime;
                cnt++;
            }else{
                time++;
            }
        }
        
        answer = sum/cnt;
        return answer;
    }
}