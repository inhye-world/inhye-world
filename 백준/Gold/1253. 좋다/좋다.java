import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        //Ai가 1,000,000,000니까 O(nlogn)
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        long arrg[] = new long[N];
        int cnt = 0;

        String[] str = br.readLine().split(" ");
        for(int i = 0; i < N; i++){
            arrg[i] = Integer.parseInt(str[i]);
        }

        Arrays.sort(arrg);

        //1. 목표 수 K를 설정
        //2. 2개의 수를 더해준다
        //3. 2에서 K보다 작으면 start_idx를 하나 키우고 크면 end_idx를 하나 줄인다.
        //4. 동일한 경우 -> start_idx | end_idx 가 K가 아닐때 cnt++; break;
        //              -> start_idx | end_idx 가 K일 때 다음 질의로 이동하기 위해 idx를 옮겨준다.
        //                 start-idx가 K일 때 start_idx를 늘린다.
        //                 end-idx가 K일 때 end_idx를 줄인다.
        //5. K가 N이 될 때까지 반복한다.
        for(int i = 0; i < N; i++){
            long K = arrg[i];
            int start_idx = 0;
            int end_idx = N-1;

            while(start_idx < end_idx){
                if(arrg[start_idx] + arrg[end_idx] == K){
                    //start_idx | end_idx 가 K가 아닐때
                    if(start_idx != i && end_idx != i){
                        cnt++;
                        break;
                    }else if(start_idx == i){
                        start_idx++;
                    }else {
                        end_idx--;
                    }
                }else if(arrg[start_idx] + arrg[end_idx] < K){
                    start_idx++;
                }else{
                    end_idx--;
                }
            }
        }
        System.out.print(cnt);
    }
}
