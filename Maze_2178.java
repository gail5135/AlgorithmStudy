import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Maze_2178 {
    public static int lengthX;
    public static int lengthY;
    public static int[] dx = {0, 1, 0, -1};
    public static int[] dy = {-1, 0, 1, 0};
    public static int[][] map;
    public static boolean[][] check;
    public static Queue<int[]> q;
    public static int ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 맵의 크기 입력
        String[] s = br.readLine().split(" ");
        lengthX = Integer.parseInt(s[1]);
        lengthY = Integer.parseInt(s[0]);

        // 맵 생성과 방문 체크용 맵 생성
        map = new int[lengthY][lengthX];
        check = new boolean[lengthY][lengthX];

        // 맵에 값 입력
        for(int i = 0; i < lengthY; ++i) {
            s = br.readLine().split("");
            for(int j = 0; j < lengthX; ++j){
                map[i][j] = Integer.parseInt(s[j]);
            }
        }

        // BFS에 사용할 큐 생성
        q = new LinkedList<>();

        // 시작점은 방문이므로 true
        check[0][0] = true;

        // 큐에 시작점 추가
        q.add(new int[]{0, 0});


        // BFS 시작
        while(!q.isEmpty()){
            int[] temp = q.poll();

            for(int a = 0; a < 4; ++a) {
                // 인덱스값 초과했는지 확인
                if(temp[0]+dy[a] >= lengthY || temp[0]+dy[a] < 0 || temp[1]+dx[a] >= lengthX || temp[1]+dx[a] < 0){
                    continue;
                }

                // 현재 맵의 값이 0인지, 아니면 방문한 곳인지 확인
                if(map[temp[0]+dy[a]][temp[1]+dx[a]] == 0 || check[temp[0]+dy[a]][temp[1]+dx[a]]){
                    continue;
                }

                q.add(new int[]{temp[0]+dy[a], temp[1]+dx[a]});
                map[temp[0]+dy[a]][temp[1]+dx[a]] = map[temp[0]][temp[1]]+1;
                check[temp[0]+dy[a]][temp[1]+dx[a]] = true;

            }
        }

        System.out.println(map[lengthY-1][lengthX-1]);
    }
}
