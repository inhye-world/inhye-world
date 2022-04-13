import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        int[] arr = new int[str.length()];

        for (int i = 0; i < str.length(); i++) {
            arr[i] = Integer.parseInt(str.substring(i, i+1));
        }

        for(int i = 0; i < str.length(); i++) {
            //1.떨어져있는거랑 비교
            int max = i;
            for (int j = i+1; j < str.length(); j++) {
                if(arr[j] > arr[max]){
                    max = j;
                }
            }

            //2.인접한거랑 비교
            if(arr[i] < arr[max]){
                int temp = arr[i];
                arr[i] = arr[max];
                arr[max] = temp;
            }
        }

        for(int i = 0; i < str.length(); i++){
            System.out.print(arr[i]);
        }
    }
}
