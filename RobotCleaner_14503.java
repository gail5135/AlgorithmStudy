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
        queue.add(new int[]{startY, startX});
        check[startY][startX] = true;

        for(int i = 0; i < lengthX; ++i){
            for(int j = 0; j < lengthY; ++j){
                if(map[i][j] == 0 && !check[i][j]){
                    check[i][j] = true;
                    bfs();
                }
            }
        }


    }

    public static void bfs(){
        while(!queue.isEmpty()){
            int[] temp = queue.poll();

            for(int a = lookingPosition; a < lookingPosition+4; ++a){

            }
        }
    }
}

