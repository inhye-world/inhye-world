import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Stack<Integer> stack = new Stack<>();
        StringBuffer sb = new StringBuffer();

        int n = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(st.nextToken());
        }

        //1~n까지의 자연수를 스택에 넣는다.
        int num = 1;
        boolean result = true;
        for (int i = 0; i < arr.length; i++){
            if(arr[i] >= num) {
                while (arr[i] >= num) {
                    stack.push(num);
                    sb.append("+\n");
                    num++;
                }
                stack.pop();
                sb.append("-\n");
            }else{
                int peek = stack.pop();
                if(peek > arr[i]){
                    System.out.println("NO");
                    result = false;
                    break;
                }else{
                    sb.append("-\n");
                }
            }
        }
        if(result){
            System.out.println(sb.toString());
        }
    }
}
