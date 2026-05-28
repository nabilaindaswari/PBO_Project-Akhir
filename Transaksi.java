import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class Transaksi {
    private int idTransaksi;
    private double persenDiskon;
    private static double persenPajak = 10;
    private LocalDateTime tanggalTransaksi;
    private double subTotal;
    private double totalAkhir;
    private double nominalDiskon;
    private double nominalPajak;

    //menggunakan Map untuk melacak barang beserta jumlah (quantity) belinya
    private Map<Barang, Integer> itemBeli = new LinkedHashMap<>();

    public Transaksi(int idTransaksi, LocalDateTime tanggalTransaksi) { // constructor 1
        this.idTransaksi = idTransaksi;
        this.tanggalTransaksi = tanggalTransaksi;
    
    }

    public Transaksi(int idTransaksi, int persenDiskon, LocalDateTime tanggalTransaksi) { // constructor 2
        this.idTransaksi = idTransaksi;
        this.persenDiskon = persenDiskon;
        this.tanggalTransaksi = tanggalTransaksi;
    }

    //getter
    public int getIdTransaksi() { return idTransaksi; }
    public LocalDateTime getTanggalTransaksi() { return tanggalTransaksi; }
    public double getSubTotal() { return subTotal; }
    public double getPersenDiskon() { return persenDiskon; }
    public static double getPersenPajak() { return persenPajak; }
    public double getTotalAkhir() { return totalAkhir; }
    public double getNominalDiskon() { return nominalDiskon; }
    public double getNominalPajak() { return nominalPajak; }

    // tambah barang
    public void tambahBarang(Barang barangBaru, int jumlah) {
        itemBeli.put(barangBaru, itemBeli.getOrDefault(barangBaru, 0) + jumlah);
    }

    // hitung subtotal
    private void hitungSubtotal() {
        subTotal = 0;
        for (Map.Entry<Barang, Integer> item : itemBeli.entrySet()) {
            subTotal += (item.getKey().getHargaBarangPerSatuan() * item.getValue());
        }
    }

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
        System.out.println("\n╔══════════════════════════════════╗");
        System.out.println("║          STRUK PEMBELIAN         ║");
        System.out.println("╚══════════════════════════════════╝");
        System.out.println("ID Transaksi    : " + idTransaksi);
        System.out.println("Tanggal         : " + tanggalTransaksi);
        System.out.println("\nDaftar Item:");
        System.out.println("----------------------------------");
        for (Map.Entry<Barang, Integer> item : itemBeli.entrySet()) {
            Barang b = item.getKey();
            int qty = item.getValue();
            double subItem = b.getHargaBarangPerSatuan() * qty;
            System.out.printf("  %-18s x%-2d @ Rp%-7d = Rp%.0f\n", b.getNamaBarang(), qty, b.getHargaBarangPerSatuan(), subItem);
        }
        System.out.println("----------------------------------");
        System.out.printf("  Subtotal        : Rp%.0f\n", subTotal);
        System.out.printf("  Diskon  (%.0f%%)  : Rp%.0f\n", persenDiskon, nominalDiskon);
        System.out.printf("  Pajak   (%.0f%%) : Rp%.0f\n", persenPajak, nominalPajak);
        System.out.println("----------------------------------");
        System.out.printf("  TOTAL BAYAR     : Rp%.0f\n", totalAkhir);
        System.out.println("╔══════════════════════════════════╗");
        System.out.println("║        Terima kasih!             ║");
        System.out.println("╚══════════════════════════════════╝\n");
    }
}