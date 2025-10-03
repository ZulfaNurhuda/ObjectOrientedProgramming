// Interface untuk tablet (menggabungkan mobile dan desktop)
interface ITablet extends IMobileDevice, IDesktop {

  /**
   * Menggunakan pen (stylus) pada tablet
   * Menampilkan pesan "Using pen on [brand] [model]"
   */
  void usePen();

  /**
   * Memutar layar tablet
   * Menampilkan pesan "Screen rotated on [brand] [model]"
   */
  void rotateScreen();
}