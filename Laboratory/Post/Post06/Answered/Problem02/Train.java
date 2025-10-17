public class Train {
    private String name;
    private int capacity;
    private int availableSeats;

    /*
     * Konstruktor Kelas Train
     * TODO: Lengkapi state awal dari attribut Train
     * - Inisialisasi name dan capacity dari parameter konstruktor
     * - Inisialisasi availableSeats dengan nilai yang sama dengan capacity
     */
    public Train(String name, int capacity) {
        // TODO: lengkapi konstruktor
        this.name = name;
        this.capacity = capacity;
        this.availableSeats = capacity;
    }

    /*
     * Getter untuk name
     * TODO: Getter ini akan mengembalikan String name
     */
    public String getName() {
        // TODO: lengkapi getter
        return name;
    }

    /*
     * Method hasAvailableSeats
     * TODO: Method ini akan mengembalikan true jika availableSeats > 0,
     * mengembalikan false jika tidak
     */
    public boolean hasAvailableSeats() {
        // TODO: lengkapi method hasAvailableSeats
        return availableSeats > 0;
    }

    /*
     * Method reduceSeat
     * TODO: Method ini berupa prosedur yang akan mengurangi availableSeats
     * sebanyak 1 jika availableSeats > 0
     */
    public void reduceSeat() {
        // TODO: lengkapi method reduceSeat
        if (availableSeats > 0) {
            availableSeats--;
        }
    }

    /*
     * Method increaseSeat
     * TODO: Method ini berupa prosedur yang akan menambah availableSeats
     * sebanyak 1 jika availableSeats < capacity
     */
    public void increaseSeat() {
        // TODO: lengkapi method increaseSeat
        if (availableSeats < capacity) {
            availableSeats++;
        }
    }

    /*
     * Method toString
     * TODO: Method ini akan mengembalikan representasi String dari objek Train
     * dengan format "<name> (Sisa kursi: <availableSeats>/<capacity>)"
     */
    @Override
    public String toString() {
        // TODO: lengkapi method toString
        return String.format("%s (Sisa kursi: %d/%d)", name, availableSeats, capacity);
    }
}
