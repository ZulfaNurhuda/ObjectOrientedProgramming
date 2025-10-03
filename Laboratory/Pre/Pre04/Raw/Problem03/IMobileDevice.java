// Interface untuk perangkat mobile
interface IMobileDevice extends IGadget {

  /**
   * Melakukan panggilan telepon
   * Menampilkan pesan "Calling [number] from [brand] [model]"
   * 
   * @param number
   */
  void makeCall(String number);

  /**
   * Mengirim pesan
   * Menampilkan pesan "Sending message: [message]"
   *
   * @param message
   */
  void sendMessage(String message);

  /**
   * Menghubungkan ke jaringan WiFi
   * Menampilkan pesan "Connected to [networkName]"
   *
   * @param networkName
   */
  void connectToWifi(String networkName);
}
