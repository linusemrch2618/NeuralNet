public class Main {
    public static void main(String[] args) {
        Neuron.setRangeWeight(-1,1);

        Network net = new Network(CreateLayer(), CreateTrainingData());

        System.out.println("============");
        System.out.println("Output before training");
        System.out.println("============");
        for(int i = 0; i < net.getTDataSet().length; i++) {
            net.forward(net.getTDataSet()[i].data);
            System.out.println(net.getLayers()[2].neurons[0].value);
        }

        net.train(1000000, 0.1f);

        System.out.println("============");
        System.out.println("Output after training");
        System.out.println("============");
        for(int i = 0; i < net.getTDataSet().length; i++) {
            net.forward(net.getTDataSet()[i].data);
            System.out.println(net.getLayers()[2].neurons[0].value);
        }
        net.forward(new float[] {0.9F, 0.8F, 0.700F, 0.6F, 0.6F, 0.3500F});
        System.out.println(net.getLayers()[2].neurons[0].value);
    }

    static Layer[]  CreateLayer() {
        Layer[] layers = new Layer[3];
        layers[0] = null; // Input Layer 0,2
        layers[1] = new Layer(6,4); // Hidden Layer 6, 4
        layers[2] = new Layer(4,1); // Output Layer 4, 1

        return layers;
    }
    static TrainingData[] CreateTrainingData() {
        float[] input1 = new float[] {0.4F, 0.7F, 0.600F, 0.5F, 0.5F, 0.2500F}; //Expect 0 here
        float[] input2 = new float[] {0.2F, 0.6F, 0.550F, 0.3F, 0.2F, 0.2000F}; //Expect 1 here
        float[] input3 = new float[] {0.2F, 0.5F, 0.550F, 0.2F, 0.2F, 0.2000F}; //Expect 1 here
        float[] input4 = new float[] {0.1F, 0.5F, 0.500F, 0.1F, 0.1F, 0.1800F}; //Expect 0 here
        float[] input5 = new float[] {0.6F, 0.5F, 0.550F, 0.1F, 0.1F, 0.3240F}; //Expect 0 here

        float[] expectedOutput1 = new float[] {0.450F};
        float[] expectedOutput2 = new float[] {0.200F};
        float[] expectedOutput3 = new float[] {0.150F};
        float[] expectedOutput4 = new float[] {0.050F};
        float[] expectedOutput5 = new float[] {0.145F};

        TrainingData[] tDataSet = new TrainingData[5];
        tDataSet[0] = new TrainingData(input1, expectedOutput1);
        tDataSet[1] = new TrainingData(input2, expectedOutput2);
        tDataSet[2] = new TrainingData(input3, expectedOutput3);
        tDataSet[3] = new TrainingData(input4, expectedOutput4);
        tDataSet[4] = new TrainingData(input5, expectedOutput5);

        return tDataSet;
    }
}