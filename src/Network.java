import java.util.*;

class Network {

    List<List<Integer>> data = new ArrayList();
    public List data(){
        data.add(Toaster1);
        data.add(Toaster2);
        data.add(Toaster3);
        data.add(Toaster4);
    }
    
    List<Integer> Toaster1 = new ArrayList();
    public Toaster1() {
        Toaster1.add();
        Toaster1.add();
        Toaster1.add();
        Toaster1.add();
        Toaster1.add();
        Toaster1.add();
    }

    List<Integer> Toaster2 = new ArrayList();
    public Toaster2() {
        Toaster2.add();
        Toaster2.add();
        Toaster2.add();
        Toaster2.add();
        Toaster2.add();
        Toaster2.add();
    } 
    
    List<Integer> Toaster3 = new ArrayList();
    public Toaster3(){
        Toaster3.add();
        Toaster3.add();
        Toaster3.add();
        Toaster3.add();
        Toaster3.add();
        Toaster3.add();
    }
        
    List<Integer> Toaster4 = new ArrayList();
    public Toaster4(){    
        Toaster4.add();
        Toaster4.add();
        Toaster4.add();
        Toaster4.add();
        Toaster4.add();
        Toaster4.add();
    }
    
    List<Neuron> neurons = Arrays.asList(
            new InputNeuron(), new InputNeuron(), new InputNeuron(), new InputNeuron(), new InputNeuron(), new InputNeuron(),   /* input nodes */
            new HL1Neuron(), new HL1Neuron(), new HL1Neuron(), new HL1Neuron(),                                                 /* hidden nodes */
            new HL2Neuron(), new HL2Neuron(), new HL2Neuron(),                                                                  /* hidden nodes */
            new OutputNeuron()                                                                                                  /* output node */
    );

    public Double predict(Integer input1, Integer input2, Integer input3, Integer input4, Integer input5, Integer input6){
        return neurons.get(13).compute(
            neurons.get(12).compute(
                neurons.get(9).compute(
                    neurons.get(5).compute(input6),
                    neurons.get(4).compute(input5),
                    neurons.get(3).compute(input4),
                    neurons.get(2).compute(input3),
                    neurons.get(1).compute(input2),
                    neurons.get(0).compute(input1)
                ),
                neurons.get(8).compute(
                    neurons.get(5).compute(input6),
                    neurons.get(4).compute(input5),
                    neurons.get(3).compute(input4),
                    neurons.get(2).compute(input3),
                    neurons.get(1).compute(input2),
                    neurons.get(0).compute(input1)
                ),
                neurons.get(7).compute(
                    neurons.get(5).compute(input6),
                    neurons.get(4).compute(input5),
                    neurons.get(3).compute(input4),
                    neurons.get(2).compute(input3),
                    neurons.get(1).compute(input2),
                    neurons.get(0).compute(input1)
                ),
                neurons.get(6).compute(
                    neurons.get(5).compute(input6),
                    neurons.get(4).compute(input5),
                    neurons.get(3).compute(input4),
                    neurons.get(2).compute(input3),
                    neurons.get(1).compute(input2),
                    neurons.get(0).compute(input1)
                ),
            ),
            neurons.get(11).compute(
                neurons.get(9).compute(
                    neurons.get(5).compute(input6),
                    neurons.get(4).compute(input5),
                    neurons.get(3).compute(input4),
                    neurons.get(2).compute(input3),
                    neurons.get(1).compute(input2),
                    neurons.get(0).compute(input1)
                ),
                neurons.get(8).compute(
                    neurons.get(5).compute(input6),
                    neurons.get(4).compute(input5),
                    neurons.get(3).compute(input4),
                    neurons.get(2).compute(input3),
                    neurons.get(1).compute(input2),
                    neurons.get(0).compute(input1)
                ),
                neurons.get(7).compute(
                    neurons.get(5).compute(input6),
                    neurons.get(4).compute(input5),
                    neurons.get(3).compute(input4),
                    neurons.get(2).compute(input3),
                    neurons.get(1).compute(input2),
                    neurons.get(0).compute(input1)
                ),
                neurons.get(6).compute(
                    neurons.get(5).compute(input6),
                    neurons.get(4).compute(input5),
                    neurons.get(3).compute(input4),
                    neurons.get(2).compute(input3),
                    neurons.get(1).compute(input2),
                    neurons.get(0).compute(input1)
                ),
            ),
            neurons.get(10).compute(
                neurons.get(9).compute(
                    neurons.get(5).compute(input6),
                    neurons.get(4).compute(input5),
                    neurons.get(3).compute(input4),
                    neurons.get(2).compute(input3),
                    neurons.get(1).compute(input2),
                    neurons.get(0).compute(input1)
                ),
                neurons.get(8).compute(
                    neurons.get(5).compute(input6),
                    neurons.get(4).compute(input5),
                    neurons.get(3).compute(input4),
                    neurons.get(2).compute(input3),
                    neurons.get(1).compute(input2),
                    neurons.get(0).compute(input1)
                ),
                neurons.get(7).compute(
                    neurons.get(5).compute(input6),
                    neurons.get(4).compute(input5),
                    neurons.get(3).compute(input4),
                    neurons.get(2).compute(input3),
                    neurons.get(1).compute(input2),
                    neurons.get(0).compute(input1)
                ),
                neurons.get(6).compute(
                    neurons.get(5).compute(input6),
                    neurons.get(4).compute(input5),
                    neurons.get(3).compute(input4),
                    neurons.get(2).compute(input3),
                    neurons.get(1).compute(input2),
                    neurons.get(0).compute(input1)
                )
            )
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
