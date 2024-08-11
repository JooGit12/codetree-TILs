import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int[] customers = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int leader = Integer.parseInt(tokenizer.nextToken());
        int member = Integer.parseInt(tokenizer.nextToken());

        int admins = n;
        for(int i = 0; i < n; i++) {
            int customer = customers[i] - leader;
            if(customer > 0) {
                admins = (customer % member == 0) ? customer / member : customer / member + 1;
            }
        }
        System.out.print(admins);
        reader.close();
    }
}