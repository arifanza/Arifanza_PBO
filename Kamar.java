public class Kamar {

    private int nomorKamar;
    private double hargaPerMalam;

    public Kamar(int nomorKamar, double hargaPerMalam) {
        this.nomorKamar = nomorKamar;
        this.hargaPerMalam = hargaPerMalam;
    }

    public String getInfoKamar() {
        return "Nomor Kamar: " + nomorKamar + ", Harga per Malam: " + hargaPerMalam;
    }

    public double getHargaPerMalam() {
        return hargaPerMalam;
    }
}
