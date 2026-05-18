import java.time.LocalDateTime;
import java.util.ArrayList;

public class Transaksi {
    int idTransaksi;
    double persenDiskon;
    double persenPajak;
    LocalDateTime tanggalTransaksi;
    double subTotal = 0;
    ArrayList<Barang> listBarang = new ArrayList<>();
    double totalAkhir;

    // tambah barang
    public Barang tambahBarang(Barang barang) {
        listBarang.add(barang);
        return barang;
    }

    // hitung subtotal
    public double hitungSubtotal() {
        subtotal = 0;
        for (Barang barang : listBarang) {
            subtotal += barang.harga * barang.jumlah;
        }
        return subtotal;
    }

    // hitung diskon
    public double hitungNominalDiskon() {
        return hitungSubtotal() * (persenDiskon / 100);
    }

    // hitung pajak
    public double hitungNominalPajak() {
        return hitungSubtotal() * (persenPajak / 100);
    }

    // hitung total akhir
    public double hitungTotalAkhir() {
        totalAkhir = hitungSubtotal() - hitungNominalDiskon() + hitungNominalPajak();
        return totalAkhir;
    }

    // tampilkan transaksi
    public void tampilkanTransaksi() {
        System.out.println("ID Transaksi: " + idTransaksi);
        System.out.println("Tanggal Transaksi: " + tanggalTransaksi);
        System.out.println("\nDaftar Barang:");
        for (Barang barang : listBarang) {
            System.out.println("- " + barang.nama + " x" + barang.jumlah + " @ " + barang.harga);
        }
        System.out.println("\nSubtotal: " + hitungSubtotal());
        System.out.println("Diskon (" + persenDiskon + "%): " + hitungNominalDiskon());
        System.out.println("Pajak (" + persenPajak + "%): " + hitungNominalPajak());
        System.out.println("Total Akhir: " + hitungTotalAkhir());
    }


}
}
