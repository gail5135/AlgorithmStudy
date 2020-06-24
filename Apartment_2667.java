import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Apartment_2667 {
    public static int length;
    public static int[][] mapApartment;
    public static int[] dx = {0, 1, 0, -1};
    public static int[] dy = {-1, 0, 1, 0};
    public static Queue<int[]> queue;
    public static boolean[][] check;
    public static ArrayList<Integer> ans;


    public static void main(String[] args) throws IOException {
        // 입력 스트림
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 첫번째 입력값 - 단지의 가로, 세로값
        String input = br.readLine();

        // 아파트 단지 설정
        length = Integer.parseInt(input);
        mapApartment = new int[length][length];
        check = new boolean[length][length];
        queue = new LinkedList<>();
        ans = new ArrayList();

        String[] s;
        // 두번째 입력값 - 아파트 단지
        for(int i = 0; i < length; ++i){
            s = br.readLine().split("");
            for(int j=0; j < length; ++j) {
                mapApartment[i][j] = Integer.parseInt(s[j]);
            }

        }



        // 단지 하나씩 검색
        for (int i = 0; i < length; ++i){
            for(int j = 0; j < length; ++j){
                // 방문하지 않은 단지인가?
                if(!check[i][j] && mapApartment[i][j] == 1){
                    queue.add(new int[]{i, j});
                    check[i][j] = true;
                    ans.add(bfs());
                }
            }
        }

        Collections.sort(ans);

        System.out.println(ans.size());
        for (Integer answer: ans ) {
            System.out.println(answer);
        }
    }

    public static int bfs(){
        int num = 1;

        while(!queue.isEmpty()){
            int[] temp = queue.poll();

            for(int a = 0; a < 4; ++a) {
                // 인덱스값이 범위보다 크거나 작은지 확인
                if (temp[0] + dy[a] >= length || temp[0] + dy[a] < 0 || temp[1] + dx[a] >= length || temp[1] + dx[a] < 0) {
                    continue;
                }

                // 방문한 지역인지 아닌지 확인
                if (check[temp[0] + dy[a]][temp[1] + dx[a]] || mapApartment[temp[0] + dy[a]][temp[1] + dx[a]] == 0) {
                    continue;
                }

                queue.add(new int[]{temp[0]+dy[a], temp[1]+dx[a]});
                mapApartment[temp[0]+dy[a]][temp[1]+dx[a]] = 0;
                check[temp[0]+dy[a]][temp[1]+dx[a]] = true;
                num++;
            }
        }

        return num;
    }
}
