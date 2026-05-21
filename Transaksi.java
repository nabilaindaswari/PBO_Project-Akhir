import java.time.LocalDateTime;
import java.util.ArrayList;

public class Transaksi {
    int idTransaksi;
    static double persenDiskon;
    static double persenPajak;
    LocalDateTime tanggalTransaksi;
    double subTotal = 0;
    ArrayList<Barang> listBarang = new ArrayList<>();
    double totalAkhir;
    double nominalDiskon;
    double nominalPajak;

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

    // hitung diskon
    private int hitungNominalDiskon() {
        nominalDiskon = hitungSubtotal() * (persenDiskon / 100);
        return nominalDiskon;
    }

    // hitung pajak
    private int hitungNominalPajak() {
        nominalPajak = hitungSubtotal() * (persenPajak / 100);
        return nominalPajak;
    }

    // buat transaksi dan hitung total akhir
    private int buatTransaksi() {
        totalAkhir = hitungSubtotal() - hitungNominalDiskon() + hitungNominalPajak();
        return totalAkhir;
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