import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class SafetyArea_2468 {
    public static int length;
    public static int[][] mapOrigin;
    public static int[][] mapCopy;
    public static int[] dx = {0, 1, 0, -1};
    public static int[] dy = {-1, 0, 1, 0};
    public static Queue<int[]> q;
    public static boolean[][] check;
    public static ArrayList<Integer> ans = new ArrayList<>();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        length = Integer.parseInt(br.readLine());
        mapOrigin = new int[length][length];
        mapCopy = new int[length][length];

        for(int i=0; i < length; ++i){
            String[] s = br.readLine().split(" ");
            for(int j=0; j < length; ++j){
                mapOrigin[i][j] = Integer.parseInt(s[j]);
            }
        }

        for(int i=1; i < 101; ++i){
            q = new LinkedList<>();
            check = new boolean[length][length];
            int temp = 0;
            boolean oneFlag = true;
            boolean zeroFlag = true;

            for(int j=0; j < length; ++j){
                for(int k=0; k < length; ++k){
                    if(mapOrigin[j][k] <= i){
                        mapCopy[j][k] = 0;
                        zeroFlag = false;
                    }
                    else {
                        mapCopy[j][k] = 1;
                        oneFlag = false;
                    }
                }
            }


            if(oneFlag){
                ans.add(1);
                break;
            }

            if(zeroFlag){
                ans.add(0);
            }

            for(int j=0; j < length; ++j){
                for(int k=0; k < length; ++k){
                    if(mapCopy[j][k] == 1 && !check[j][k]){
                        q.add(new int[]{j, k});
                        check[j][k] = true;
                        temp += dfs();
                    }
                }
            }

            ans.add(temp);
        }


        Collections.sort(ans);
        System.out.println(ans.get(ans.size()-1));
    }

    public static int dfs(){
        while(!q.isEmpty()){
            int[] temp = q.poll();

            for(int a = 0; a < 4; ++a){
                if(temp[0]+dy[a] >= length || temp[0]+dy[a] < 0 || temp[1]+dx[a] >= length || temp[1]+dx[a] < 0){
                    continue;
                }
                if(check[temp[0]+dy[a]][temp[1]+dx[a]] == true || mapCopy[temp[0]+dy[a]][temp[1]+dx[a]] == 0){
                    continue;
                }

                q.add(new int[]{temp[0]+dy[a], temp[1]+dx[a]});
                check[temp[0]+dy[a]][temp[1]+dx[a]] = true;
            }
        }

        return 1;
    }
}
