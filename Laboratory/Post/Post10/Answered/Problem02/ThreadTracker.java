import java.util.Collections;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class ThreadTracker {
    public static final Set<Long> threadIds = Collections.newSetFromMap(new ConcurrentHashMap<>());
    
    public static void mark() {
        threadIds.add(Thread.currentThread().threadId());
    }
    
    public static void reset() {
        threadIds.clear();
    }
    
    public static void verifyUsedMultipleThreads() {
        if (threadIds.size() != ParallelPalindrom.NUM_OF_THREAD) {
            throw new RuntimeException("Jumlah thread yang terpakai: " + threadIds.size() + ". Thread yang diharapkan: " + ParallelPalindrom.NUM_OF_THREAD);
        }
    }
}