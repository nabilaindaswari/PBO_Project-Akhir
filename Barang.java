/*
sebagai parent class atau induk
tidak dapat dibuat objeknya secara langsung dan berfungsi sebagai kerangka dasar
dan wajib di-override oleh subclass (class turunan)
kelas barang punya 4 turunan, yaitu
1. kertas
2. alat tulis
3. alat kantor
4. buku
*/
abstract public class Barang {

    private String idBarang;
    private String namaBarang;
    private String detailBarang;
    private int stokBarang;
    private int hargaBarangPerSatuan;
    private int hargaBarangPerBox;
    private String kategori;
    private static int totalStokBarang = 0;
        
    //getter-setter
    public String getIdBarang() { return idBarang; }
    public void setIdBarang(String idBarang) { this.idBarang = idBarang; }

    public String getNamaBarang() { return namaBarang; }
    public void setNamaBarang(String namaBarang) { this.namaBarang = namaBarang; }

    public String getDetailBarang() { return detailBarang; }
    public void setDetailBarang(String detailBarang) { this.detailBarang = detailBarang; }

    public int getStokBarang() { return stokBarang; }
    public void setStokBarang(int stokBarang) { this.stokBarang = stokBarang; }

    public int getHargaBarangPerSatuan() { return hargaBarangPerSatuan; }
    public void setHargaBarangPerSatuan(int hargaBarangPerSatuan) { this.hargaBarangPerSatuan = hargaBarangPerSatuan; }

    public int getHargaBarangPerBox() { return hargaBarangPerBox; }
    public void setHargaBarangPerBox(int hargaBarangPerBox) { this.hargaBarangPerBox = hargaBarangPerBox; }

    public String getKategori() { return kategori; }
    public void setKategori(String kategori) { this.kategori = kategori; }

    public static int getTotalStokBarang() { return totalStokBarang; }
    public static void setTotalStokBarang(int totalStokBarang) { Barang.totalStokBarang = totalStokBarang; }

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

/*
sebagai child class atau kelas turunan dari kelas induk (barang)
mewarisi properti dan metode dari kelas induk (barang)
*/
class Kertas extends Barang {

    private int lembar;
    private int ketebalanKertas;
    private String jenisKertas;
    private String merkKertas;
    private String ukuranKertas;
    private static int totalStokKertas = 0;

    //constructor 1
    public Kertas(String idBarang, String namaBarang, int stokBarang, int hargaBarangPerSatuan, int hargaBarangPerBox, String Kategori, String jenisKertas, String merkKertas, String ukuranKertas) {
        setIdBarang(idBarang);
        setNamaBarang(namaBarang);
        setStokBarang(stokBarang);
        setHargaBarangPerSatuan(hargaBarangPerSatuan);
        setHargaBarangPerBox(hargaBarangPerBox);
        setKategori(Kategori);
        this.jenisKertas = jenisKertas;
        this.merkKertas = merkKertas;
        this.ukuranKertas = ukuranKertas;
        
        setTotalStokKertas(getTotalStokKertas() + stokBarang);
        Barang.setTotalStokBarang(Barang.getTotalStokBarang() + stokBarang);

        Main.inventarisBarang.masukkanBarang(this);
    }

    //constructor 2
    public Kertas(String idBarang, String namaBarang, int stokBarang, int hargaBarangPerSatuan, int hargaBarangPerBox, String Kategori, String detailBarang, String jenisKertas, String merkKertas, String ukuranKertas) {
        setIdBarang(idBarang);
        setNamaBarang(namaBarang);
        setStokBarang(stokBarang);
        setHargaBarangPerSatuan(hargaBarangPerSatuan);
        setHargaBarangPerBox(hargaBarangPerBox);
        setKategori(Kategori);
        setDetailBarang(detailBarang);
        this.jenisKertas = jenisKertas;
        this.merkKertas = merkKertas;
        this.ukuranKertas = ukuranKertas;
        
        setTotalStokKertas(getTotalStokKertas() + stokBarang);
        Barang.setTotalStokBarang(Barang.getTotalStokBarang() + stokBarang);
        Main.inventarisBarang.masukkanBarang(this);
    }
    public static int getTotalStokKertas() { return totalStokKertas; }
    public static void setTotalStokKertas(int total) { totalStokKertas = total; }

    // menggunakan override, yang memungkinkan kelas turunan untuk menulis ulang atau 
    // memberikan implementasi spesifik dari sebuah metode yang sudah diwarisi dari kelas induknya(barang)
    @Override
    public void tampilkanBarang(){
    super.tampilkanBarang(); //memanggil method tampilkanBarang default (milik induk)
                
    System.out.println("Lembar Kertas: " + lembar);
    System.out.println("Jenis Kertas: " + jenisKertas);
    System.out.println("Merk Kertas: " + merkKertas);
    System.out.println("Ketebalan Kertas: " + ketebalanKertas);
    System.out.println("Ukuran Kertas: " + ukuranKertas);
    System.out.println("Total Keseluruhan Stok Kertas: " + totalStokKertas);
    System.out.println();
    }
}

/*
sebagai child class atau kelas turunan dari kelas induk (barang)
mewarisi properti dan metode dari kelas induk (barang)
*/
class AlatTulis extends Barang {
    private String jenisAlatTulis;
    private String merkAlatTulis;
    private static int totalStokAlatTulis;

    //constructor 1
    public AlatTulis(String idBarang, String namaBarang, int stokBarang, int hargaBarangPerSatuan, int hargaBarangPerBox, String Kategori, String jenisAlatTulis, String merkAlatTulis) {
        setIdBarang(idBarang);
        setNamaBarang(namaBarang);
        setStokBarang(stokBarang);
        setHargaBarangPerSatuan(hargaBarangPerSatuan);
        setHargaBarangPerBox(hargaBarangPerBox);
        setKategori(Kategori);
        this.jenisAlatTulis = jenisAlatTulis;
        this.merkAlatTulis = merkAlatTulis;
        
        setTotalStokAlatTulis(getTotalStokAlatTulis() + stokBarang);
        Barang.setTotalStokBarang(Barang.getTotalStokBarang() + stokBarang);
        Main.inventarisBarang.masukkanBarang(this);
    }

    //constructor 2
    public AlatTulis(String idBarang, String namaBarang, int stokBarang, int hargaBarangPerSatuan, int hargaBarangPerBox, String Kategori, String detailBarang, String jenisAlatTulis, String merkAlatTulis) {
        setIdBarang(idBarang);
        setNamaBarang(namaBarang);
        setStokBarang(stokBarang);
        setHargaBarangPerSatuan(hargaBarangPerSatuan);
        setHargaBarangPerBox(hargaBarangPerBox);
        setKategori(Kategori);
        setDetailBarang(detailBarang);
        this.jenisAlatTulis = jenisAlatTulis;
        this.merkAlatTulis = merkAlatTulis;
        
        setTotalStokAlatTulis(getTotalStokAlatTulis() + stokBarang);
        Barang.setTotalStokBarang(Barang.getTotalStokBarang() + stokBarang);
        Main.inventarisBarang.masukkanBarang(this);
    }
    public static int getTotalStokAlatTulis() { return totalStokAlatTulis; }
    public static void setTotalStokAlatTulis(int total) { totalStokAlatTulis = total; }

    // menggunakan override, yang memungkinkan kelas turunan untuk menulis ulang atau 
    // memberikan implementasi spesifik dari sebuah metode yang sudah diwarisi dari kelas induknya(barang)
    @Override
    public void tampilkanBarang(){
    super.tampilkanBarang(); //memanggil method tampilkanBarang default (milik induk)
                
    System.out.println("Jenis Alat Tulis: " + jenisAlatTulis);
    System.out.println("Merk Alat Tulis: " + merkAlatTulis);
    System.out.println("Total Keseluruhan Alat Tulis: " + totalStokAlatTulis);
    System.out.println();
    }
}

/*
sebagai child class atau kelas turunan dari kelas induk (barang)
mewarisi properti dan metode dari kelas induk (barang)
*/
class AlatKantor extends Barang {
    private String jenisAlatKantor;
    private String merkAlatKantor;
    private String bahan;
    private String warnaAlatKantor;
    private static int totalStokAlatKantor;

    //constructor 1
    public AlatKantor(String idBarang, String namaBarang, int stokBarang, int hargaBarangPerSatuan, int hargaBarangPerBox, String Kategori, String jenisAlatKantor, String merkAlatKantor) {
        setIdBarang(idBarang);
        setNamaBarang(namaBarang);
        setStokBarang(stokBarang);
        setHargaBarangPerSatuan(hargaBarangPerSatuan);
        setHargaBarangPerBox(hargaBarangPerBox);
        setKategori(Kategori);
        this.jenisAlatKantor = jenisAlatKantor;
        this.merkAlatKantor = merkAlatKantor;
        
        setTotalStokAlatKantor(getTotalStokAlatKantor() + stokBarang);
        Barang.setTotalStokBarang(Barang.getTotalStokBarang() + stokBarang);
        Main.inventarisBarang.masukkanBarang(this);
    }

    //constructor 2
    public AlatKantor(String idBarang, String namaBarang, int stokBarang, int hargaBarangPerSatuan, int hargaBarangPerBox, String Kategori, String detailBarang, String jenisAlatKantor, String merkAlatKantor,  String bahan, String warnaAlatKantor) {
        setIdBarang(idBarang);
        setNamaBarang(namaBarang);
        setStokBarang(stokBarang);
        setHargaBarangPerSatuan(hargaBarangPerSatuan);
        setHargaBarangPerBox(hargaBarangPerBox);
        setKategori(Kategori);
        setDetailBarang(detailBarang);
        this.jenisAlatKantor = jenisAlatKantor;
        this.merkAlatKantor = merkAlatKantor;
        this.bahan = bahan;
        this.warnaAlatKantor = warnaAlatKantor;
        
        setTotalStokAlatKantor(getTotalStokAlatKantor() + stokBarang);
        Barang.setTotalStokBarang(Barang.getTotalStokBarang() + stokBarang);
        Main.inventarisBarang.masukkanBarang(this);
    }
    public static int getTotalStokAlatKantor() { return totalStokAlatKantor; }
    public static void setTotalStokAlatKantor(int total) { totalStokAlatKantor = total; }

    // menggunakan override, yang memungkinkan kelas turunan untuk menulis ulang atau 
    // memberikan implementasi spesifik dari sebuah metode yang sudah diwarisi dari kelas induknya(barang)
    @Override
    public void tampilkanBarang(){
    super.tampilkanBarang(); //memanggil method tampilkanBarang default (milik induk)

    System.out.println("Jenis Alat Kantor: " + jenisAlatKantor);
    System.out.println("Merk Alat Kantor: " + merkAlatKantor);
    System.out.println("Bahan Alat Kantor: " + bahan);
    System.out.println("Warna Alat Kantor: " + warnaAlatKantor);
    System.out.println("Total Keseluruhan Stok Alat Kantor: " + totalStokAlatKantor);
    System.out.println();
    }
}

/*
sebagai child class atau kelas turunan dari kelas induk (barang)
mewarisi properti dan metode dari kelas induk (barang)
*/

class Buku extends Barang {
    private String jenisBuku;
    private String merkBuku;
    private int lembarBuku;
    private static int totalStokBuku;

    //constructor 1
    public Buku(String idBarang, String namaBarang, int stokBarang, int hargaBarangPerSatuan, int hargaBarangPerBox, String Kategori, String jenisBuku, String merkBuku) {
        setIdBarang(idBarang);
        setNamaBarang(namaBarang);
        setStokBarang(stokBarang);
        setHargaBarangPerSatuan(hargaBarangPerSatuan);
        setHargaBarangPerBox(hargaBarangPerBox);
        setKategori(Kategori);
        this.jenisBuku = jenisBuku;
        this.merkBuku = merkBuku;
        
        setTotalStokBuku(getTotalStokBuku() + stokBarang);
        Barang.setTotalStokBarang(Barang.getTotalStokBarang() + stokBarang);
        Main.inventarisBarang.masukkanBarang(this);
    }

    //constructor 2
    public Buku(String idBarang, String namaBarang, int stokBarang, int hargaBarangPerSatuan, int hargaBarangPerBox, String Kategori, String detailBarang, String jenisBuku, String merkBuku, int lembarBuku) {
        setIdBarang(idBarang);
        setNamaBarang(namaBarang);
        setStokBarang(stokBarang);
        setHargaBarangPerSatuan(hargaBarangPerSatuan);
        setHargaBarangPerBox(hargaBarangPerBox);
        setKategori(Kategori);
        setDetailBarang(detailBarang);
        this.jenisBuku = jenisBuku;
        this.merkBuku = merkBuku;
        this.lembarBuku = lembarBuku;
        
        setTotalStokBuku(getTotalStokBuku() + stokBarang);
        Barang.setTotalStokBarang(Barang.getTotalStokBarang() + stokBarang);
        Main.inventarisBarang.masukkanBarang(this);
    }
    public static int getTotalStokBuku() { return totalStokBuku; }
    public static void setTotalStokBuku(int total) { totalStokBuku = total; }

    // menggunakan override, yang memungkinkan kelas turunan untuk menulis ulang atau
    // memberikan implementasi spesifik dari sebuah metode yang sudah diwarisi dari kelas induknya(barang)
    @Override
    public void tampilkanBarang(){
    super.tampilkanBarang(); //memanggil method tampilkanBarang default (milik induk)
    
    System.out.println("Jenis Buku: " + jenisBuku);
    System.out.println("Merk Buku: " + merkBuku);
    System.out.println("Jumlah Lembar Buku: " + lembarBuku);
    System.out.println("Total Keseluruhan Stok Buku: " + totalStokBuku);
    System.out.println();
    }
}
