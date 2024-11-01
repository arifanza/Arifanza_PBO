// Pembayaran.java
public class Pembayaran {
    private Reservasi reservasi;

    public Pembayaran(Reservasi reservasi) {
        this.reservasi = reservasi;
    }

    public String prosesPembayaran() {
        double totalBiaya = reservasi.hitungTotal();
        return "Pembayaran diproses untuk " + reservasi.tamu.getInfoTamu() + ": Total Biaya: " + totalBiaya;
    }
}
