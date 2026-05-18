//test

import java.util.ArrayList;

public class SistemInventaris{
    static ArrayList<Barang> listBarang = new ArrayList<>();
    static ArrayList<Barang> listTransaksi = new ArrayList<>();

    public void tampilkan(){
        System.out.println("Anda sedang mengakses sistem inventaris : ");
    }
   
}

class SistemInventarisBarang extends SistemInventaris{
    @Override
    public void tampilkan(){
        System.out.println("Anda sedang mencoba menampilkan inventaris barang");
        for(Barang[] list: ListBarang ){
            System.out.println("");
            for(Barang isi: list){
                    System.out.println("ID: " + isi.idBarang + 
                                       " | Nama: " + isi.namaBarang + 
                                       " | Detail: " + isi.detailBarang + 
                                       " | Stok: " + isi.stokBarang + 
                                       " | Harga/Satuan: " + isi.hargaBarangPerSatuan + 
                                       " | Harga/Box: " + isi.hargaBarangPerBox + 
                                       " | Posisi: [" + isi.baris + "][" + isi.kolom + "]");
            }
        }
    }
    public void tambahkan(Barang barang){
        listBarang.add(barang);
    }

}


class SistemInventarisHistorisBarang extends SistemInventaris{
    
    @Override
    public void tampilkan(){
        System.out.println("Anda sedang mencoba menampilkan inventaris barang");
        for(Barang isi: list){
                    System.out.println("ID Transaksi: " + isi.idTransaksi + 
                                       " | Persen Diskon: " + isi.persenDiskon + 
                                       " | Persen Pajak: " + isi.persenPajak + 
                                       " | Tanggal Transaksi: " + isi.tanggalTransaksi + 
                                       " | subTotal: " + isi.subTotal + 
                                       " | List Barang: " + isi.listBarang + 
                                       " | Total Akhir: " + isi.totalAkhir;
            }
    }

    public void tambahkan(Transaksi transaksi){

}
