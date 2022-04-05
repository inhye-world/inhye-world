import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] nums = new String[3];
        nums = br.readLine().split(" ");


        int A = Integer.parseInt(nums[0]);
        int B = Integer.parseInt(nums[1]);
        int C = Integer.parseInt(nums[2]);

        if(B >= C){
            System.out.println("-1");
        }else {
            System.out.println((A / (C - B)) + 1);
        }
    }
}
