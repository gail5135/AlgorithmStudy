import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class RobotCleaner_14503 {
    public static int lengthX, lengthY;
    public static int startX, startY;
    public static int lookingPosition;
    public static int[] dx = {-1, 0, 1, 0, -1, 0, 1};
    public static int[] dy = {0, -1, 0, 1, 0, -1, 0};
    public static int[][] map;
    public static boolean[][] check;
    public static Queue<int[]> queue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");

        lengthY = Integer.parseInt(s[0]);
        lengthX = Integer.parseInt(s[1]);

        s = br.readLine().split(" ");

        startX = Integer.parseInt(s[0]);
        startY = Integer.parseInt(s[1]);
        lookingPosition = Integer.parseInt(s[2]);

        map = new int[lengthY][lengthX];
        check = new boolean[lengthY][lengthX];

        for(int i = 0; i < lengthY; ++i){
            s = br.readLine().split(" ");
            for(int j = 0; j < lengthX; ++j){
                map[i][j] = Integer.parseInt(s[j]);

            }
        }

        queue = new LinkedList<>();
        queue.add(new int[]{startY, startX, lookingPosition});
        check[startY][startX] = true;

        int answer = bfs();

        System.out.println(answer);
    }

    public static int bfs(){
        int ans = 1;

        while(!queue.isEmpty()){
            int[] temp = queue.poll();

            for(int a = temp[2]; a < temp[2]+4; ++a){
                if(temp[0] + dy[a] >= lengthY || temp[0] + dy[a] < 0 || temp[1] + dx[a]>= lengthX || temp[1] +dx[a] < 0 ){
                    continue;
                }
                if(check[temp[0]+dy[a]][temp[1]+dx[a]] || map[temp[0]+dy[a]][temp[1]+dx[a]] == 1){
                    continue;
                }

                if(temp[2] >= 3){
                    temp[2] = 0;
                }
                else{
                    temp[2] += 1;
                }

                queue.add(new int[]{temp[0]+dy[a], temp[1]+dx[a], temp[2]});
                check[temp[0]+dy[a]][temp[1]+dx[a]] = true;
                ans++;
            }
        }

        return ans;
    }
}

