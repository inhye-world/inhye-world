import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = 3;

        int cntArr = Integer.parseInt(br.readLine());
        //List<Integer>[] tests = new ArrayList[cntArr+1];
        List<int[]> tests = new ArrayList<int[]>();
        int arr[] = new int[10];
        int[] answer = new int[cntArr];

        //10개 요소가 있는 배열을 만든다.
        for (int i = 0; i < cntArr; i++) {
            String[] str = br.readLine().split(" ");
            for (int j = 0; j < 10; j++) {
                arr[j] = Integer.parseInt(str[j]);
            }
            Arrays.sort(arr);
            answer[i] = arr[7];
        }
        
        for(int i = 0; i < cntArr; i++){
            System.out.println(answer[i]);
        }
    }
}

