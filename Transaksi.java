import java.time.LocalDateTime;
import java.util.ArrayList;

public class Transaksi {
    int idTransaksi;
    static double persenDiskon = 7;
    static double persenPajak = 10;
    LocalDateTime tanggalTransaksi;
    double subTotal;
    ArrayList<Barang> listBarang = new ArrayList<>();
    double totalAkhir;
    double nominalDiskon;
    double nominalPajak;

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
    public Barang tambahBarang(Barang... barangBaru) {
        for (Barang barang : barangBaru) {
            listBarang.add(barang);
        }
        return barangBaru[0];
    }

    // hitung subtotal
    private int hitungSubtotal() {
        subTotal = 0;
        for (Barang barang : listBarang) {
            subTotal += barang.hargaBarangPerSatuan;
        }
        return subTotal;
    }
//
    // hitung diskon
    private void hitungNominalDiskon() {
        nominalDiskon = hitungSubtotal() * (persenDiskon / 100);
    }

    // hitung pajak
    private void hitungNominalPajak() {
        nominalPajak = hitungSubtotal() * (persenPajak / 100);
    }

    // buat transaksi dan hitung total akhir
    public void buatTransaksi() {
        totalAkhir = hitungSubtotal() - hitungNominalDiskon() + hitungNominalPajak();
    }

    // tampilkan transaksi
    public void tampilkanTransaksi() {
        System.out.println("ID Transaksi: " + idTransaksi);
        System.out.println("Tanggal Transaksi: " + tanggalTransaksi);
        System.out.println("\nDaftar Barang:");
        for (Barang barang : listBarang) {
            System.out.println("- " + barang.namaBarang + " @ " + barang.hargaBarangPerSatuan);
        }
        System.out.println("\nSubtotal: " + subTotal);
        System.out.println("Diskon (" + persenDiskon + "%): " + nominalDiskon);
        System.out.println("Pajak (" + persenPajak + "%): " + nominalPajak);
        System.out.println("Total Akhir: " + totalAkhir);
    }
}