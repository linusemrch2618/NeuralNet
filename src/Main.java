import java.util.*;

public class Main {
    public static void main(String[] args) {
        Network network = new Network();
        Double prediction = network.predict(115, 66);
        System.out.println("prediction: " + prediction);
    }
}