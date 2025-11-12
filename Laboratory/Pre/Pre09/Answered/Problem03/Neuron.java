import java.util.List;

public class Neuron {
    private final List<Double> weights;
    private final double bias;
    private final ActivationFunction activation;

    public Neuron(List<Double> weights, double bias, ActivationFunction activation) {
        // TODO:
        // Simpan daftar bobot, nilai bias, dan fungsi aktivasi ke atribut kelas.
        this.weights = weights;
        this.bias = bias;
        this.activation = activation;
    }

    public double computeOutput(List<Double> inputs) {
        // TODO:
        // 1. Hitung jumlah bobot[i] * input[i]
        // 2. Tambah total penjumlahan dengan bias
        // 3. Kembalikan hasil dari fungsi activate() dengan inputnya adalah nilai dari
        // poin (2)
        double sum = 0.0;
        for (int i = 0; i < weights.size(); i++) {
            sum += weights.get(i) * inputs.get(i);
        }
        sum += bias;
        return activation.activate(sum);
    }
}
