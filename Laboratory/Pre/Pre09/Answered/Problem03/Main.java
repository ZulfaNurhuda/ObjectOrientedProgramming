import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        // Input values
        List<Double> inputs = Arrays.asList(0.5, 0.3, 0.9);

        // Create activation function
        ActivationFunction sigmoid = new Sigmoid();

        // Create neurons
        Neuron neuron1 = new Neuron(Arrays.asList(0.8, 0.2, 0.4), 0.1, sigmoid);
        Neuron neuron2 = new Neuron(Arrays.asList(0.5, 0.7, 0.3), -0.2, sigmoid);

        // Create layer
        Layer layer = new Layer(Arrays.asList(neuron1, neuron2));

        // Forward pass
        List<Double> outputs = layer.forward(inputs);

        // Print results
        System.out.println("Inputs: " + inputs);
        for (int i = 0; i < outputs.size(); i++) {
            System.out.printf(Locale.US, "Neuron %d output: %.6f%n", i + 1, outputs.get(i));
        }
        System.out.println("Layer outputs: " + formatOutputs(outputs));
    }

    private static String formatOutputs(List<Double> values) {
        StringBuilder builder = new StringBuilder();
        builder.append('[');
        for (int i = 0; i < values.size(); i++) {
            if (i > 0) {
                builder.append(", ");
            }
            builder.append(String.format(Locale.US, "%.6f", values.get(i)));
        }
        builder.append(']');
        return builder.toString();
    }
}
