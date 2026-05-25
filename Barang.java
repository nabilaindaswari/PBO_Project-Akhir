//parent class
abstract public class Barang {
        String idBarang;
        String namaBarang;
        String detailBarang;
        int stokBarang;
        int hargaBarangPerSatuan;
        int hargaBarangPerBox;
        String kategori;
        public static int totalStokBarang = 0;
        

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

        public void editBarang(int stokBaru, int hargaPerBox, int hargaPerSatuan){
            // Update static counter
            Barang.totalStokBarang -= this.stokBarang;
            this.stokBarang = stokBaru;
            Barang.totalStokBarang += stokBaru;

            // Update harga
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
    public static int totalStokKertas = 0;

    //constructor 1
        public Kertas(String idBarang, String namaBarang, int stokBarang, int hargaBarangPerSatuan, int hargaBarangPerBox, String Kategori, String jenisKertas, String merkKertas, String ukuranKertas) {
            this.idBarang = idBarang;
            this.namaBarang = namaBarang;
            this.stokBarang = stokBarang;
            this.hargaBarangPerSatuan = hargaBarangPerSatuan;
            this.hargaBarangPerBox = hargaBarangPerBox;
            this.kategori = Kategori;
            this.jenisKertas = jenisKertas;
            this.merkKertas = merkKertas;
            this.ukuranKertas = ukuranKertas;
            Kertas.totalStokKertas += stokBarang;
            Barang.totalStokBarang +=stokBarang;

            Main.inventarisBarang.masukkanBarang(this);
        }

    //constructor 2
        public Kertas(String idBarang, String namaBarang, int stokBarang, int hargaBarangPerSatuan, int hargaBarangPerBox, String Kategori, String detailBarang, String jenisKertas, String merkKertas, String ukuranKertas) {
            this.idBarang = idBarang;
            this.namaBarang = namaBarang;
            this.stokBarang = stokBarang;
            this.hargaBarangPerSatuan = hargaBarangPerSatuan;
            this.hargaBarangPerBox = hargaBarangPerBox;
            this.kategori = Kategori;
            this.detailBarang = detailBarang;
            this.jenisKertas = jenisKertas;
            this.merkKertas = merkKertas;
            this.ukuranKertas = ukuranKertas;
            Main.inventarisBarang.masukkanBarang(this);
            Kertas.totalStokKertas += stokBarang;
            Barang.totalStokBarang +=stokBarang;
        }

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
    public static int totalStokAlatTulis;

    //constructor 1
        public AlatTulis(String idBarang, String namaBarang, int stokBarang, int hargaBarangPerSatuan, int hargaBarangPerBox, String Kategori, String jenisAlatTulis, String merkAlatTulis) {
            this.idBarang = idBarang;
            this.namaBarang = namaBarang;
            this.stokBarang = stokBarang;
            this.hargaBarangPerSatuan = hargaBarangPerSatuan;
            this.hargaBarangPerBox = hargaBarangPerBox;
            this.kategori = Kategori;
            Main.inventarisBarang.masukkanBarang(this);
            this.jenisAlatTulis = jenisAlatTulis;
            this.merkAlatTulis = merkAlatTulis;
            AlatTulis.totalStokAlatTulis += stokBarang;
            Barang.totalStokBarang +=stokBarang;
        }

    //constructor 2
        public AlatTulis(String idBarang, String namaBarang, int stokBarang, int hargaBarangPerSatuan, int hargaBarangPerBox, String Kategori, String detailBarang, String jenisAlatTulis, String merkAlatTulis) {
            this.idBarang = idBarang;
            this.namaBarang = namaBarang;
            this.stokBarang = stokBarang;
            this.hargaBarangPerSatuan = hargaBarangPerSatuan;
            this.hargaBarangPerBox = hargaBarangPerBox;
            this.kategori = Kategori;
            this.detailBarang = detailBarang;
            this.jenisAlatTulis = jenisAlatTulis;
            this.merkAlatTulis = merkAlatTulis;
            Main.inventarisBarang.masukkanBarang(this);
            AlatTulis.totalStokAlatTulis += stokBarang;
            Barang.totalStokBarang +=stokBarang;
        
        }

    @Override
    public void tampilkanBarang(){
    super.tampilkanBarang();
                
    System.out.println("Jenis Alat Tulis: " + jenisAlatTulis);
    System.out.println("Merk Alat Tulis: " + merkAlatTulis);
    System.out.println("Total Keseluruhan Alat Tulis: " + totalStokAlatTulis);
    System.out.println();
    }
}
class AlatKantor extends Barang {
    String jenisAlatKantor;
    String merkAlatKantor;
    String bahan;
    String warnaAlatKantor;
    public static int totalStokAlatKantor;

    //constructor 1
        public AlatKantor(String idBarang, String namaBarang, int stokBarang, int hargaBarangPerSatuan, int hargaBarangPerBox, String Kategori, String jenisAlatKantor, String merkAlatKantor) {
            this.idBarang = idBarang;
            this.namaBarang = namaBarang;
            this.stokBarang = stokBarang;
            this.hargaBarangPerSatuan = hargaBarangPerSatuan;
            this.hargaBarangPerBox = hargaBarangPerBox;
            this.kategori = Kategori;
            this.jenisAlatKantor = jenisAlatKantor;
            this.merkAlatKantor = merkAlatKantor;
            Main.inventarisBarang.masukkanBarang(this);
            AlatKantor.totalStokAlatKantor += stokBarang;
            Barang.totalStokBarang +=stokBarang;
        
        }

    //constructor 2
        public AlatKantor(String idBarang, String namaBarang, int stokBarang, int hargaBarangPerSatuan, int hargaBarangPerBox, String Kategori, String detailBarang, String jenisAlatKantor, String merkAlatKantor,  String bahan, String warnaAlatKantor) {
            this.idBarang = idBarang;
            this.namaBarang = namaBarang;
            this.stokBarang = stokBarang;
            this.hargaBarangPerSatuan = hargaBarangPerSatuan;
            this.hargaBarangPerBox = hargaBarangPerBox;
            this.kategori = Kategori;
            this.detailBarang = detailBarang;
            this.jenisAlatKantor = jenisAlatKantor;
            this.merkAlatKantor = merkAlatKantor;
            this.bahan = bahan;
            this.warnaAlatKantor = warnaAlatKantor;
            Main.inventarisBarang.masukkanBarang(this);
            AlatKantor.totalStokAlatKantor += stokBarang;
            Barang.totalStokBarang +=stokBarang;
        
        }

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
    public static int totalStokBuku;

    //constructor 1
        public Buku(String idBarang, String namaBarang, int stokBarang, int hargaBarangPerSatuan, int hargaBarangPerBox, String Kategori, String jenisBuku, String merkBuku) {
            this.idBarang = idBarang;
            this.namaBarang = namaBarang;
            this.stokBarang = stokBarang;
            this.hargaBarangPerSatuan = hargaBarangPerSatuan;
            this.hargaBarangPerBox = hargaBarangPerBox;
            this.kategori = Kategori;
            this.jenisBuku = jenisBuku;
            this.merkBuku = merkBuku;
            Main.inventarisBarang.masukkanBarang(this);
            Buku.totalStokBuku += stokBarang;
            Barang.totalStokBarang +=stokBarang;
        
        }

    //constructor 2
        public Buku(String idBarang, String namaBarang, int stokBarang, int hargaBarangPerSatuan, int hargaBarangPerBox, String Kategori, String detailBarang, String jenisBuku, String merkBuku, int lembarBuku) {
            this.idBarang = idBarang;
            this.namaBarang = namaBarang;
            this.stokBarang = stokBarang;
            this.hargaBarangPerSatuan = hargaBarangPerSatuan;
            this.hargaBarangPerBox = hargaBarangPerBox;
            this.kategori = Kategori;
            this.detailBarang = detailBarang;
            this.jenisBuku = jenisBuku;
            this.merkBuku = merkBuku;
            this.lembarBuku = lembarBuku;
            Main.inventarisBarang.masukkanBarang(this);
            Buku.totalStokBuku += stokBarang;
            Barang.totalStokBarang +=stokBarang;
        
        }

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
