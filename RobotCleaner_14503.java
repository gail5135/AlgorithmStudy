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
    public static int[] back_dx = {0, -1, 0, 1}; // 북, 동, 남, 서
    public static int[] back_dy = {1, 0, -1, 0}; // 북, 동, 남, 서
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
            int xx = 0;
            int yy = 0;

            for(int a = 0; a < 4; ++a) {
                if (temp[0] + dy[nextD] < 0 || temp[nextD] + dy[a] >= lengthY || temp[1] + dx[a] < 0 || temp[1] + dx[a] >= lengthX) {
                    continue;
                }

                if (map[temp[0] + dy[a]][temp[1] + dx[a]] == 2 || map[temp[0] + dy[a]][temp[1] + dx[a]] == 1) {
                    temp[2] = (temp[2] + 3) % 4;
                    continue;
                }

                if (map[temp[0] + dy[a]][temp[1] + dx[a]] == 0) {
                    queue.add(new int[]{temp[0] + dy[a], temp[1] + dx[a], (temp[2] + 1) % 4});
                    map[temp[0] + dy[a]][temp[1] + dx[a]] = 2;
                    ans++;
                    break;
                }
            }

            xx = temp[1]+back_dx[temp[2]];
            yy = temp[0]+back_dy[temp[2]];

            if(map[yy][xx] != 1){
                queue.add(new int[]{yy, xx, temp[2]});
            }


//            for(int a = temp[2]; a < temp[2]+4; ++a){
//                if(temp[0] + dy[a] >= lengthY || temp[0] + dy[a] < 0 || temp[1] + dx[a]>= lengthX || temp[1] +dx[a] < 0 ){
//                    continue;
//                }
//                if(check[temp[0]+dy[a]][temp[1]+dx[a]] || map[temp[0]+dy[a]][temp[1]+dx[a]] == 1){
//                    continue;
//                }
//
//                if(temp[2] >= 3){
//                    temp[2] = 0;
//                }
//                else{
//                    temp[2] += 1;
//                }
//
//                queue.add(new int[]{temp[0]+dy[a], temp[1]+dx[a], temp[2]});
//                check[temp[0]+dy[a]][temp[1]+dx[a]] = true;
//                ans++;
//            }
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

