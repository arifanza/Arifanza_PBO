// Reservasi.java
public class Reservasi {
    public Tamu tamu;  // Atribut tamu diubah menjadi public
    private Kamar kamar;
    private int malam;

    public Reservasi(Tamu tamu, Kamar kamar, int malam) {
        this.tamu = tamu;
        this.kamar = kamar;
        this.malam = malam;
    }

    public double hitungTotal() {
        return kamar.getHargaPerMalam() * malam;
    }

    public String tampilkanInfoReservasi() {
        return tamu.getInfoTamu() + ", " + kamar.getInfoKamar() + ", Malam: " + malam + ", Total Biaya: " + hitungTotal();
    }
}
