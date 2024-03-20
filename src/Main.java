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
        layers[1] = new Layer(3,4); // Hidden Layer 2,6
        layers[2] = new Layer(4,1); // Hidden Layer 2,6

        return layers;
    }
    static TrainingData[] CreateTrainingData() {
        float[] input1 = new float[] {0, 0, 1}; //Expect 0 here
        float[] input2 = new float[] {0, 1, 0}; //Expect 1 here
        float[] input3 = new float[] {1, 0, 1}; //Expect 1 here
        float[] input4 = new float[] {1, 1, 0}; //Expect 0 here

        float[] expectedOutput1 = new float[] {0};
        float[] expectedOutput2 = new float[] {1};
        float[] expectedOutput3 = new float[] {1};
        float[] expectedOutput4 = new float[] {0};

        TrainingData[] tDataSet = new TrainingData[4];
        tDataSet[0] = new TrainingData(input1, expectedOutput1);
        tDataSet[1] = new TrainingData(input2, expectedOutput2);
        tDataSet[2] = new TrainingData(input3, expectedOutput3);
        tDataSet[3] = new TrainingData(input4, expectedOutput4);

        return tDataSet;
    }
}