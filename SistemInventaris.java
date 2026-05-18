import java.util.ArrayList;
import java.util.List;


public class SistemInventaris{
    static List<List<Barang>> listBarang = new ArrayList<>(); 
    static List<List<Transaksi>> listTransaksi = new ArrayList<>(); 
    public void tampilkan(){
        System.out.println("Anda sedang mengakses sistem inventaris : ");
    }
   
}

class SistemInventarisBarang extends SistemInventaris{
    @Override
    public void tampilkan(){
        System.out.println("Anda sedang mencoba menampilkan inventaris barang");
        for(Barang[] lst: listBarang ){
            System.out.println("");
            for(Barang isi: lst){
                    System.out.println("ID: " + isi.idBarang + 
                                       " | Nama: " + isi.namaBarang + 
                                       " | Detail: " + isi.detailBarang + 
                                       " | Stok: " + isi.stokBarang + 
                                       " | Harga/Satuan: " + isi.hargaBarangPerSatuan + 
                                       " | Harga/Box: " + isi.hargaBarangPerBox + 
                                       " | Posisi:  ");
            }
        }
    }
    public void tambahkan(Barang barang, int index){
        listBarang.add(barang); //memasukkan barang pada baris sesuai index.
    }

}


class SistemInventarisHistorisBarang extends SistemInventaris{
    
    @Override
    public void tampilkan(){
        System.out.println("Anda sedang mencoba menampilkan inventaris barang");
        for(Barang isi: listTransaksi){
                    System.out.println("ID Transaksi: " + isi.idTransaksi + 
                                       " | Persen Diskon: " + isi.persenDiskon + 
                                       " | Persen Pajak: " + isi.persenPajak + 
                                       " | Tanggal Transaksi: " + isi.tanggalTransaksi + 
                                       " | subTotal: " + isi.subTotal + 
                                       " | List Barang: " + isi.listBarang + 
                                       " | Total Akhir: " + isi.totalAkhir);
            }
    }

    public void tambahkan(Transaksi transaksi){
    
    }

}
