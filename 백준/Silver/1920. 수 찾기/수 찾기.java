import java.util.*;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] arr = new int[N];
        for(int i = 0; i < N; i++){
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);
        int M = sc.nextInt();
        for(int i = 0; i < M; i++){
            boolean find = false;
            int target = sc.nextInt();

            int s = 0;
            int e = arr.length-1;

            while (s <= e){
                int midIdx = (s+e)/2;
                int midVal = arr[midIdx];
                if(midVal > target){
                    e = midIdx -1;
                }else if(midVal < target){
                    s = midIdx+1;
                }else{
                    find = true;
                    break;
                }
            }
            if(find){
                System.out.println("1");
            }else{
                System.out.println("0");
            }
        }

    }
}
