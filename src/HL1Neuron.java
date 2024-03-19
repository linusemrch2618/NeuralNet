import java.util.*;

class HL1Neuron extends Neuron {
    Random random = new Random();
    private Double oldWeight2 = random.nextDouble(-1, 1), weight2 = random.nextDouble(-1, 1);
    private Double oldWeight3 = random.nextDouble(-1, 1), weight3 = random.nextDouble(-1, 1);
    private Double oldWeight4 = random.nextDouble(-1, 1), weight4 = random.nextDouble(-1, 1);
    private Double oldWeight5 = random.nextDouble(-1, 1), weight5 = random.nextDouble(-1, 1);
    private Double oldWeight6 = random.nextDouble(-1, 1), weight6 = random.nextDouble(-1, 1);

    public HL1Neuron() {
       super();
    }

    public double compute(double input1, double input2){
        double preActivation =  (this.weight1 * input1) + 
                                (this.weight2 * input2) + 
                                (this.weight3 * input2) + 
                                (this.weight4 * input2) + 
                                (this.weight5 * input2) + 
                                (this.weight6 * input2) + 
                                this.bias;
        double output = Util.sigmoid(preActivation);
        return output;
    }
    public void mutate(){
        int propertyToChange = random.nextInt(0, 6);
        Double changeFactor = random.nextDouble(-1, 1);
        if (propertyToChange == 0){
            this.bias += changeFactor;
        } else if (propertyToChange == 1){
            this.weight1 += changeFactor;
        } else if (propertyToChange == 1){
            this.weight2 += changeFactor;
        } else if (propertyToChange == 1){
            this.weight3 += changeFactor;
        } else if (propertyToChange == 1){
            this.weight4 += changeFactor;
        } else if (propertyToChange == 1){
            this.weight5 += changeFactor;
        } else {
            this.weight6 += changeFactor;
        };
    }
    public void forget(){
        bias = oldBias;
        weight1 = oldWeight1;
        weight2 = oldWeight2;
        weight3 = oldWeight3;
        weight4 = oldWeight4;
        weight5 = oldWeight5;
        weight6 = oldWeight6;
    }
    public void remember(){
        oldBias = bias;
        oldWeight1 = weight1;
        oldWeight2 = weight2;
        oldWeight3 = weight3;
        oldWeight4 = weight4;
        oldWeight5 = weight5;
        oldWeight6 = weight6;
    }

}