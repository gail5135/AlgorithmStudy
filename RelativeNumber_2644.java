import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class RelativeNumber_2644 {
    public static Person[] people;
    public static int targetA, targetB;
    public static int num;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        people = new Person[Integer.parseInt(br.readLine())];

        String[] s = br.readLine().split(" ");

        targetA = Integer.parseInt(s[0]);
        targetB = Integer.parseInt(s[1]);

        num = Integer.parseInt(br.readLine());

        for(int a = 0; a < num; ++a){

        }
    }

    public class Person{
        Integer parent;
        ArrayList<Integer> children;

        Person() {

        }

        Person(int parent, int child){
            this.parent = parent;
            this.children = new ArrayList<>();
            this.children.add(child);
        }
    }
}
