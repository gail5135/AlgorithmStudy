import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class OrganicCabbage_1012 {
    public static int num;
    public static int lengthX;
    public static int lengthY;
    public static int[] dx = {0, 1, 0, -1};
    public static int[] dy = {-1, 0, 1, 0};
    public static int[][] map;
    public static boolean[][] check;
    public static Queue<int[]> q;
    public static int[] ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        num = Integer.parseInt(br.readLine()); // 테스트 케이스 갯수
        ans = new int[num];

        // 테스트 케이스 갯수 별로 실행
        for(int a = 0; a < num; ++a){
            String[] s1 = br.readLine().split(" ");
            lengthX = Integer.parseInt(s1[0]); // 배추밭 가로 길이
            lengthY = Integer.parseInt(s1[1]); // 배추밭 세로 길이
            int s2 = Integer.parseInt(s1[2]); // 배추가 심어져 있는 위치
            map = new int[lengthY][lengthX]; // 배추밭 맵
            int temp = 0;

            // 배추밭에 0,1 채워넣기
            for(int b = 0; b < s2; ++b){
                s1 = br.readLine().split(" ");
                int x = Integer.parseInt(s1[0]); // 심어져 있는 배추의 위치
                int y = Integer.parseInt(s1[1]); // 심어져 있는 배추의 위치

                for(int i = 0; i < lengthY; ++i){
                    for(int j = 0; j < lengthX; ++j){
                        if(y == i && x == j){
                            map[i][j] = 1;
                        }
                    }
                }
            }

            // 큐와 체크맵 생성
            q = new LinkedList<>();
            check = new boolean[lengthY][lengthX];

            for(int i = 0; i < lengthY; ++i){
                for(int j = 0; j < lengthX; ++j){
                    if(map[i][j] == 1 && !check[i][j]){
                        q.add(new int[]{i, j});
                        check[i][j] = true;
                        temp += bfs();
                    }
                }
            }

            ans[a] = temp;
        }

        for (int temp: ans){
            System.out.println(temp);
        }
    }

    private static int bfs() {
        while(!q.isEmpty()){
            int[] temp = q.poll();

            for(int i =0; i < 4; ++i){
                // 인덱스 값이 범위보다 크거나 작은지 확인
                if(temp[0]+dy[i] >= lengthY || temp[0]+dy[i] < 0 || temp[1]+dx[i] >= lengthX || temp[1]+dx[i] < 0){
                    continue;
                }

                // 이미 방문한 지역인지 아닌지 확인
                if(check[temp[0]+dy[i]][temp[1]+dx[i]] || map[temp[0]+dy[i]][temp[1]+dx[i]] == 0){
                    continue;
                }

                q.add(new int[]{temp[0]+dy[i], temp[1]+dx[i]});
                check[temp[0]+dy[i]][temp[1]+dx[i]] = true;
            }
        }

        return 1;
    }
}
