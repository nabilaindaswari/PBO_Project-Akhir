import java.time.LocalDateTime;
import java.util.ArrayList;

public class Transaksi {
    int idTransaksi;
    int persenDiskon;
    int persenPajak;
    LocalDateTime tanggalTransaksi;
    int subTotal = 0;
    ArrayList<Barang> listBarang = new ArrayList<>();
    int totalAkhir;

    // tambah barang
    public Barang tambahBarang(Barang... barangBaru) {
        for (Barang barang : barangBaru) {
            listBarang.add(barang);
        }
        return barangBaru[0];
    }

    // hitung subtotal
    public int hitungSubtotal() {
        subTotal = 0;
        for (Barang barang : listBarang) {
            subTotal += barang.hargaBarangPerSatuan;
        }
        return subTotal;
    }

    // hitung diskon
    public int hitungNominalDiskon() {
        return hitungSubtotal() * (persenDiskon / 100);
    }

    // hitung pajak
    public int hitungNominalPajak() {
        return hitungSubtotal() * (persenPajak / 100);
    }

    // hitung total akhir
    public int hitungTotalAkhir() {
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
        System.out.println("\nSubtotal: " + hitungSubtotal());
        System.out.println("Diskon (" + persenDiskon + "%): " + hitungNominalDiskon());
        System.out.println("Pajak (" + persenPajak + "%): " + hitungNominalPajak());
        System.out.println("Total Akhir: " + hitungTotalAkhir());
    }


}