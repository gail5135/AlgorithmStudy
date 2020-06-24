import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class HideAndSeek_1697 {
    public static int me;
    public static int brother;
    public static int[] position = {-1, 1, 2};
    public static Queue<Integer> q;
    public static ArrayList<Integer> ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");

        me = Integer.parseInt(s[0]);
        brother = Integer.parseInt(s[1]);
        ans = new ArrayList<>();
        q = new LinkedList();

        q.add(5);

        while(!q.isEmpty()){
            int temp = q.poll();

            if(temp - 1 < 0){
                continue;
            }
            else{
                q.add(temp-1);
            }
            if(temp + 1 > brother){
                continue;
            }
            else{
                q.add(temp+1);
            }
            if(temp*2 > brother){
                continue;
            }
            else{
                q.add(temp*2);
            }

            if(temp == brother){
                ans.add(temp);
            }
        }

        Collections.sort(ans);

        System.out.println(ans.get(0));
    }
}
