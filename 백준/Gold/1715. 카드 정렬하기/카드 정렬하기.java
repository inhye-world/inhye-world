import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        for (int i = 0; i < N; i++){
            int num = sc.nextInt();
            pq.add(num);
        }

        int sum = 0;
        int num1 = 0;
        int num2 = 0;

        while (pq.size() != 1){
            num1 = pq.remove();
            num2 = pq.remove();
            sum += num1 + num2;
            pq.add(num1+num2);
        }

        System.out.println(sum);
    }
}
