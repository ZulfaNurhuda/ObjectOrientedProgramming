import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Buat SuperCollection dengan ArrayList
        SuperCollection superCol = new SuperCollection(new ArrayList<>());

        // Baca jumlah operasi
        int n = Integer.parseInt(scanner.nextLine().trim());

        // Proses setiap operasi
        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine().trim();
            String[] parts = line.split(" ");
            String command = parts[0].toUpperCase();

            try {
                switch (command) {
                    case "ADD":
                        // Format: ADD 1 2 3 4 5
                        for (int j = 1; j < parts.length; j++) {
                            superCol.getCollection().add(Integer.parseInt(parts[j]));
                        }
                        System.out.println("Element ditambahkan");
                        break;

                    case "PARTITION":
                        int threshold = Integer.parseInt(parts[1]);
                        List<List<Integer>> partitioned = superCol.partitionByCondition(threshold);
                        System.out.println("Partisi dengan threshold " + threshold + ":");
                        System.out.println("  Less or equal: " + partitioned.get(0));
                        System.out.println("  Greater: " + partitioned.get(1));
                        break;

                    case "TOPN":
                        int topN = Integer.parseInt(parts[1]);
                        List<Integer> top = superCol.findTopN(topN);
                        System.out.println("Top " + topN + " elements: " + top);
                        break;

                    case "RUNNINGSUM":
                        List<Integer> runSum = superCol.runningSum();
                        System.out.println("Running sum: " + runSum);
                        break;

                    case "FINDPAIRS":
                        int targetSum = Integer.parseInt(parts[1]);
                        List<String> pairs = superCol.findPairsWithSum(targetSum);
                        System.out.println("Pairs with sum " + targetSum + ":");
                        if (pairs.isEmpty()) {
                            System.out.println("  Tidak ada pasangan");
                        } else {
                            for (String pair : pairs) {
                                System.out.println("  " + pair);
                            }
                        }
                        break;

                    case "MOSTFREQUENT":
                        int freqN = Integer.parseInt(parts[1]);
                        List<Integer> frequent = superCol.getMostFrequentElements(freqN);
                        System.out.println("Top " + freqN + " most frequent: " + frequent);
                        break;

                    case "DISPLAY":
                        Collection<Integer> col = superCol.getCollection();
                        if (col.isEmpty()) {
                            System.out.println("Collection kosong");
                        } else {
                            System.out.println("Isi Collection: " + col);
                        }
                        break;

                    case "SIZE":
                        System.out.println("Ukuran: " + superCol.getCollection().size());
                        break;

                    case "CLEAR":
                        superCol.getCollection().clear();
                        System.out.println("Collection dikosongkan");
                        break;

                    default:
                        System.out.println("Perintah tidak dikenal: " + command);
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Format number tidak valid");
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        scanner.close();
    }
}
