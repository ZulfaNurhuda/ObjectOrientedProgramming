import java.util.ArrayList;
import java.util.List;

public class Layer {
    private final List<Neuron> neurons;

    public Layer(List<Neuron> neurons) {
        // TODO:
        // Inisialisasi atribut neurons menggunakan list neuron dari parameter.
        this.neurons = neurons;
    }

    public List<Double> forward(List<Double> inputs) {
        // TODO:
        // Kembalikan sebuah list yang berisi keluaran fungsi computeOutput setiap
        // neuron berdasarkan inputs.
        List<Double> outputs = new ArrayList<>();
        for (Neuron neuron : neurons) {
            outputs.add(neuron.computeOutput(inputs));
        }
        return outputs;
    }
}
