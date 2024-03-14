public class Util {
    public static double sigmoid(double in){
        return 1 / (1 + Math.exp(-in));
    }
}