import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Tomato_7576 {
    private static int xLength;
    private static int yLength;
    private static int[] dx = {-1, 0, 1, 0};
    private static int[] dy = {0, 1, 0, -1};
    private static int[][] map;
    private static Queue<int[]> tomato;
    private static boolean[][] check;
    private static int answer;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");

        xLength = Integer.parseInt(s[0]);
        yLength = Integer.parseInt(s[1]);
        answer = 0;

        map = new int[yLength][xLength];
        tomato = new LinkedList<>();
        check = new boolean[yLength][xLength];

        for(int i = 0; i < yLength; ++i){
            s = br.readLine().split(" ");

            for(int j = 0; j < xLength; ++j){
                map[i][j] = Integer.parseInt(s[j]);

                if(map[i][j] == 1){
                    tomato.add(new int[]{i, j, 0});
                    check[i][j] = true;
                }
            }
        }

        int zeroCount = 0;

        for(int i = 0; i < yLength; ++i){
            for(int j = 0; j < xLength; ++j){
                if(map[i][j] == 0){
                    zeroCount++;
                }
            }
        }

        if(zeroCount == 0){
            System.out.println(0);
            return;
        }

        while(!tomato.isEmpty()){
            int[] temp = tomato.poll();

            for(int a = 0; a < 4; ++a){
                int moveX = temp[1] + dx[a];
                int moveY = temp[0] + dy[a];

                if(moveX >= xLength || moveX < 0 || moveY >= yLength || moveY < 0 || check[moveY][moveX] || map[moveY][moveX] == -1){
                    continue;
                }

                tomato.add(new int[]{moveY, moveX, temp[2]+1});
                map[moveY][moveX] = 1;
                check[moveY][moveX] = true;

                if(temp[2]+1 > answer){
                    answer = temp[2]+1;
                }
            }
        }

        zeroCount = 0;

        for(int i = 0; i < yLength; ++i){
            for(int j = 0; j < xLength; ++j){
                if(map[i][j] == 0){
                    zeroCount++;
                }
            }
        }

        if(zeroCount == 0){
            System.out.println(answer);
        }
        else{
            System.out.println(-1);
        }
    }
}
