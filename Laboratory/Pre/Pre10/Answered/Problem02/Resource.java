/*
 * Buatlah kelas Resource dengan attribut String name dan Object lock
 * Inisiasi kelas dengan konstruktor menerima parameter String name
 * Object lock diinisiasi dengan object baru
*/
public class Resource {
    public final String name;
    public final Object lock;

    public Resource(String name) {
        this.name = name;
        this.lock = new Object();
    }
}