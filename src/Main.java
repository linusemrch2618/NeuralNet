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

        net.train(1000000, 0.05f);

        System.out.println("============");
        System.out.println("Output after training");
        System.out.println("============");
        for(int i = 0; i < net.getTDataSet().length; i++) {
            net.forward(net.getTDataSet()[i].data);
            System.out.println(net.getLayers()[2].neurons[0].value);
        }
    }

    static Layer[]  CreateLayer() {
        Layer[] layers = new Layer[3];
        layers[0] = null; // Input Layer 0,2
        layers[1] = new Layer(6,12); // Hidden Layer 2,6
        layers[2] = new Layer(12,1); // Output Layer 6,1

        return layers;
    }
    static TrainingData[] CreateTrainingData() {
        float[] input1 = new float[] {4, 7, 600, 5, 5, 2500}; //Expect 0 here
        float[] input2 = new float[] {2, 6, 550, 3, 2, 2000}; //Expect 1 here
        float[] input3 = new float[] {2, 5, 550, 2, 2, 2000}; //Expect 1 here
        float[] input4 = new float[] {1, 5, 500, 1, 1, 1800}; //Expect 0 here
        float[] input5 = new float[] {6, 5, 550, 1, 1, 3240}; //Expect 0 here

        float[] expectedOutput1 = new float[] {450};
        float[] expectedOutput2 = new float[] {200};
        float[] expectedOutput3 = new float[] {150};
        float[] expectedOutput4 = new float[] {50};
        float[] expectedOutput5 = new float[] {145};

        TrainingData[] tDataSet = new TrainingData[5];
        tDataSet[0] = new TrainingData(input1, expectedOutput1);
        tDataSet[1] = new TrainingData(input2, expectedOutput2);
        tDataSet[2] = new TrainingData(input3, expectedOutput3);
        tDataSet[3] = new TrainingData(input4, expectedOutput4);
        tDataSet[4] = new TrainingData(input5, expectedOutput5);

        return tDataSet;
    }
}