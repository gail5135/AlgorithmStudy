import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class HideAndSeek_1697 {
    public static int me;
    public static int brother;
    public static int[] check;
    public static Queue<Integer> q;
    public static ArrayList<Integer> ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");

        me = Integer.parseInt(s[0]);
        brother = Integer.parseInt(s[1]);
        check = new int[100001];
        Arrays.fill(check, 0);
        q = new LinkedList();

        q.add(me);
        check[me] = 1;

        while(!q.isEmpty()){
            int temp = q.poll();

            if(temp == brother){
                System.out.println(check[temp]-1);
                return;
            }

            if(temp + 1 < 100001 && check[temp+1] == 0){
                q.add(temp+1);
                check[temp+1] = check[temp] + 1;
            }

            if(temp - 1 >= 0 && check[temp-1] == 0){
                q.add(temp-1);
                check[temp-1] = check[temp] + 1;
            }

            if(temp*2 < 100001 && check[temp*2] == 0){
                q.add(temp*2);
                check[temp*2] = check[temp] + 1;
            }
        }
    }
}
