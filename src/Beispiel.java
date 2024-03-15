import java.util.ArrayList;
import java.util.List;

public class Beispiel {
    public static void main(String[] args) {

        List<List<Integer>> data = new ArrayList();

        List<Integer> hallo = new ArrayList<>();
        hallo.add(4);
        data.add(hallo);

        List<Integer> hallo2 = new ArrayList<>();
        hallo2.add(3);
        hallo2.add(86);
        data.add(hallo2);
        System.out.println(data);
    }
}
