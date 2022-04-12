import java.io.BufferedReader;
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> q = new PriorityQueue<>((o1, o2) -> {
          int first_abs = Math.abs(o1);
          int second_abs = Math.abs(o2);

          if(first_abs == second_abs){
              return o1 > o2 ? 1 : -1;
          }else{
              return first_abs - second_abs;
          }
        });

        for(int i = 1; i <= N; i++){
            int num = Integer.parseInt(br.readLine());
            if(num != 0) {
                q.add(num);
            }else{
                if(q.isEmpty()) {
                    System.out.println(0);
                }else{
                    System.out.println(q.remove());
                }
            }
        }
    }
}
