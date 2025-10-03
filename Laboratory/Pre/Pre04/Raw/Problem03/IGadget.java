// Interface dasar untuk semua gadget
interface IGadget {
  /**
   * Menghidupkan gadget
   * 
   * Mengubah status isOn menjadi true
   * 
   * Menampilkan pesan "[brand] [model] is now ON"
   */
  void turnOn();

  /**
   * Mematikan gadget
   * 
   * Mengubah status isOn menjadi false
   * 
   * Menampilkan pesan "[brand] [model] is now OFF"
   */
  void turnOff();

  /**
   * Mendapatkan informasi gadget
   * 
   * Jika gadget menyala, mengembalikan string dalam format:
   * "[ON] [brand] [model] - Rp [price]"
   * 
   * Jika gadget mati, mengembalikan string dalam format:
   * "[OFF] [brand] [model] - Rp [price]"
   */
  String getInfo();

  /**
   * Mendapatkan harga gadget
   * 
   * @return harga gadget
   */
  double getPrice();

  /**
   * Mendapatkan merek gadget
   * 
   * @return merek gadget
   */
  String getBrand();
}
