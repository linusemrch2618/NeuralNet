import java.util.*;

class Neuron {
    Random random = new Random();
    private Double oldBias = random.nextDouble(-1, 1), bias = random.nextDouble(-1, 1);
    private Double oldWeight1 = random.nextDouble(-1, 1), weight1 = random.nextDouble(-1, 1);

    public double compute(double input1){
        double preActivation =  (this.weight1 * input1) +
                                this.bias;
        double output = Util.sigmoid(preActivation);
        return output;
    }
    public void mutate(){
        int propertyToChange = random.nextInt(0, 1);
        Double changeFactor = random.nextDouble(-1, 1);
        if (propertyToChange == 0){
            this.bias += changeFactor;
        } else (propertyToChange == 1){
            this.weight1 += changeFactor;
        }
    }
    public void forget(){
        bias = oldBias;
        weight1 = oldWeight1;
    }
    public void remember(){
        oldBias = bias;
        oldWeight1 = weight1;
    }

}