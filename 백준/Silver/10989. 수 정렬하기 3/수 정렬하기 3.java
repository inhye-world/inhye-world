import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(st.nextToken());
        }

        radixSort(arr, 5);

        for(int i = 0; i < N; i++){
            bw.write(arr[i] + "\n");
        }
        bw.flush();
        bw.close();
    }

    public static void radixSort(int[] arr, int maxcnt){
        int[] output = new int[arr.length];
        int jarisu = 1;
        int cnt = 0;

        while(cnt != maxcnt){
            int[] bucket = new int[10];
            for(int i = 0; i < arr.length; i++){
                bucket[(arr[i]/jarisu)%10]++;
            }
            for(int i = 1; i < 10; i++){
                bucket[i]+=bucket[i-1];
            }
            for(int i = arr.length-1; i >= 0; i--){
                output[bucket[(arr[i]/jarisu%10)]-1] = arr[i];
                bucket[(arr[i]/jarisu)%10]--;
            }
            for(int i = 0; i < arr.length; i++){
                arr[i] = output[i];
            }
            jarisu = jarisu*10;
            cnt++;
        }
    }
}
