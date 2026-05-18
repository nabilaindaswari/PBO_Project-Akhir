import java.util.ArrayList;
import java.util.List;

public class SistemInventaris {
    
    public void tampilkan() {
        System.out.println("Anda sedang mengakses sistem inventaris : ");
    }
}

class SistemInventarisBarang extends SistemInventaris {

    List<List<Barang>> inventarisBarang = new ArrayList<>(); 

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
    
    public void tambahkan(Barang barang, int indexBaris) {
        while (inventarisBarang.size() <= indexBaris) {
            inventarisBarang.add(new ArrayList<>());
        }
        inventarisBarang.get(indexBaris).add(barang); 
    }
}

class SistemInventarisHistoryTransaksi extends SistemInventaris {
    List<Transaksi> inventarisTransaksi = new ArrayList<>(); 
    
    @Override
    public void tampilkan() {
        System.out.println("Anda sedang mencoba menampilkan historis transaksi");
        
        // Tipe datanya diubah menjadi Transaksi
        for(Transaksi isi : inventarisTransaksi) {
            System.out.println("ID Transaksi: " + isi.idTransaksi + 
                               " | Persen Diskon: " + isi.persenDiskon + 
                               " | Persen Pajak: " + isi.persenPajak + 
                               " | Tanggal Transaksi: " + isi.tanggalTransaksi + 
                               " | subTotal: " + isi.subTotal + 
                               " | Total Akhir: " + isi.totalAkhir);
        }
    }

    public void tambahkan(Transaksi transaksi) {
        inventarisTransaksi.add(transaksi);
    }
}