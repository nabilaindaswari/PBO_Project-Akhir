import java.time.LocalDateTime;
import java.util.ArrayList;

public class Transaksi {
    int idTransaksi;
    static double persenDiskon;
    static double persenPajak;
    LocalDateTime tanggalTransaksi;
<<<<<<< HEAD
    int subtotal = 0; 
    int totalAkhir;
    ArrayList<Barang> listBarang = new ArrayList<>();

    public Transaksi(){ // constructor 1
    
    }

    public Transaksi(int idTransaksi, int persenDiskon, int persenPajak, LocalDateTime tanggalTransaksi) { // constructor 2
        this.idTransaksi = idTransaksi;
        this.persenDiskon = persenDiskon;
        this.persenPajak = persenPajak;
        this.tanggalTransaksi = tanggalTransaksi;
    }
=======
    double subTotal = 0;
    ArrayList<Barang> listBarang = new ArrayList<>();
    double totalAkhir;
    double nominalDiskon;
    double nominalPajak;
>>>>>>> 2093fb0d0333559c342796ac35751e656665dd0f

    // tambah barang
    public void tambahBarang(Barang... barangBaru) {
        for (Barang barang : barangBaru) {
            listBarang.add(barang);
        }
    }
    // hitung subtotal
    private int hitungSubtotal() {
        subtotal = 0;
        for (Barang barang : listBarang) {
            subtotal += barang.hargaBarangPerSatuan;
        }
        return subtotal;
    }

    // hitung diskon
    private int hitungNominalDiskon() {
<<<<<<< HEAD
        return hitungSubtotal() * persenDiskon / 100;
=======
        nominalDiskon = hitungSubtotal() * (persenDiskon / 100);
        return nominalDiskon;
>>>>>>> 2093fb0d0333559c342796ac35751e656665dd0f
    }

    // hitung pajak
    private int hitungNominalPajak() {
<<<<<<< HEAD
        return hitungSubtotal() * persenPajak / 100;
=======
        nominalPajak = hitungSubtotal() * (persenPajak / 100);
        return nominalPajak;
>>>>>>> 2093fb0d0333559c342796ac35751e656665dd0f
    }

    // buat transaksi dan hitung total akhir
    private int buatTransaksi() {
        totalAkhir = hitungSubtotal() - hitungNominalDiskon() + hitungNominalPajak();
        return totalAkhir;
    }

    // tampilkan transaksi
    public void tampilkanTransaksi() {
        System.out.println("----------- Transaksi ------------");
        System.out.println("ID Transaksi: " + idTransaksi);
        System.out.println("Tanggal Transaksi: " + tanggalTransaksi);
        System.out.println("\nDaftar Barang:");
        for (Barang barang : listBarang) {
            System.out.println("- " + barang.namaBarang + " @ " + barang.hargaBarangPerSatuan);
        }
<<<<<<< HEAD
        System.out.println("Subtotal: " + hitungSubtotal());
        System.out.println("Diskon (" + persenDiskon + "%): " + hitungNominalDiskon());
        System.out.println("Pajak (" + persenPajak + "%): " + hitungNominalPajak());
        System.out.println("Total Akhir: " + hitungTotalAkhir());
=======
        System.out.println("\nSubtotal: " + subTotal);
        System.out.println("Diskon (" + persenDiskon + "%): " + nominalDiskon);
        System.out.println("Pajak (" + persenPajak + "%): " + nominalPajak);
        System.out.println("Total Akhir: " + totalAkhir);
>>>>>>> 2093fb0d0333559c342796ac35751e656665dd0f
    }
}