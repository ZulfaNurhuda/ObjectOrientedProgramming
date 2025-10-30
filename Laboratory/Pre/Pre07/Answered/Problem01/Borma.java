import java.util.ArrayList;
import java.util.List;

public class Borma {
    static List<Section<Product>> sections = new ArrayList<>();

    /*
     * TODO: Lengkapi implementasi static-method addSection
     * Method ini akan menambahkan Section baru ke dalam list sections
     * Lakukan validasi agar sections memiliki section dengan nama yang unik
     * Jika Section dengan nama yang sama sudah ada, 
     * tampilkan pesan "Section already exists" dan tidak menambahkan Section baru
     */
    public static void addSection(String sectionName) {
        // TODO: Lengkapi implementasi method ini
        boolean exists = false;
        for (int i = 0; i < sections.size() && !exists; i++) {
            if (sections.get(i).getName().equals(sectionName)) {
                exists = true;
            }
        }
        if (exists) {
            System.out.println("Section already exists");
        } else {
            Section<Product> newSection = new Section<>(sectionName);
            sections.add(newSection);
        }
    }

    /*
     * TODO: Lengkapi implementasi static-method removeSection
     * Method ini akan menghapus Section dari list sections berdasarkan nama section
     * Jika Section dengan nama tersebut tidak ditemukan,
     * tampilkan pesan "Section not found"
     */
    public static void removeSection(String sectionName) {
        // TODO: Lengkapi implementasi method ini
        boolean found = false;
        for (int i = 0; i < sections.size() && !found; i++) {
            if (sections.get(i).getName().equals(sectionName)) {
                sections.remove(i);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Section not found");
        }
    }

    /*
     * TODO: Lengkapi implementasi static-method getSections
     * Method ini akan mengembalikan list sections
     */
    public static List<Section<Product>> getSections() {
        // TODO: Lengkapi implementasi method ini
        return sections;
    }

    /*
     * TODO: Lengkapi implementasi static-method addProductToSection
     * Method ini akan menambahkan Product ke dalam Section berdasarkan nama section
     * Jika Section dengan nama tersebut tidak ditemukan,
     * tampilkan pesan "Section not found"
     */
    public static void addProductToSection(Product product, String sectionName) {
        // TODO: Lengkapi implementasi method ini
        boolean found = false;
        for (int i = 0; i < sections.size() && !found; i++) {
            if (sections.get(i).getName().equals(sectionName)) {
                sections.get(i).addProduct(product);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Section not found");
        }
    }

    /*
     * TODO: Lengkapi implementasi static-method removeProductFromSection
     * Method ini akan menghapus Product dari Section berdasarkan nama section
     * Jika Section dengan nama tersebut tidak ditemukan,
     * tampilkan pesan "Section not found"
     */
    public static void removeProductFromSection(Product product, String sectionName) {
        // TODO: Lengkapi implementasi method ini
        boolean found = false;
        for (int i = 0; i < sections.size() && !found; i++) {
            if (sections.get(i).getName().equals(sectionName)) {
                sections.get(i).removeProduct(product);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Section not found");
        }
    }

    /*
     * TODO: Lengkapi implementasi static-method showTotalValue
     * Method ini akan menampilkan total nilai dari semua Section
     * Format tampilan: "Total value of all sections: Rp<total_value>"
     */
    public static void showTotalValue() {
        // TODO: Lengkapi implementasi method ini
        double totalValue = 0;
        for (Section<Product> section : sections) {
            totalValue += section.getTotalValue();
        }
        System.out.println("Total value of all sections: Rp" + totalValue);
    }
}
