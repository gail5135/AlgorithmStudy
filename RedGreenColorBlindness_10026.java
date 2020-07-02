import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class RedGreenColorBlindness_10026 {
    public static char[][] normal_map;
    public static char[][] blind_map;
    public static int length;
    public static int[] dx = {1, 0, -1, 0};
    public static int[] dy = {0, 1, 0, -1};
    public static Queue<int[]> queue;
    public static boolean[][] check;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        length = Integer.parseInt(br.readLine());

        normal_map = new char[length][length];
        blind_map = new char[length][length];


        for(int i = 0; i < length; ++i){
            char[] s = br.readLine().toCharArray();
            for(int j = 0; j < length; ++j){
                normal_map[i][j] = s[j];

                if(s[j] == 'G'){
                    blind_map[i][j] = 'R';
                }
                else{
                    blind_map[i][j] = s[j];
                }
            }
        }

        int answer1 = 0;
        int answer2 = 0;

        queue = new LinkedList<>();
        check = new boolean[length][length];
        for(int i = 0; i < length; ++i){
            for(int j = 0; j < length; ++j){
                if(!check[i][j]){
                    queue.add(new int[]{i, j});
                    check[i][j] = true;
                    bfs(normal_map, normal_map[i][j]);
                    answer1++;
                }
            }
        }

        queue = new LinkedList<>();
        check = new boolean[length][length];
        for(int i = 0; i < length; ++i){
            for(int j = 0; j < length; ++j){
                if(!check[i][j]){
                    queue.add(new int[]{i, j});
                    check[i][j] = true;
                    bfs(blind_map, blind_map[i][j]);
                    answer2++;
                }
            }
        }

        System.out.println(answer1 + " " + answer2);
    }

    public static void bfs(char[][] map, char color){
        while(!queue.isEmpty()){
            int[] temp = queue.poll();

            for(int a = 0; a < 4; ++a){
                // 인덱스 범위 초과 체크
                if(temp[0] + dy[a] < 0 || temp[0] + dy[a] >= length || temp[1] +dx[a] < 0 || temp[1] + dx[a]>= length){
                    continue;
                }

                // 방문의 유무와 인자의 글자인지 체크
                if(check[temp[0]+dy[a]][temp[1]+dx[a]] || map[temp[0]+dy[a]][temp[1]+dx[a]] != color){
                    continue;
                }

                if(!check[temp[0]+dy[a]][temp[1]+dx[a]] && map[temp[0]+dy[a]][temp[1]+dx[a]] == color){
                    queue.add(new int[]{temp[0]+dy[a], temp[1]+dx[a]});
                    check[temp[0]+dy[a]][temp[1]+dx[a]] = true;
                }

            }
        }
    }
}
