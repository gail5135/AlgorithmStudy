import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Apartment_2667 {
    public static int apartmentComplex;
    public static int[][] mapApartment;
    public static int[] dx = {0, 1, 0, -1};
    public static int[] dy = {-1, 0, 1, 0};
    public static boolean[][] check;

    public static void main(String[] args) throws IOException {
        // 입력 스트림
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 첫번째 입력값 - 단지의 가로, 세로값
        String[] s = br.readLine().split("");

        // 아파트 단지 설정
        apartmentComplex = Integer.parseInt(s[0]);
        mapApartment = new int[apartmentComplex][apartmentComplex];
        check = new boolean[apartmentComplex][apartmentComplex];

        // 두번째 입력값 - 아파트 단지
        for(int i=0; i < apartmentComplex; ++i){
            s = br.readLine().split("");
            for(int j=0; j < apartmentComplex; ++j) {
                mapApartment[i][j] = Integer.parseInt(s[j]);
            }
        }

        for (int i = 0; i < apartmentComplex; ++i){

        }

    }
}
