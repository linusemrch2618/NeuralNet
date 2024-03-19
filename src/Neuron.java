import java.util.*;

class Neuron {
    private final Random random = new Random();
    private Double oldBias = random.nextDouble(-1, 1), bias = random.nextDouble(-1, 1);

    public double compute(double input1, double input2){
        double preActivation = this.bias;
        return Util.sigmoid(preActivation);
    }
    public void mutate(){
        double changeFactor = random.nextDouble(-1, 1);
        this.bias += changeFactor;
    }
    public void forget(){
        bias = oldBias;
    }
    public void remember(){
        oldBias = bias;
    }
}