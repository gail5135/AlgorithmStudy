import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Escape {
    public static int lengthX, lengthY;
    public static char[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s1 = br.readLine().split(" ");

        lengthX = Integer.parseInt(s1[1]);
        lengthY = Integer.parseInt(s1[0]);

        map = new char[lengthY][lengthX];

        for(int y = 0; y < lengthY; ++y){
            char[] c1 = br.readLine().toCharArray();
            for(int x = 0; x < lengthX ; ++x){
                map[y][x] = c1[x];
            }
        }
    }
}
