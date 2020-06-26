import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class MoveKnight_7562 {
    public static int length;
    public static int[] knight = new int[2];
    public static int[] target = new int[2];
    public static int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2};
    public static int[] dy = {1, 2, 2, 1, -1, -2, -2, -1};
    public static Queue<int[]> q;
    public static boolean[][] check;
    public static int ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());

        for(int i = 0; i < num; ++i){
            length = Integer.parseInt(br.readLine());

            q = new LinkedList<>();
            check = new boolean[length][length];

            String[] s = br.readLine().split(" ");
            knight[0] = Integer.parseInt(s[0]);
            knight[1] = Integer.parseInt(s[1]);

            s = br.readLine().split(" ");
            target[0] = Integer.parseInt(s[0]);
            target[1] = Integer.parseInt(s[1]);

            ans = 0;
            q.add(new int[]{knight[0], knight[1], 0});
            check[knight[0]][knight[1]] = true;
            System.out.println(bfs());
        }
    }

    public static int bfs(){
        int[] temp = new int[]{0,0,0};

        while(!q.isEmpty()){
            temp = q.poll();

            if(temp[0] == target[0] && temp[1] == target[1]){
                break;
            }

            for(int a = 0; a < 8; ++a){
                if(temp[0]+dy[a] >= length || temp[0]+dy[a] < 0 || temp[1]+dx[a] >= length || temp[1]+dx[a] < 0){
                    continue;
                }
                if(check[temp[0]+dy[a]][temp[1]+dx[a]]){
                    continue;
                }

                q.add(new int[]{temp[0]+dy[a], temp[1]+dx[a], temp[2]+1});
                check[temp[0]+dy[a]][temp[1]+dx[a]] = true;
            }
        }

        return temp[2];
    }
}
