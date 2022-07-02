import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        PriorityQueue<Integer> plusPq = new PriorityQueue<Integer>(Comparator.reverseOrder());
        PriorityQueue<Integer> minusPq = new PriorityQueue<Integer>();

        int oneCnt = 0;
        int zeroCnt = 0;
        int sum = 0;

        for (int i = 0; i < N; i++){
            int input = sc.nextInt();
            if(input > 1){
                plusPq.add(input);
            }else if(input == 1){
                oneCnt++;
            }else if(input == 0){
                zeroCnt++;
            }else{
                minusPq.add(input);
            }
        }

        while(plusPq.size() > 1){
            int num1 = plusPq.remove();
            int num2 = plusPq.remove();
            sum = sum + (num1*num2);
        }

        if(!plusPq.isEmpty()){
            sum = sum + plusPq.remove();
        }

        while(minusPq.size() > 1){
            int num1 = minusPq.remove();
            int num2 = minusPq.remove();
            sum = sum + (num1*num2);
        }

        if(!minusPq.isEmpty()){
            if(zeroCnt == 0) {
                sum = sum + minusPq.remove();
            }
        }

        sum = sum + oneCnt;

        System.out.println(sum);
    }
}
