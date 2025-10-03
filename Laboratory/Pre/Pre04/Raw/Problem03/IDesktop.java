// Interface untuk perangkat desktop
interface IDesktop extends IGadget {

  /**
   * Menginstal perangkat lunak pada desktop
   * Menampilkan pesan "Installing [softwareName] on [brand] [model]"
   * 
   * @param softwareName
   */
  void installSoftware(String softwareName);

  /**
   * Membuka aplikasi pada desktop
   * Menampilkan pesan "Opening [appName]"
   *
   * @param appName
   */
  void openApplication(String appName);

  /**
   * Mendapatkan sistem operasi desktop
   * 
   * @return sistem operasi
   */
  String getOperatingSystem();
}