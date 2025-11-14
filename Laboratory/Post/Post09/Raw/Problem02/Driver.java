import java.util.Scanner;
import java.util.Queue;
import java.util.ArrayDeque;
import java.util.List;


public class Driver {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        Queue<Integer> initialQueue = new ArrayDeque<>(List.of(10, 20, 30, 40, 50));
        Queue<Integer> reversedQueue = new ArrayDeque<>(initialQueue);
        Queue<Integer> reversedFirstKElementsQueue = new ArrayDeque<>(initialQueue);
        Queue<Integer> reversedLastKElementsQueue = new ArrayDeque<>(initialQueue);

        QueueReverser.reverseAll(reversedQueue);
        QueueReverser.reverseFirstKElements(reversedFirstKElementsQueue, 2);
        QueueReverser.reverseLastKElements(reversedLastKElementsQueue, 2);

        System.out.println("Initial Queue: " + initialQueue);
        System.out.println("Reversed Queue: " + reversedQueue);
        System.out.println("Reversed First K Elements Queue: " + reversedFirstKElementsQueue);
        System.out.println("Reversed Last K Elements Queue: " + reversedLastKElementsQueue);

    }
}
