import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        String[] str = new String[N];
        for(int i = 0; i < N; i++){
            str[i] = br.readLine();
        }

        HashMap<String, Integer> map = new HashMap<>();
        int idx = 0;
        for(String s : str) {
            idx++;
            map.put(s, idx);
        }

        for(int i = 0; i < str.length; i++){
            for(int j = 0; j < str[i].length(); j++){
                if(map.containsKey(str[i].substring(0, j))){
                    map.remove(str[i].substring(0, j));
                }
            }
        }
        System.out.print(map.size());
    }
}
