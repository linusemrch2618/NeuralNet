
public class Network {
    private final Layer[] layers;
    private final TrainingData[] tDataSet;

    public Network(Layer[] layers, TrainingData[] tDataSet) {
        this.layers = layers;
        this.tDataSet = tDataSet;
    }

    public void forward(float[] inputs) {
        // First bring the inputs into the input layer layers[0]
        layers[0] = new Layer(inputs);

        for(int i = 1; i < layers.length; i++) {
            for(int j = 0; j < layers[i].neurons.length; j++) {
                float sum = 0;
                for(int k = 0; k < layers[i-1].neurons.length; k++) {
                    sum += layers[i-1].neurons[k].value*layers[i].neurons[j].weights[k];
                }
                sum += layers[i].neurons[j].bias; // TODO add in the bias
                layers[i].neurons[j].value = StatUtil.Sigmoid(sum);
            }
        }
    }

    // This part is heavily inspired from the website in the first note.
    // The idea is that you calculate a gradient and cache the updated weights in the neurons.
    // When ALL the neurons new weight have been calculated we refresh the neurons.
    // Meaning we do the following:
    // Calculate the output layer weights, calculate the hidden layer weight then update all the weights
    public void backward(float learning_rate,TrainingData tData) {

        int number_layers = layers.length;
        int out_index = number_layers-1;

        // Update the output layers
        // For each output
        for(int i = 0; i < layers[out_index].neurons.length; i++) {
            // and for each of their weights
            float output = layers[out_index].neurons[i].value;
            float target = tData.expectedOutput[i];
            float derivative = output-target;
            float delta = derivative*(output*(1-output));
            layers[out_index].neurons[i].gradient = delta;
            for(int j = 0; j < layers[out_index].neurons[i].weights.length;j++) {
                float previous_output = layers[out_index-1].neurons[j].value;
                float error = delta*previous_output;
                layers[out_index].neurons[i].cache_weights[j] = layers[out_index].neurons[i].weights[j] - learning_rate*error;
            }
        }

        //Update all the subsequent hidden layers
        for(int i = out_index-1; i > 0; i--) {
            // For all neurons in that layers
            for(int j = 0; j < layers[i].neurons.length; j++) {
                float output = layers[i].neurons[j].value;
                float gradient_sum = sumGradient(j,i+1);
                float delta = (gradient_sum)*(output*(1-output));
                layers[i].neurons[j].gradient = delta;
                // And for all their weights
                for(int k = 0; k < layers[i].neurons[j].weights.length; k++) {
                    float previous_output = layers[i-1].neurons[k].value;
                    float error = delta*previous_output;
                    layers[i].neurons[j].cache_weights[k] = layers[i].neurons[j].weights[k] - learning_rate*error;
                }
            }
        }

        // Here we do another pass where we update all the weights
        for(int i = 0; i< layers.length;i++) {
            for(int j = 0; j < layers[i].neurons.length;j++) {
                layers[i].neurons[j].update_weight();
            }
        }

    }

    // This function sums up all the gradient connecting a given neuron in a given layer
    public float sumGradient(int n_index,int l_index) {
        float gradient_sum = 0;
        Layer current_layer = layers[l_index];
        for(int i = 0; i < current_layer.neurons.length; i++) {
            Neuron current_neuron = current_layer.neurons[i];
            gradient_sum += current_neuron.weights[n_index]*current_neuron.gradient;
        }
        return gradient_sum;
    }


    // This function is used to train being forward and backward.
    public void train(int training_iterations,float learning_rate) {
        for(int i = 0; i < training_iterations; i++) {
            for(int j = 0; j < tDataSet.length; j++) {
                forward(tDataSet[j].data);
                backward(learning_rate,tDataSet[j]);
            }
        }
    }


    public Layer[] getLayers() {
        return layers;
    }

    public TrainingData[] getTDataSet() {
        return tDataSet;
    }
}