import java.util.*;

public class SuperCollection {
    private List<Integer> collection;

    // TODO: Buat constructor yang menerima List<Integer> sebagai parameter
    // Inisialisasi atribut collection dengan parameter yang diterima
    public SuperCollection(List<Integer> collection) {
        this.collection = collection;
    }

    // TODO: Buat method partitionByCondition(int threshold)
    // Pisahkan collection menjadi dua grup: element <= threshold dan element >
    // threshold
    // Return List<List<Integer>> dimana:
    // - Index 0 berisi element <= threshold
    // - Index 1 berisi element > threshold
    //
    // HINT:
    // - Perlu membuat struktur data untuk menampung dua kelompok element
    // - Gunakan loop untuk mengiterasi collection dan kondisi untuk memisahkan
    public List<List<Integer>> partitionByCondition(int threshold) {
        List<Integer> lessOrEqual = new ArrayList<>();
        List<Integer> greater = new ArrayList<>();
        for (Integer el : collection) {
            if (el <= threshold) {
                lessOrEqual.add(el);
            } else {
                greater.add(el);
            }
        }

        List<List<Integer>> partition = new ArrayList<>(2);
        partition.add(lessOrEqual);
        partition.add(greater);

        return partition;
    }

    // TODO: Buat method findTopN(int n)
    // Return List<Integer> berisi n element terbesar dalam urutan descending
    // Jika n lebih besar dari ukuran collection, return semua element yang ada
    // Pastikan hasilnya terurut dari terbesar ke terkecil
    //
    // HINT:
    // - Collection asli tidak boleh dimodifikasi
    // - Pertimbangkan cara mengurutkan List dalam urutan terbalik
    // - Collections class memiliki method utility yang berguna
    public List<Integer> findTopN(int n) {
        List<Integer> copyOfCollection = new ArrayList<>(collection);
        Collections.sort(copyOfCollection, Collections.reverseOrder());
        return copyOfCollection.subList(0, Math.min(n, copyOfCollection.size()));
    }

    // TODO: Buat method runningSum()
    // Return List<Integer> berisi cumulative sum
    // Element ke-i berisi jumlah dari element index 0 sampai i
    // Contoh: [1, 2, 3, 4] -> [1, 3, 6, 10]
    //
    // HINT:
    // - Perlu menyimpan state (akumulasi) saat iterasi
    // - Setiap element dalam result adalah hasil penjumlahan sampai index tersebut
    public List<Integer> runningSum() {
        List<Integer> sumOfCollection = new ArrayList<>(collection.size());
        int sum = 0;
        for (Integer el : collection) {
            sum += el;
            sumOfCollection.add(sum);
        }
        return sumOfCollection;
    }

    // TODO: Buat method findPairsWithSum(int targetSum)
    // Cari semua pasangan element yang jika dijumlahkan = targetSum
    // Return List<String> dengan format "a+b=sum"
    // Hindari duplikat pasangan (a,b) dan (b,a) dianggap sama
    // Urutkan hasil berdasarkan nilai a
    //
    // HINT:
    // - Perlu mengecek setiap kemungkinan pasangan element
    // - Bagaimana cara menghindari duplikat seperti "3+5" dan "5+3"?
    // - Pertimbangkan struktur data yang otomatis mengurutkan dan menghindari
    // duplikat
    // - TreeSet adalah Set yang sorted
    // - Gunakan .addAll untuk menambahkan seluruh elemen dari set ke List hasil
    // kalian
    public List<String> findPairsWithSum(int targetSum) {
        Set<String> pairs = new TreeSet<>();
        int size = collection.size();
        for (int i = 0; i < size - 1; i++) {
            for (int j = i + 1; j < size; j++) {
                int a = collection.get(i);
                int b = collection.get(j);
                if (a + b == targetSum) {
                    int min = Math.min(a, b);
                    int max = Math.max(a, b);
                    pairs.add(min + "+" + max + "=" + targetSum);
                }
            }
        }
        return new ArrayList<>(pairs);
    }

    // TODO: Buat method getMostFrequentElements(int n)
    // Return List<Integer> berisi n element yang paling sering muncul
    // Jika ada element dengan frekuensi sama, pilih yang nilainya lebih besar
    //
    // HINT:
    // - Langkah 1: Identifikasi semua element unik
    // - Langkah 2: Hitung berapa kali setiap element muncul
    // - Langkah 3: Urutkan berdasarkan frekuensi (tinggi ke rendah), lalu nilai
    // (tinggi ke rendah)
    // - Pertimbangkan membuat helper class untuk menyimpan pasangan (value,
    // frequency)
    // - Untuk sorting custom, gunakan Comparator
    public List<Integer> getMostFrequentElements(int n) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (Integer el : collection) {
            frequencyMap.put(el, frequencyMap.getOrDefault(el, 0) + 1);
        }

        List<ElementFrequency> elementFrequencies = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            ElementFrequency elementFrequency = new ElementFrequency(entry.getKey(), entry.getValue());
            elementFrequencies.add(elementFrequency);
        }

        Collections.sort(elementFrequencies, Collections.reverseOrder());

        List<Integer> mostFrequentElements = new ArrayList<>();
        for (int i = 0; i < Math.min(n, elementFrequencies.size()); i++) {
            mostFrequentElements.add(elementFrequencies.get(i).value);
        }

        return mostFrequentElements;
    }

    // TODO: Buat method getCollection()
    // Return collection yang sedang digunakan (type: List<Integer>)
    public List<Integer> getCollection() {
        return collection;
    }

    // TODO: Buat method setCollection(List<Integer> newCollection)
    // Set atribut collection dengan newCollection
    public void setCollection(List<Integer> newCollection) {
        collection = newCollection;
    }

    private class ElementFrequency implements Comparable<ElementFrequency> {
        private Integer value;
        private Integer frequency;

        public ElementFrequency(Integer value, Integer frequency) {
            this.value = value;
            this.frequency = frequency;
        }

        @Override
        public int compareTo(ElementFrequency other) {
            int result;
            if (!frequency.equals(other.frequency)) {
                result = frequency.compareTo(other.frequency);
            } else {
                result = value.compareTo(other.value);
            }
            return result;
        }
    }
}