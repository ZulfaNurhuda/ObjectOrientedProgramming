import java.util.Scanner;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // ===== SECTION 1: Test Container dengan Integer =====
        System.out.println("===== Testing Container<Integer> =====");

        String intContainerName = scanner.nextLine();
        Container<Integer> intContainer = new Container<>(intContainerName);

        int numIntegers = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < numIntegers; i++) {
            int value = scanner.nextInt();
            scanner.nextLine();
            intContainer.add(value);
        }

        intContainer.display();

        // ===== SECTION 2: Test DataProcessor dengan Integer =====
        System.out.println("\n===== Testing DataProcessor<Integer> =====");

        String processorName = scanner.nextLine();
        DataProcessor<Integer> intProcessor = new DataProcessor<>(processorName);

        Integer min = intProcessor.findMin(intContainer);
        System.out.println("Nilai minimum: " + min);

        Integer max = intProcessor.findMax(intContainer);
        System.out.println("Nilai maksimum: " + max);

        intProcessor.sort(intContainer);
        System.out.println("Setelah diurutkan:");
        intContainer.display();

        // ===== SECTION 3: Test Container dengan String =====
        System.out.println("\n===== Testing Container<String> =====");

        String strContainerName = scanner.nextLine();
        Container<String> strContainer = new Container<>(strContainerName);

        int numStrings = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < numStrings; i++) {
            String value = scanner.nextLine();
            strContainer.add(value);
        }

        strContainer.display();

        // ===== SECTION 4: Test DataProcessor dengan String =====
        System.out.println("\n===== Testing DataProcessor<String> =====");

        String strProcessorName = scanner.nextLine();
        DataProcessor<String> strProcessor = new DataProcessor<>(strProcessorName);

        String minStr = strProcessor.findMin(strContainer);
        System.out.println("Nilai minimum: " + minStr);

        String maxStr = strProcessor.findMax(strContainer);
        System.out.println("Nilai maksimum: " + maxStr);

        strProcessor.sort(strContainer);
        System.out.println("Setelah diurutkan:");
        strContainer.display();

        // ===== SECTION 5: Test StatisticalAnalyzer =====
        System.out.println("\n===== Testing StatisticalAnalyzer =====");

        String analyzerName = scanner.nextLine();
        StatisticalAnalyzer analyzer = new StatisticalAnalyzer(analyzerName);

        double avg = analyzer.calculateAverage(intContainer);
        System.out.println("Rata-rata: " + avg);

        double sum = analyzer.calculateSum(intContainer);
        System.out.println("Total: " + sum);

        double threshold = scanner.nextDouble();
        scanner.nextLine();
        List<Number> aboveThreshold = analyzer.findAboveThreshold(intContainer, threshold);
        System.out.println("Nilai di atas threshold " + threshold + ":");
        for (Number num : aboveThreshold) {
            System.out.println("- " + num);
        }

        // ===== SECTION 6: Test Container dengan Double =====
        System.out.println("\n===== Testing Container<Double> =====");

        String doubleContainerName = scanner.nextLine();
        Container<Double> doubleContainer = new Container<>(doubleContainerName);

        int numDoubles = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < numDoubles; i++) {
            double value = scanner.nextDouble();
            scanner.nextLine();
            doubleContainer.add(value);
        }

        doubleContainer.display();

        double avgDouble = analyzer.calculateAverage(doubleContainer);
        System.out.println("Rata-rata: " + avgDouble);

        // ===== SECTION 7: Test DataTransformer =====
        System.out.println("\n===== Testing DataTransformer =====");

        String transformerName = scanner.nextLine();
        String targetContainerName = scanner.nextLine();

        DataTransformer<Integer, String> transformer =
            new DataTransformer<>(transformerName);
        Container<String> transformedContainer =
            new Container<>(targetContainerName);

        // Transform Integer ke String dengan format khusus
        transformer.transform(intContainer, transformedContainer, new TransformFunction<Integer, String>() {
            @Override
            public String apply(Integer input) {
                return "Number: " + input;
            }
        });

        transformedContainer.display();

        // ===== SECTION 8: Test copyData (PECS) =====
        System.out.println("\n===== Testing copyData =====");

        String copyTargetName = scanner.nextLine();
        Container<Number> numberContainer = new Container<>(copyTargetName);

        // Copy Integer container ke Number container (Integer extends Number)
        DataAnalytics.copyData(intContainer, numberContainer);
        numberContainer.display();

        // ===== SECTION 9: Test mergeContainers =====
        System.out.println("\n===== Testing mergeContainers =====");

        String mergedName = scanner.nextLine();
        Container<Integer> mergedContainer =
            DataAnalytics.mergeContainers(intContainer, intContainer, mergedName);
        mergedContainer.display();

        // ===== SECTION 10: Test printContainer (unbounded wildcard) =====
        System.out.println("\n===== Testing printContainer =====");
        DataAnalytics.printContainer(intContainer);
        DataAnalytics.printContainer(strContainer);
        DataAnalytics.printContainer(doubleContainer);

        scanner.close();
    }
}

