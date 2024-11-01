import java.util.ArrayList;
import java.util.Scanner;

public class SistemManajemenReservasiHotel {
    private ArrayList<Kamar> kamarList = new ArrayList<>();
    private ArrayList<Tamu> tamuList = new ArrayList<>();
    private ArrayList<Reservasi> reservasiList = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    
    public void tambahKamar() {
        System.out.print("Masukkan nomor kamar: ");
        int nomorKamar = scanner.nextInt();
        System.out.print("Masukkan harga per malam: ");
        double hargaPerMalam = scanner.nextDouble();
        System.out.print("Pilih tipe kamar (1: Standar, 2: Suite): ");
        int tipeKamar = scanner.nextInt();
        scanner.nextLine();  // Clear the buffer

        Kamar kamar;
        if (tipeKamar == 1) {
            kamar = new KamarStandar(nomorKamar, hargaPerMalam);
        } else {
            System.out.print("Masukkan fasilitas tambahan (pisahkan dengan koma): ");
            String fasilitas = scanner.nextLine();
            kamar = new KamarSuite(nomorKamar, hargaPerMalam, fasilitas.split(","));
        }

        kamarList.add(kamar);
        System.out.println("Kamar berhasil ditambahkan!");
    }


    public void tambahTamu() {
        System.out.print("Masukkan nama tamu: ");
        String nama = scanner.nextLine();
        System.out.print("Masukkan info kontak: ");
        String infoKontak = scanner.nextLine();
        tamuList.add(new Tamu(nama, infoKontak));
        System.out.println("Tamu berhasil ditambahkan!");
    }


    public void buatReservasi() {
        System.out.println("Daftar Kamar:");
        for (Kamar kamar : kamarList) {
            System.out.println(kamar.getInfoKamar());
        }

        System.out.print("Pilih nomor kamar untuk reservasi: ");
        int nomorKamar = scanner.nextInt();
        scanner.nextLine();  // Clear the buffer

        Kamar kamarDipilih = kamarList.stream()
                .filter(k -> k.getInfoKamar().contains(String.valueOf(nomorKamar)))
                .findFirst()
                .orElse(null);

        if (kamarDipilih == null) {
            System.out.println("Kamar tidak ditemukan.");
            return;
        }

        System.out.print("Masukkan jumlah malam: ");
        int malam = scanner.nextInt();

        System.out.println("Daftar Tamu:");
        for (Tamu tamu : tamuList) {
            System.out.println(tamu.getInfoTamu());
        }

        System.out.print("Pilih nama tamu untuk reservasi: ");
        scanner.nextLine();  // Clear the buffer
        String namaTamu = scanner.nextLine();
        Tamu tamuDipilih = tamuList.stream()
                .filter(t -> t.getInfoTamu().contains(namaTamu))
                .findFirst()
                .orElse(null);

        if (tamuDipilih == null) {
            System.out.println("Tamu tidak ditemukan.");
            return;
        }

        Reservasi reservasi = new Reservasi(tamuDipilih, kamarDipilih, malam);
        reservasiList.add(reservasi);
        System.out.println(reservasi.tampilkanInfoReservasi());


        Pembayaran pembayaran = new Pembayaran(reservasi);
        System.out.println(pembayaran.prosesPembayaran());
    }


    public static void main(String[] args) {
        SistemManajemenReservasiHotel sistemHotel = new SistemManajemenReservasiHotel();
        boolean running = true;

        while (running) {
            System.out.println("Menu:");
            System.out.println("1. Tambah Kamar");
            System.out.println("2. Tambah Tamu");
            System.out.println("3. Buat Reservasi");
            System.out.println("4. Keluar");
            System.out.print("Pilih opsi: ");
            Scanner scanner = new Scanner(System.in);
            int opsi = scanner.nextInt();
            scanner.nextLine(); // Clear the buffer

            switch (opsi) {
                case 1:
                    sistemHotel.tambahKamar();
                    break;
                case 2:
                    sistemHotel.tambahTamu();
                    break;
                case 3:
                    sistemHotel.buatReservasi();
                    break;
                case 4:
                    running = false;
                    System.out.println("Terima kasih telah menggunakan sistem!");
                    break;
                default:
                    System.out.println("Opsi tidak valid, silakan coba lagi.");
            }
        }
    }
}
