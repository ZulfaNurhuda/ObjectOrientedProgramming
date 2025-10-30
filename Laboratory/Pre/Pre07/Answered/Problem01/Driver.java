public class Driver {
    public static void main(String[] args) {
        // Beberapa kasus untuk menguji kelas Product
        Product product1 = new Electronic("Laptop", 15000000, 24);
        Product product2 = new Food("Chocolate", 50000, "2025-12-31");
        System.out.println(product1);
        System.out.println(product2);

        // Beberapa kasus untuk menguji kelas Section
        Section<Product> electronicsSection = new Section<>("Electronics");
        electronicsSection.addProduct(product1);
        electronicsSection.addProduct(product2);
        System.out.println("Total value in Electronics section: Rp" + electronicsSection.getTotalValue());
        electronicsSection.getProductWithNameAndType("Laptop", Electronic.class);
        Section.showProducts(electronicsSection.getProducts());
        Product cheapest = Section.findCheapest(electronicsSection.getProducts());
        System.out.println("Cheapest product: " + cheapest);

        // Beberapa kasus untuk menguji kelas Borma
        Borma.addSection("Electronics");
        Borma.addProductToSection(product1, "Electronics");
        Borma.addProductToSection(product2, "Electronics");
        for (Section<Product> sec : Borma.getSections()) {
            System.out.println("Section: " + sec.getName());
            Section.showProducts(sec.getProducts());
        }
        Borma.showTotalValue();
        Borma.removeProductFromSection(product2, "Electronics");
        Borma.showTotalValue();

        // Hapus section
        Borma.removeSection("Electronics");
        System.out.println("Sections after removal: " + Borma.getSections().size());
    }
}
