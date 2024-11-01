public class Tamu {
    private String nama;
    private String infoKontak;

    public Tamu(String nama, String infoKontak) {
        this.nama = nama;
        this.infoKontak = infoKontak;
    }

    public String getInfoTamu() {
        return "Nama Tamu: " + nama + ", Info Kontak: " + infoKontak;
    }
}
