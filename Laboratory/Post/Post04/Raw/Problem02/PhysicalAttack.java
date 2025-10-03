public interface PhysicalAttack extends Attack {
    public int getPhysicalPower();

    public void setPhysicalPower(int power);
    
    // TODO: Buat default method refineBlade()
    // Tambahkan 10 ke physicalPower dengan memanggil getPhysicalPower() dan setPhysicalPower()
    
    // TODO: Buat default method showPhysicalStats()
    // Tampilkan: "Kekuatan Fisik: <physicalPower>"
}