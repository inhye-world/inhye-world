import java.io.*;
import java.util.*;

public class Main{
    static long result;
    static int[] arr;
    static int[] temp;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        arr = new int[N+1];
        temp = new int[N+1];
        result = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        mergeSort(1, N);

        System.out.print(result);
    }

    public static void mergeSort(int s, int e){
        if(e-s < 1){
            return;
        }

        int m = s + (e - s)/2;
        mergeSort(s, m);
        mergeSort(m+1, e);

        for(int i = s; i <= e; i++){
            temp[i] = arr[i];
        }

        int k = s;
        int idx1 = s;
        int idx2 = m+1;

        while(idx1 <= m && idx2 <= e){
            if(temp[idx1] > temp[idx2]){
                arr[k] = temp[idx2];
                result = result + idx2 - k;
                k++;
                idx2++;
            }else{
                arr[k] = temp[idx1];
                k++;
                idx1++;
            }
        }

        while(idx1 <= m){
            arr[k] = temp[idx1];
            k++;
            idx1++;
        }

        while(idx2 <= e){
            arr[k] = temp[idx2];
            k++;
            idx2++;
        }
    }
}

