import java.util.Arrays;

public class KamarSuite extends Kamar {
    private String[] fasilitasTambahan;

    public KamarSuite(int nomorKamar, double hargaPerMalam, String[] fasilitasTambahan) {
        super(nomorKamar, hargaPerMalam);
        this.fasilitasTambahan = fasilitasTambahan;
    }

    @Override
    public String getInfoKamar() {
        String infoDasar = super.getInfoKamar();
        String fasilitas = String.join(", ", fasilitasTambahan);
        return infoDasar + ", Fasilitas Tambahan: " + fasilitas;
    }
}
