import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        mData[] arr = new mData[N];

        for (int i = 0; i < N; i++) {
            //입력 시의 원래 idx(뒤죽박죽)
            arr[i] = new mData(Integer.parseInt(br.readLine()), i);
        }

        Arrays.sort(arr);

        int max = 0;
        for (int i = 0; i < N; i++) {
            if (max < arr[i].idx - i) {
                max = arr[i].idx - i;
            }
        }
        System.out.println(max + 1);
    }
}
class mData implements Comparable<mData>{
    int val;
    int idx;

    public mData(int val, int idx){
        this.val = val;
        this.idx = idx;
    }

    @Override
    public int compareTo(mData o) {
        //value 기준 정렬후 idx
        return this.val - o.val;
    }
}

