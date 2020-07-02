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
    public static int[] dx = {0, 1, 0, -1}; // 북, 동, 남, 서
    public static int[] dy = {-1, 0, 1, 0}; // 북, 동, 남, 서
    public static int[][] map;
    public static Queue<int[]> queue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");

        lengthY = Integer.parseInt(s[0]);
        lengthX = Integer.parseInt(s[1]);

        s = br.readLine().split(" ");

        startY = Integer.parseInt(s[0]);
        startX = Integer.parseInt(s[1]);
        lookingPosition = Integer.parseInt(s[2]);

        map = new int[lengthY][lengthX];

        for(int i = 0; i < lengthY; ++i){
            s = br.readLine().split(" ");
            for(int j = 0; j < lengthX; ++j){
                map[i][j] = Integer.parseInt(s[j]);

            }
        }

        queue = new LinkedList<>();
        queue.add(new int[]{startY, startX, lookingPosition});
        map[startY][startX] = 2;

        int answer = bfs();

        System.out.println(answer);
    }

    public static int bfs(){
        int ans = 1;

        while(!queue.isEmpty()){
            int[] temp = queue.poll();

            int nextD = turnDirection(temp[2]);
            boolean flag = true;

            for(int a = 0; a < 4; ++a) {
                if (temp[0] + dy[nextD] < 0 || temp[0] + dy[nextD] >= lengthY || temp[1] + dx[nextD] < 0 || temp[1] + dx[nextD] >= lengthX) {
                    nextD = turnDirection(nextD);
                    continue;
                }

                if (map[temp[0] + dy[nextD]][temp[1] + dx[nextD]] != 0) {
                    nextD = turnDirection(nextD);
                    continue;
                }

                if (map[temp[0] + dy[nextD]][temp[1] + dx[nextD]] == 2 || map[temp[0] + dy[nextD]][temp[1] + dx[nextD]] == 1) {
                    nextD = turnDirection(nextD);
                    continue;
                }

                if (map[temp[0] + dy[nextD]][temp[1] + dx[nextD]] == 0) {
                    queue.add(new int[]{temp[0] + dy[nextD], temp[1] + dx[nextD], nextD});
                    map[temp[0] + dy[nextD]][temp[1] + dx[nextD]] = 2;
                    flag = false;
                    ans++;
                    break;
                }
            }

            if(flag){
                int yy = temp[0] + dy[backDirection(temp[2])];
                int xx = temp[1] + dx[backDirection(temp[2])];

                if(map[yy][xx] != 1){
                    queue.add(new int[]{yy, xx, temp[2]});
                }
            }
        }

        return ans;
    }

    public static int turnDirection(int d) {
        // 0 북, 1 동, 2 남, 3 서
        if (d == 0) {
            return 3;
        } else if (d == 1) {
            return 0;
        } else if (d == 2) {
            return 1;
        } else {
            return 2;
        }
    }

    public static int backDirection(int d) {
        // 0 북, 1 동, 2 남, 3 서
        if (d == 0) {
            return 2;
        } else if (d == 1) {
            return 3;
        } else if (d == 2) {
            return 0;
        } else {
            return 1;
        }
    }
}

