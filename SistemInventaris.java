import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

abstract public class SistemInventaris {
    
    public abstract void tampilkan();
}

class SistemInventarisBarang extends SistemInventaris {

    Map<String, List<Barang>> inventaris = new HashMap<>();

    static public int cekKolomTerakhir(String baris){
        if (!kategori.containsKey(baris)) {
            return 0; 
        }
        int indeksTerakhir = inventarisBarang.get(kategori.get(baris)).size();
        return indeksTerakhir;
    }

    static public void masukkanBarang(Barang barang, String kat, int kolom){
        int indeksBaris = kategori.get(kat);
        inventarisBarang.get(indeksBaris).add(kolom, barang);
    }

    static public void editBarang(Barang barang){
        int tempKolom = barang.kolom;
        int barangBaris = kategori.get(barang.kategori);
        int tempBaris = barangBaris;
        inventarisBarang.get(tempBaris).set(tempKolom, barang);

    }

    @Override
    public void tampilkan() {
        System.out.println("Anda sedang mencoba menampilkan inventaris barang");
        
        for(List<Barang> barisBarang : inventarisBarang) { 
            System.out.println("");
            for(Barang isi : barisBarang) {
                System.out.println("ID: " + isi.idBarang + 
                                   " | Nama: " + isi.namaBarang + 
                                   " | Detail: " + isi.detailBarang + 
                                   " | Stok: " + isi.stokBarang + 
                                   " | Harga/Satuan: " + isi.hargaBarangPerSatuan + 
                                   " | Harga/Box: " + isi.hargaBarangPerBox); 
            }
        }
    }
}

class SistemInventarisHistoryTransaksi extends SistemInventaris {
    static List<Transaksi> inventarisTransaksi = new ArrayList<>(); 
    
    @Override
    public void tampilkan() {
        System.out.println("Anda sedang mencoba menampilkan historis transaksi");
        
        // Tipe datanya diubah menjadi Transaksi
        for(Transaksi isi : inventarisTransaksi) {
            System.out.println("ID Transaksi: " + isi.idTransaksi + 
                               " | Persen Diskon: " + isi.persenDiskon + 
                               " | Persen Pajak: " + Transaksi.persenPajak + 
                               " | Tanggal Transaksi: " + isi.tanggalTransaksi + 
                               " | subTotal: " + isi.subTotal + 
                               " | Total Akhir: " + isi.totalAkhir);
        }
    }

    public void tambahkan(Transaksi transaksi) {
        inventarisTransaksi.add(transaksi);
    }
}