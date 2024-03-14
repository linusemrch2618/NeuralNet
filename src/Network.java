import java.util.*;

class Network {
    List<Neuron> neurons = Arrays.asList(
            new Neuron(), new Neuron(), new Neuron(), /* input nodes */
            new Neuron(), new Neuron(),               /* hidden nodes */
            new Neuron()                              /* output node */
    );

    public Double predict(Integer input1, Integer input2){
        return neurons.get(5).compute(
                neurons.get(4).compute(
                        neurons.get(2).compute(input1, input2),
                        neurons.get(1).compute(input1, input2)
                ),
                neurons.get(3).compute(
                        neurons.get(1).compute(input1, input2),
                        neurons.get(0).compute(input1, input2)
                )
        );
    }
}