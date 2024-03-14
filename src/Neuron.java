import java.util.*;

class Neuron {
    Random random = new Random();
    private Double bias = random.nextDouble(-1, 1);
    public Double weight1 = random.nextDouble(-1, 1);
    private Double weight2 = random.nextDouble(-1, 1);

    public double compute(double input1, double input2){
        double preActivation = (this.weight1 * input1) + (this.weight2 * input2) + this.bias;
        double output = Util.sigmoid(preActivation);
        return output;
    }
}