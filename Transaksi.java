import java.time.LocalDateTime;
import java.util.ArrayList;

public class Transaksi {
    int idTransaksi;
<<<<<<< HEAD
    static double persenDiskon = 7;
    static double persenPajak = 10;
    LocalDateTime tanggalTransaksi;
    double subTotal;
=======
    int persenDiskon;
    int persenPajak;
    LocalDateTime tanggalTransaksi;
    int subtotal = 0; 
    int totalAkhir;
>>>>>>> b56f7da93c478daad5e12f7f8e9f16a456101217
    ArrayList<Barang> listBarang = new ArrayList<>();

    public Transaksi(int idTransaksi, LocalDateTime tanggalTransaksi) { // constructor 1
        this.idTransaksi = idTransaksi;
        this.tanggalTransaksi = tanggalTransaksi;
    
    }

    public Transaksi(int idTransaksi, int persenDiskon, int persenPajak, LocalDateTime tanggalTransaksi) { // constructor 2
        this.idTransaksi = idTransaksi;
        this.persenDiskon = persenDiskon;
        this.persenPajak = persenPajak;
        this.tanggalTransaksi = tanggalTransaksi;
    }

    public Transaksi(int idTransaksi, LocalDateTime tanggalTransaksi) { // constructor 1
        this.idTransaksi = idTransaksi;
        this.tanggalTransaksi = tanggalTransaksi;
    
    }

    public Transaksi(int idTransaksi, int persenDiskon, int persenPajak, LocalDateTime tanggalTransaksi) { // constructor 2
        this.idTransaksi = idTransaksi;
        this.persenDiskon = persenDiskon;
        this.persenPajak = persenPajak;
        this.tanggalTransaksi = tanggalTransaksi;
    }

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
//
    // hitung diskon
<<<<<<< HEAD
    private void hitungNominalDiskon() {
        nominalDiskon = hitungSubtotal() * (persenDiskon / 100);
    }

    // hitung pajak
    private void hitungNominalPajak() {
        nominalPajak = hitungSubtotal() * (persenPajak / 100);
    }

    // buat transaksi dan hitung total akhir
    public void buatTransaksi() {
=======
    private int hitungNominalDiskon() {
        return hitungSubtotal() * persenDiskon / 100;
    }

    // hitung pajak
    private int hitungNominalPajak() {
        return hitungSubtotal() * persenPajak / 100;
    }

    // hitung total akhir
    private int hitungTotalAkhir() {
>>>>>>> b56f7da93c478daad5e12f7f8e9f16a456101217
        totalAkhir = hitungSubtotal() - hitungNominalDiskon() + hitungNominalPajak();
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
        System.out.println("Subtotal: " + hitungSubtotal());
        System.out.println("Diskon (" + persenDiskon + "%): " + hitungNominalDiskon());
        System.out.println("Pajak (" + persenPajak + "%): " + hitungNominalPajak());
        System.out.println("Total Akhir: " + hitungTotalAkhir());
    }
}