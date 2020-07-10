import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Escape {
    public static int lengthX, lengthY;
    public static char[][] map;
    public static int[] dx = {0, 1, 0, -1};
    public static int[] dy = {-1, 0, 1, 0};
    public static boolean[][] check;
    public static Queue<int[]> queue;
    public static int ans = 0;
    public static boolean flag = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s1 = br.readLine().split(" ");

        lengthX = Integer.parseInt(s1[1]);
        lengthY = Integer.parseInt(s1[0]);

        map = new char[lengthY][lengthX];
        check = new boolean[lengthY][lengthX];

        for(int y = 0; y < lengthY; ++y){
            char[] c1 = br.readLine().toCharArray();
            for(int x = 0; x < lengthX ; ++x){
                map[y][x] = c1[x];
            }
        }

        queue = new LinkedList<>();

        for(int y = 0; y < lengthY; ++y){
            for(int x = 0; x < lengthX; ++x){
                if(map[y][x] == '*'){
                    queue.add(new int[]{y, x, 0}); // 물은 0
                }
            }
        }

        for(int y = 0; y < lengthY; ++y){
            for(int x = 0; x < lengthX; ++x){
                if(map[y][x] == 'S'){
                    queue.add(new int[]{y, x, 1, 0}); // 쥐는 1
                    check[y][x] = true;
                }
            }
        }

        while(!queue.isEmpty()){
            int temp[] = queue.poll();

            System.out.println(map[temp[0]][temp[1]]);

            if(temp[2] == 1 && map[temp[0]][temp[1]] == 'D'){
                flag = true;
                ans = temp[3];
                break;
            }

            if(temp[2] == 1) {
                for (int a = 0; a < 4; ++a) {
                    if (temp[0] + dy[a] >= lengthY || temp[0] + dy[a] < 0 || temp[1] + dx[a] >= lengthX || temp[1] + dx[a] < 0) {
                        continue;
                    }

                    if (map[temp[0] + dy[a]][temp[1] + dx[a]] == '.' && !check[temp[0] + dy[a]][temp[1] + dx[a]]) {
                        queue.add(new int[]{temp[0] + dy[a], temp[1] + dx[a], 1, temp[3]++});
                        check[temp[0] + dy[a]][temp[1] + dx[a]] = true;
                        continue;
                    }
                }
            }

            if(temp[2] == 0) {
                for (int a = 0; a < 4; ++a) {
                    if (temp[0] + dy[a] >= lengthY || temp[0] + dy[a] < 0 || temp[1] + dx[a] >= lengthX || temp[1] + dx[a] < 0) {
                        continue;
                    }

                    if (temp[2] == 0 && map[temp[0] + dy[a]][temp[1] + dx[a]] == '.') {
                        map[temp[0] + dy[a]][temp[1] + dx[a]] = '*';
                        queue.add(new int[]{temp[0] + dy[a], temp[1] + dx[a], 0});
                        continue;
                    }
                }
            }


        }

        if(flag){
            System.out.println(ans);
        }
        else{
            System.out.println("KAKTUS");
        }
    }
}
