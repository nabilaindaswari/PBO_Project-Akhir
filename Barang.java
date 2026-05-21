//parent class
public class Barang {
        String idBarang;
        String namaBarang;
        String detailBarang;
        int stokBarang;
        int hargaBarangPerSatuan;
        int hargaBarangPerBox;
        static int totalStokBarang;

        public void tampilkanBarang(){
            System.out.println("----------- Barang ------------");
            System.out.println("ID Barang: " + idBarang);
            System.out.println("Nama Barang: " + namaBarang);
            System.out.println("Stok Barang: " + stokBarang);
            System.out.println("Detail Barang: " + detailBarang);
            System.out.println("Harga Barang Per-Satuan: " + hargaBarangPerSatuan);
            System.out.println("Harga Barang Per-Box: " + hargaBarangPerBox);
            System.out.println("Total Stok Barang: " + totalStokBarang);
        }

        public void editBarang(int stok, int hargaPerBox, int hargaPerSatuan){
            Barang.totalStokBarang -= this.stokBarang;
            this.stokBarang = stok;
            Barang.totalStokBarang += stok;

            this.hargaBarangPerBox = hargaPerBox;
            this.hargaBarangPerSatuan = hargaPerSatuan;
        }
}

//child class
class Kertas extends Barang {
    int lembar;
    int ketebalanKertas;
    String jenisKertas;
    String merkKertas;
    String ukuranKertas;
    static int totalStokKertas;

    @Override
    public void tampilkanBarang(){
    super.tampilkanBarang();
                
    System.out.println("Lembar Kertas: " + lembar);
    System.out.println("Jenis Kertas: " + jenisKertas);
    System.out.println("Merk Kertas: " + merkKertas);
    System.out.println("Ketebalan Kertas: " + ketebalanKertas);
    System.out.println("Ukuran Kertas: " + ukuranKertas);
    System.out.println("Total Keseluruhan Stok Kertas: " + totalStokKertas);
    System.out.println();
    }
}
class AlatTulis extends Barang {
    String jenisAlatTulis;
    String merkAlatTulis;
    String warnaAlatTulis;
    static int totalStokAlatTulis;

    @Override
    public void tampilkanBarang(){
    super.tampilkanBarang();
                
    System.out.println("Jenis Alat Tulis: " + jenisAlatTulis);
    System.out.println("Merk Alat Tulis: " + merkAlatTulis);
    System.out.println("Warna Alat Tulis: " + warnaAlatTulis);
    System.out.println("Total Keseluruhan Alat Tulis: " + totalStokAlatTulis);
    System.out.println();
    }
}
class AlatKantor extends Barang {
    String jenisAlatKantor;
    String merkAlatKantor;
    String bahan;
    String warnaAlatKantor;
    static int totalStokAlatKantor;

    @Override
    public void tampilkanBarang(){
    super.tampilkanBarang();
                
    System.out.println("Jenis Alat Kantor: " + jenisAlatKantor);
    System.out.println("Merk Alat Kantor: " + merkAlatKantor);
    System.out.println("Bahan Alat Kantor: " + bahan);
    System.out.println("Warna Alat Kantor: " + warnaAlatKantor);
    System.out.println("Total Keseluruhan Stok Alat Kantor: " + totalStokAlatKantor);
    System.out.println();
    }
}
class Buku extends Barang {
    String jenisBuku;
    String merkBuku;
    int lembarBuku;
    static int totalStokBuku;

    @Override
    public void tampilkanBarang(){
    super.tampilkanBarang();
                
    System.out.println("Jenis Buku: " + jenisBuku);
    System.out.println("Merk Buku: " + merkBuku);
    System.out.println("Jumlah Lembar Buku: " + lembarBuku);
    System.out.println("Total Keseluruhan Stok Buku: " + totalStokBuku);
    System.out.println();
    }
}
