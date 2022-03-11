import java.util.Scanner;
import java.util.*;

class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] P = new int[N];
        int[] time = new int[N];
        int index = 1;
        int answer = 0;
        
        //각 사람의 돈 인출하는데 걸리는 시간
        for(int i = 0; i < N; i++){
            P[i] = sc.nextInt();
        }
        
        Arrays.sort(P);
        time[0] = P[0];
        while(index < N){
            for(int i = 1; i < N; i++){
                time[index] = time[index-1] + P[index];   
                index++;
            }
        }
        for(int i = 0; i < N; i++){
            answer += time[i];
        }
        
        System.out.println(answer);
    }
}