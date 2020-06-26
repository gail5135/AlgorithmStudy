import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class GetArea_2583 {
    public static int lengthX;
    public static int lengthY;
    public static int[] dx = {0, 1, 0, -1};
    public static int[] dy = {-1, 0, 1, 0};
    public static int[][] map;
    public static boolean[][] check;
    public static int[] squareX;
    public static int[] squareY;
    public static Queue<int[]> q;
    public static ArrayList<Integer> ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");
        lengthY = Integer.parseInt(s[0]);
        lengthX = Integer.parseInt(s[1]);
        int num = Integer.parseInt(s[2]);

        map = new int[lengthY][lengthX];
        check = new boolean[lengthY][lengthX];
        squareX = new int[2];
        squareY = new int[2];
        q = new LinkedList();

        for(int i = 0; i < num; ++i){
            s = br.readLine().split(" ");

            squareX[0] = Integer.parseInt(s[0]);
            squareY[0] = Integer.parseInt(s[1]);
            squareX[1] = Integer.parseInt(s[2])-1;
            squareY[1] = Integer.parseInt(s[3])-1;

            for(int k = squareY[1]; k >= squareY[0]; --k){
                for(int l = squareX[1]; l >= squareX[0]; --l){
                    map[k][l] = 1;
                }
            }
        }

        ans = new ArrayList<>();

        for(int i = 0; i < lengthY; ++i){
            for(int j = 0; j < lengthX; ++j){
                if(map[i][j] == 0 && !check[i][j]){
                    q.add(new int[]{i, j});
                    check[i][j] = true;
                    ans.add(bfs());
                }
            }
        }

        Collections.sort(ans);

        System.out.println(ans.size());
        if(ans.size() != 0){
            for (int a = 0; a < ans.size(); ++a) {
                if(a != ans.size()-1) {
                    System.out.print(ans.get(a)+" ");
                }
                else{
                    System.out.print(ans.get(a));
                }
            }
        }
    }

    public static int bfs(){
        int ans = 1;

        while(!q.isEmpty()){
            int[] temp = q.poll();

            for(int a = 0; a < 4; ++a){
                if(temp[0]+dy[a] >= lengthY || temp[0]+dy[a] < 0 || temp[1]+dx[a] >= lengthX || temp[1]+dx[a] < 0){
                    continue;
                }
                if(map[temp[0]+dy[a]][temp[1]+dx[a]] == 1 || check[temp[0]+dy[a]][temp[1]+dx[a]]){
                    continue;
                }

                q.add(new int[]{temp[0]+dy[a], temp[1]+dx[a]});
                check[temp[0]+dy[a]][temp[1]+dx[a]] = true;
                ans++;
            }
        }

        return ans;
    }
}
