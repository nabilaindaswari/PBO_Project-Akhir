import java.time.LocalDateTime;
import java.util.ArrayList;

public class Transaksi {
    int idTransaksi;
    double persenDiskon;
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

    public Transaksi(int idTransaksi, int persenDiskon, LocalDateTime tanggalTransaksi) { // constructor 2
        this.idTransaksi = idTransaksi;
        this.persenDiskon = persenDiskon;
        this.tanggalTransaksi = tanggalTransaksi;
    }

    // tambah barang
    public void tambahBarang(Barang... barangBaru) {
        for (Barang barang : barangBaru) {
            listBarang.add(barang);
        }
    }
    // hitung subtotal
    private void hitungSubtotal() {
        subTotal = 0;
        for (Barang barang : listBarang) {
            subTotal += barang.hargaBarangPerSatuan;
        }
    }
//
    // hitung diskon
    private void hitungNominalDiskon() {
        nominalDiskon = subTotal * (persenDiskon / 100);
    }

    // hitung pajak
    private void hitungNominalPajak() {
        nominalPajak = subTotal * (persenPajak / 100);
    }

    // buat transaksi dan hitung total akhir
    public void buatTransaksi() {
        hitungSubtotal();
        hitungNominalDiskon();
        hitungNominalPajak();
        totalAkhir = subTotal - nominalDiskon + nominalPajak;
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
        System.out.println("Subtotal: Rp." + subTotal);
        System.out.println("Diskon (" + persenDiskon + "%): Rp." + nominalDiskon);
        System.out.println("Pajak (" + persenPajak + "%): Rp."+ nominalPajak);
        System.out.println("Total Akhir: " + totalAkhir);
    }
}