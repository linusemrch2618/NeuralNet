import java.util.*;

public class Main {
    public static void main(String[] args) {
        Network network = new Network();
        Double prediction = network.predict(110, 66, 1, 1, 1, 1);
        System.out.println("prediction: " + prediction);
    }
}