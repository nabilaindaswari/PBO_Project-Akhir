import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

abstract public class SistemInventaris {
    public abstract void tampilkan();
}

class SistemInventarisBarang extends SistemInventaris {
    
    // PENDEKATAN MINIMALIS: Map bertindak sebagai lemari, Key-nya adalah nama rak, Value-nya adalah isi rak.
    private Map<String, List<Barang>> inventaris = new HashMap<>();
    

    // Constructor: Saat lemari dibuat, kita siapkan rak kosongnya
    public SistemInventarisBarang() {
        inventaris.put("Kertas", new ArrayList<>());
        inventaris.put("AlatTulis", new ArrayList<>());
        inventaris.put("AlatKantor", new ArrayList<>());
        inventaris.put("Buku", new ArrayList<>());
    }

    // Method ini sekarang dinamis (tidak static), langsung menaruh barang ke rak yang tepat
    public void masukkanBarang(Barang barang) {
        if (inventaris.containsKey(barang.getKategori())) {
            inventaris.get(barang.getKategori()).add(barang);
        } else {
            System.out.println("Kategori tidak valid!");
        }
    }

    // Menampilkan isi inventaris dengan rapi berdasarkan kategorinya
    @Override
    public void tampilkan() {
        System.out.println("\n========= INVENTARIS BARANG =========");
        for (Map.Entry<String, List<Barang>> rak : inventaris.entrySet()) {
            System.out.println("\n[ Kategori: " + rak.getKey() + " ]");
            if (rak.getValue().isEmpty()) {
                System.out.println("  (Rak kosong)");
            } else {
                for (Barang isi : rak.getValue()) {
                    System.out.println("  - ID: " + isi.getIdBarang() + 
                                       " | Nama: " + isi.getNamaBarang() + 
                                       " | Stok: " + isi.getStokBarang() + 
                                       " | Hrg/Satuan: Rp" + isi.getHargaBarangPerSatuan()); 
                }
            }
        }
        System.out.println("=====================================");
    }
    // Pindahkan method pencarian ini ke dalam SistemInventarisBarang
    public Barang cariBarang(String idCari) {
        for (List<Barang> rak : inventaris.values()) {
            for (Barang barang : rak) {
                if (barang.getIdBarang().equalsIgnoreCase(idCari)) {
                    return barang;
                }
            }
        }
        return null;
    }
}
class SistemInventarisTransaksi extends SistemInventaris {
    
    // PENDEKATAN MINIMALIS: Tidak ada lagi 'static'. Class ini murni menjadi objek buku catatan.
    private List<Transaksi> inventarisTransaksi = new ArrayList<>(); 
    
    @Override
    public void tampilkan() {
        System.out.println("\n========= HISTORY TRANSAKSI =========");
        
        // Cek jika buku catatan masih kosong
        if (inventarisTransaksi.isEmpty()) {
            System.out.println("  (Belum ada transaksi yang tercatat)");
            return;
        }

        // Cetak riwayat dengan format vertikal yang rapi
        for(Transaksi isi : inventarisTransaksi) {
            System.out.println("\n[ ID Transaksi: " + isi.getIdTransaksi() + " ]");
            System.out.println("  Waktu      : " + isi.getTanggalTransaksi());
            System.out.println("  SubTotal   : Rp" + isi.getSubTotal());
            System.out.println("  Diskon     : " + isi.getPersenDiskon() + "%");
            System.out.println("  Pajak      : " + Transaksi.getPersenPajak() + "%");
            System.out.println("  Total Akhir: Rp" + isi.getTotalAkhir());
            System.out.println("  -----------------------------------");
        }
    }

    // Method untuk menambah struk ke dalam buku catatan
    public void tambahkan(Transaksi transaksi) {
        inventarisTransaksi.add(transaksi);
    }
}