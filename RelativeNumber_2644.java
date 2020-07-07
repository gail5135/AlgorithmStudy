import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class RelativeNumber_2644 {
    public static int people;
    public static int start, end;
    public static int count;
    public static int map[][];
    public static boolean check[][];
    public static Queue<Integer> queue;
    public static int[] ans;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        people = Integer.parseInt(br.readLine());
        ans = new int[people];

        String[] s = br.readLine().split(" ");

        start = Integer.parseInt(s[0])-1;
        end = Integer.parseInt(s[1])-1;

        count = Integer.parseInt(br.readLine());
        map = new int[people][people];
        check = new boolean[people][people];

        for(int a = 0; a < count; ++a){
            s = br.readLine().split(" ");
            map[Integer.parseInt(s[0])-1][Integer.parseInt(s[1])-1] = 1;
            map[Integer.parseInt(s[1])-1][Integer.parseInt(s[0])-1] = 1;
        }

        queue = new LinkedList<>();
        queue.add(start);

        while(!queue.isEmpty()){
            int temp = queue.poll();

            if(temp == end){
                break;
            }

            for(int i = 0; i < people; ++i){
                if(map[temp][i] == 1 && !check[temp][i]){
                    queue.add(i);
                    check[temp][i] = true;
                    ans[i] = ans[temp]+1;
                }
            }
        }

        if(ans[end] == 0){
            System.out.println(-1);
        }
        else{
            System.out.println(ans[end]);
        }

    }
}
