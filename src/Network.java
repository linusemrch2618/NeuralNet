import java.util.*;

class Network {

    List<Double> answers = new ArrayList<>();
    
    List<List<Integer>> data = new ArrayList();
    
    List<Integer> Toaster1 = new ArrayList<>();

    List<Integer> Toaster2 = new ArrayList<>();
    
    List<Integer> Toaster3 = new ArrayList<>();
        
    List<Integer> Toaster4 = new ArrayList<>();

    List<Integer> Toaster5 = new ArrayList<>();
    
    List<Neuron> neurons = Arrays.asList(
            new Neuron(), new Neuron(), new Neuron(), new Neuron(), new Neuron(), new Neuron(), new Neuron(), new Neuron(), new Neuron(), new Neuron(), new Neuron(), new Neuron(), new Neuron(), new Neuron(), new Neuron(), new Neuron(), new Neuron(), new Neuron(), 
            new Neuron(), new Neuron(), new Neuron(), new Neuron(), new Neuron(), new Neuron(), 
            new Neuron(), 
    );

    public Network() {
        answers.add(450.0);
        answers.add(200.0);
        answers.add(150.0);
        answers.add(50.0);
        answers.add(145.0);

        data.add(Toaster1);
        data.add(Toaster2);
        data.add(Toaster3);
        data.add(Toaster4);
        data.add(Toaster5);

        Toaster1.add(4);
        Toaster1.add(7);
        Toaster1.add(600);
        Toaster1.add(5);
        Toaster1.add(5);
        Toaster1.add(2500);

        Toaster2.add(2);
        Toaster2.add(6);
        Toaster2.add(550);
        Toaster2.add(3);
        Toaster2.add(2);
        Toaster2.add(2000);

        Toaster3.add(2);
        Toaster3.add(5);
        Toaster3.add(550);
        Toaster3.add(2);
        Toaster3.add(2);
        Toaster3.add(2000);

        Toaster4.add(1);
        Toaster4.add(5);
        Toaster4.add(500);
        Toaster4.add(1);
        Toaster4.add(1);
        Toaster4.add(1800);

        Toaster5.add(6);
        Toaster5.add(5);
        Toaster5.add(550);
        Toaster5.add(1);
        Toaster5.add(1);
        Toaster5.add(3240);
    }

    public Double predict(Integer input1, Integer input2, Integer input3, Integer input4, Integer input5, Integer input6){
        return neurons.get(24).compute(
                neurons.get(23).comput
        );
    }
    public void train(List<List<Integer>> data, List<Double> answers){
        Double bestEpochLoss = null;
        for (int epoch = 0; epoch < 1000; epoch++){
            // adapt neuron
            Neuron epochNeuron = neurons.get(epoch % 6);
            epochNeuron.mutate(this.learnFactor);

            List<Double> predictions = new ArrayList<Double>();
            for (int i = 0; i < data.size(); i++){
                predictions.add(i, this.predict(data.get(i).get(0), data.get(i).get(1), data.get(i).get(2), data.get(i).get(3), data.get(i).get(4), data.get(i).get(5)));
            }
            Double thisEpochLoss = Util.meanSquareLoss(answers, predictions);

            if (bestEpochLoss == null){
                bestEpochLoss = thisEpochLoss;
                epochNeuron.remember();
            } else {
                if (thisEpochLoss < bestEpochLoss){
                    bestEpochLoss = thisEpochLoss;
                    epochNeuron.remember();
                } else {
                    epochNeuron.forget();
                }
            }
        }
    }
}
