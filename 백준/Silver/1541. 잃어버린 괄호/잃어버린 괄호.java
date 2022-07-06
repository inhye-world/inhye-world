import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        String[] sprByMinus = str.split("-");

        //int result = Integer.parseInt(sprByMinus[0]);
        int result = 0;
        for(int i = 0; i < sprByMinus.length; i++) {
            int temp = partSum(sprByMinus[i]);
            if (i == 0){
                result = result + temp;
            }else{
                result = result - temp;
            }
        }
        System.out.println(result);
    }

    static int partSum(String part){
        String[] sprByPlus = part.split("[+]");

        int sum = 0;
        for(int i = 0; i < sprByPlus.length; i++){
            sum += Integer.parseInt(sprByPlus[i]);
        }

        return sum;
    }
}
