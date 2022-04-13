import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] sum = new int[N];
        String[] str = br.readLine().split(" ");

        for (int i = 0; i < str.length; i++) {
            arr[i] = Integer.parseInt(str[i]);
        }

        for(int i = 1; i < N; i++) {
            int insert_point = i;
            int insert_value = arr[i];
            for (int j = i - 1; j >= 0; j--) {
                if(arr[j] < arr[i]){
                    insert_point = j+1;
                    break;
                }
                if(j == 0){
                    insert_point = 0;
                }
            }
            for(int j = i; j > insert_point; j--){
                arr[j] = arr[j-1];
            }
            arr[insert_point] = insert_value;
        }

        sum[0] = arr[0];
        for(int i = 1; i < N; i++){
            sum[i] = sum[i-1] + arr[i];
        }

        int result = 0;
        for(int i = 0; i < N; i++){
            result += sum[i];
        }

        System.out.print(result);
    }
}
