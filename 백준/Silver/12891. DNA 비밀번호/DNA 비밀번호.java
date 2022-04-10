import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static Map<Character, Integer> map;
    static int answer;
    static String strs;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int S = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        answer = 0;

        strs = br.readLine();

        map = new HashMap<>();
        st = new StringTokenizer(br.readLine());
        map.put('A' , -Integer.parseInt(st.nextToken()));
        map.put('C' , -Integer.parseInt(st.nextToken()));
        map.put('G' , -Integer.parseInt(st.nextToken()));
        map.put('T' , -Integer.parseInt(st.nextToken()));
        add(0, P);

        int start_idx = 0;
        int end_idx = P;

        while(true){
            check();
            if(end_idx >= S){
                break;
            }
            remove(start_idx, start_idx+1);
            add(end_idx, end_idx+1);
            start_idx++;
            end_idx++;
        }

        System.out.println(answer);
    }

    private static void check(){
        for(Integer v : map.values()){
            if(v < 0){
                return;
            }
        }
        answer++;
    }

    private static void remove(int start, int end){
        for(int i = start; i < end; i++){
            map.put(strs.charAt(i), map.get(strs.charAt(i)) - 1);
        }
    }

    private static void add(int start, int end){
        for(int i = start; i < end; i++){
            map.put(strs.charAt(i), map.get(strs.charAt(i)) + 1);
        }
    }
}