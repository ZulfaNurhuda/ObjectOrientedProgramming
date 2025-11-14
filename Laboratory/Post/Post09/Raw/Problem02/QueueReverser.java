import java.util.Queue;
import java.util.Stack;

/*
 * Kelas QueueReverser
 * Deskripsi:
 * Kelas ini berisi tiga method statis untuk membalik (reverse) elemen-elemen 
 * di dalam sebuah Queue menggunakan struktur data Stack dari Java Collections.
 * 
 * Method yang harus diimplementasikan:
 * 1. reverseAll()            -> membalik seluruh elemen queue
 * 2. reverseFirstKElements() -> membalik K elemen pertama dari queue
 * 3. reverseLastKElements()  -> membalik K elemen terakhir dari queue
 * 
 * HINT: Berikut penjelasan method yang mungkin bisa kamu gunakan untuk membantu implementasi:
 * - queue.offer()     -> menambahkan elemen ke belakang queue (seperti enqueue)
 * - queue.poll()      -> menghapus dan mengembalikan elemen depan queue (seperti dequeue)
 * - queue.isEmpty()   -> mengecek apakah queue kosong
 * - queue.size()      -> mengecek ukuran queue
 * - queue.peek()      -> mengembalikan elemen depan queue tanpa menghapusnya
 * - queue.clear()     -> menghapus semua elemen dari queue
 * 
 * - stack.push()      -> menambahkan elemen ke atas stack
 * - stack.pop()       -> menghapus dan mengembalikan elemen atas stack
 * - stack.isEmpty()   -> mengecek apakah stack kosong
 * - stack.size()      -> mengecek ukuran stack
 * - stack.peek()      -> mengembalikan elemen atas stack tanpa menghapusnya
 * - stack.clear()     -> menghapus semua elemen dari stack
 */
public class QueueReverser {
    /*
     * Method reverseAll()
     * -------------------
     * Fungsi: Membalik seluruh isi Queue menggunakan Stack.
     * 
     * Contoh:
     * Queue awal  : [10, 20, 30, 40, 50]
     * Queue akhir : [50, 40, 30, 20, 10]
     */
    public static <T> void reverseAll(Queue<T> queue) {
        // TODO: Lengkapi code di sini
    }

    /*
     * Method reverseFirstKElements()
     * ------------------------------
     * Fungsi: Membalik K elemen pertama dari Queue menggunakan bantuan Stack.
     * 
     * Contoh:
     * Queue awal  : [10, 20, 30, 40, 50], k = 2
     * Queue akhir : [20, 10, 30, 40, 50] (2 elemen pertama dibalik)
     * 
     * NOTE: Jika k kurang dari atau sama dengan 0 atau k lebih besar dari ukuran queue atau queue kosong, maka tidak ada yang dibalik.
     */
    public static <T> void reverseFirstKElements(Queue<T> queue, int k) {
        // TODO: Lengkapi code di sini
    }

    /*
     * Method reverseLastKElements()
     * -----------------------------
     * Fungsi: Membalik K elemen terakhir dari Queue menggunakan bantuan Stack.
     * 
     * Contoh:
     * Queue awal  : [10, 20, 30, 40, 50], k = 2
     * Queue akhir : [10, 20, 30, 50, 40] (2 elemen terakhir dibalik)
     * 
     * NOTE: Jika k kurang dari atau sama dengan 0 atau k lebih besar dari ukuran queue atau queue kosong, maka tidak ada yang dibalik.
     */
    public static <T> void reverseLastKElements(Queue<T> queue, int k) {
        // TODO: Lengkapi code di sini
    }
}
