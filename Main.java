import java.util.Scanner; 
import java.time.LocalDateTime;

public class Main {

    static Scanner input = new Scanner(System.in);

    // menaruh kata static di objek pemanggilnya (di Main), objek ini jadi hanya diciptakan satu kali seumur hidup aplikasi.
    public static SistemInventarisBarang inventarisBarang = new SistemInventarisBarang();
    static SistemInventarisTransaksi historyTransaksi = new SistemInventarisTransaksi();
/*
jikapun objek pada class (misal SistemInventarisBarang) dibuat 2x/lebih,
java akan benar-benar membuat dua lemari fisik 
yang terpisah di dalam memori komputer. 
mereka akan punya alamat memori yang berbeda.
*/


    public static void main(String[] args) {
        /*
        proses utama di main hanya ada dua, yaitu proses menginput barang dan proses menampilkan menu utama
        input barang pasti dilakukan di awal penggunaan sistem untuk menjaga setidaknya ada satu barang yang dapat dilakukan transaksi
        input barang di kemudian, juga dapat dilakukan dalam menuUtama
        */

        inputBarang();
        menuUtama();
    }

    public static void inputBarang() {
        /*
        inputBarang adalah sebuah function yang digunakan untuk melakukan input 
        untuk kemudian menjadi parameter dalam membuat objek "Barang"
        */

        String lanjut;
        /*
        String 'lanjut' akan digunakan pada proses perulangan (do while) 
        dalam input data barang untuk mengecek apakah user ingin memberhentikan 
        loop (apakah ingin lanjut memasukkan barang atau stop)
        */

        do {

            //interface untuk memberikan opsi kepada user, kategori barang apa yang ingin dimasukkan
            System.out.println(
            "\n===== INPUT BARANG ====="
            );
            System.out.println("1. Kertas");
            System.out.println("2. Alat Tulis");
            System.out.println("3. Alat Kantor");
            System.out.println("4. Buku");

            System.out.print("Pilih: ");
            int pilih = input.nextInt();
            input.nextLine();

            //memasukkan id barang
            System.out.print("ID Barang: ");
            String id = input.nextLine();

            //memasukkan nama barang
            System.out.print("Nama Barang: ");
            String nama = input.nextLine();

            //memasukkan stok barang
            System.out.print("Stok Barang: ");
            int stok = input.nextInt();

            //memasukkan satuan barang (kilo, pcs, lembar, etc)
            System.out.print("Harga Per-Satuan: ");
            int hargaSatuan = input.nextInt();

            //memasukkan harga per box
            System.out.print("Harga Per-Box: ");
            int hargaBox = input.nextInt();
            input.nextLine();

            //menanyakan user, apakah user ingin menambahkan detail barang (seperti deskripsi barang)
            System.out.print("Apakah ingin menambahkan detail barang? (ya/tidak): ");
            String opsiDetail = input.nextLine();

            //kalo jawabannya iya, maka sistem akan meminta masukan tentang detail baraang
            String detailBarang = "";
            if (opsiDetail.equalsIgnoreCase("ya")) {
                System.out.print("Masukkan detail barang: ");
                detailBarang = input.nextLine();
            }
            
            switch (pilih) {
                case 1:
                    //case ini terpilih jika value dari variable pilih adalah 1 atau 'Kertas'

                    //ini adalah atribut milik class turunan
                    System.out.print("Jenis Kertas: ");
                    String jenisKertas =
                            input.nextLine();

                    System.out.print("Merk Kertas: ");
                    String merkKertas =
                            input.nextLine();

                    System.out.print("Ukuran Kertas: ");
                    String ukuran =
                            input.nextLine();

                    if (opsiDetail.equalsIgnoreCase("ya")) {
                        // Memanggil Constructor 2 (ada parameter detailBarang)
                        new Kertas(id, nama, stok, hargaSatuan, hargaBox, "Kertas", detailBarang, jenisKertas, merkKertas, ukuran);
                    } else {
                        // Memanggil Constructor 1 (tanpa parameter detailBarang)
                        new Kertas(id, nama, stok, hargaSatuan, hargaBox, "Kertas", jenisKertas, merkKertas, ukuran);
                    }
                    break;

                case 2:
                    
                    //case ini terpilih jika value dari variable pilih adalah 2 atau 'Alat Tulis'

                    //ini adalah atribut milik class turunan
                    System.out.print(
                            "Jenis Alat Tulis: "
                    );
                    String jenisAT =
                            input.nextLine();
                    System.out.print(
                            "Merk Alat Tulis: "
                    );
                    String merkAT =
                            input.nextLine();

                    if (opsiDetail.equalsIgnoreCase("ya")) {
                        // Memanggil Constructor 2 (ada parameter detailBarang)
                        new AlatTulis(
                            id,
                            nama,
                            stok,
                            hargaSatuan,
                            hargaBox,
                            "AlatTulis",
                            detailBarang,
                            jenisAT,
                            merkAT
                    );
                    } else {
                        // Memanggil Constructor 1 (tanpa parameter detailBarang)
                        new AlatTulis(
                            id,
                            nama,
                            stok,
                            hargaSatuan,
                            hargaBox,
                            "AlatTulis",
                            jenisAT,
                            merkAT
                    );
                    }
                    break;

                case 3:
                    //case ini terpilih jika value dari variable pilih adalah 3 atau 'Alat Kantor'

                    //ini adalah atribut milik class turunan
                    System.out.print(
                            "Jenis Alat Kantor: "
                    );
                    String jenisAK =
                            input.nextLine();
                    System.out.print(
                            "Merk Alat Kantor: "
                    );
                    String merkAK =
                            input.nextLine();
                    
                    if (opsiDetail.equalsIgnoreCase("ya")) {
                        // Memanggil Constructor 2 (ada parameter detailBarang)
                        
                        System.out.print(
                            "Bahan : "
                        );
                        String bahan =
                            input.nextLine();
                        
                        System.out.print(
                            "Warna Alat Kantor: "
                        );
                        String warnaAK =
                            input.nextLine();

                        new AlatKantor(
                            id,
                            nama,
                            stok,
                            hargaSatuan,
                            hargaBox,
                            "AlatKantor",
                            detailBarang,
                            jenisAK,
                            merkAK,
                            bahan,
                            warnaAK
                    );
                    } else {
                        // Memanggil Constructor 1 (tanpa parameter detailBarang)
                        new AlatKantor(
                            id,
                            nama,
                            stok,
                            hargaSatuan,
                            hargaBox,
                            "AlatKantor",
                            jenisAK,
                            merkAK
                    );
                    }
                    break;

                case 4:
                    
                    //case ini terpilih jika value dari variable pilih adalah 4 atau 'Buku'

                    //ini adalah atribut milik class turunan
                    System.out.print("Jenis Buku: ");
                    String jenisBuku =
                            input.nextLine();
                    System.out.print("Merk Buku: ");
                    String merkBuku =
                            input.nextLine();
                            

                    if (opsiDetail.equalsIgnoreCase("ya")) {
                        System.out.print("Lembar buku : ");
                        int lembarBuku = input.nextInt();
                                
                        // Memanggil Constructor 2 (ada parameter detailBarang)
                        new Buku(
                            id,
                            nama,
                            stok,
                            hargaSatuan,
                            hargaBox,
                            "Buku",
                            detailBarang,
                            jenisBuku,
                            merkBuku,
                            lembarBuku
                        );
                    } else {
                        // Memanggil Constructor 1 (tanpa parameter detailBarang) 
                        new Buku(
                            id,
                            nama,
                            stok,
                            hargaSatuan,
                            hargaBox,
                            "Buku",
                            jenisBuku,
                            merkBuku
                        );
                    }
                    break;

                default:
                    System.out.println(
                            "Kategori tidak valid"
                    );
            }

            System.out.print(
                    "\nTambah barang lagi? (ya/tidak): "
            );
            lanjut = input.nextLine();
        } while (lanjut.equalsIgnoreCase("ya"));
    }

    public static void menuUtama() {
        /*
        ini adalah function untuk menampilkan menu utama, dimana user juga dapat memilih aksi apa yang ingin mereka lakukan
        */
        
        //menu adalah variable yang menyimpan nilai input yang dimasukkan user saat memilih menu
        int menu;
        
        do {

            //interface dari menu
            System.out.println(
                    "\n========== MENU =========="
            );
            System.out.println(
                    "1. Lihat Inventaris"
            );
            System.out.println(
                    "2. Tambah Barang"
            );
            System.out.println(
                    "3. Tambah Transaksi"
            );
            System.out.println(
                    "4. Lihat History"
            );
                    System.out.println(
                    "5. Edit Barang"
            );
                    System.out.println(
                    "6. Manajemen"
            );

            System.out.println(
                    "7. Logout"
            );
            System.out.print("Pilih Menu: ");
            menu = input.nextInt();
            input.nextLine();

            //aksi yang akan di lakukan setelah memilih
            switch (menu) {
                case 1:
                    //pilihan ini hanya akan terjadi jika user memasukkan angka 1 ("Lihat Inventaris")
                    inventarisBarang.tampilkan();
                    break;
                    
                case 2:
                    //pilihan ini hanya akan terjadi jika user memasukkan angka 2 ("Tambah Barang")
                    inputBarang();
                    break;

                case 3:
                    //pilihan ini hanya akan terjadi jika user memasukkan angka 3 ("Tambah Transaksi")
                    tambahTransaksi();
                    break;

                case 4:
                    //pilihan ini hanya akan terjadi jika user memasukkan angka 4 ("Lihat History")
                    historyTransaksi.tampilkan();
                    break;

                case 5:
                    //pilihan ini hanya akan terjadi jika user memasukkan angka 5 ("Edit Barang")
                    editBarang();
                    break;
                
                case 6:
                    //pilihan ini hanya akan terjadi jika user memasukkan angka 6 ("Manajemen")
                    infoManajemen();
                    break;

                case 7:
                    System.out.println(
                            "Logout berhasil"
                    );
                    break;

                default:
                    System.out.println(
                            "Menu tidak valid"
                    );
            }
        } while (menu != 5);
    }

    public static void infoManajemen(){
        // function ini berfungsi untuk menampilkan jumlah stok seluruh barang dan perkategori
        System.out.println("Total stok barang    : " + Barang.totalStokBarang);
        System.out.println("Total stok kertas    : " + Kertas.totalStokKertas);
        System.out.println("Total stok alat tulis    : "+ AlatTulis.totalStokAlatTulis);
        System.out.println("Total stok alat kantor    : "+ AlatKantor.totalStokAlatKantor);
        System.out.println("Total stok buku    : "+ Buku.totalStokBuku);
    }

    public static void tambahTransaksi() {
        // function ini berfungsi untuk menambah transaksi 
        System.out.print(
                "\nMasukkan ID Transaksi: "
        );
        int idTransaksi = input.nextInt();

        System.out.print(
                "Masukkan Diskon (%): "
        );
        int diskon = input.nextInt();
        input.nextLine();

        Transaksi transaksi =
                new Transaksi(idTransaksi,diskon,LocalDateTime.now()
                );
        String lanjut;

        //loop ini dilakukan karena dalam satu transaksi bisa berisi banyak barang
        do {
            inventarisBarang.tampilkan();
            System.out.print(
                    "\nMasukkan ID Barang: "
            );

            String idCari = input.nextLine();
            Barang barangDipilih = inventarisBarang.cariBarang(idCari); //memanggil method cariBarang milik inventarisBarang 
            if (barangDipilih != null) { //mengecek dan memastikan barangDipilih itu benar benar ada
                if (barangDipilih.stokBarang > 0) { //dan stoknya tidak kosong
                    transaksi.tambahBarang(
                            barangDipilih
                    );
                    barangDipilih.stokBarang--; //mengurangi stok barang pada objek barang
                    Barang.totalStokBarang--; //mengurangi stok barang (seluruh barang) pada class barang
                        if (barangDipilih instanceof Kertas) Kertas.totalStokKertas--; // mengurangi stok pada class turunan ( jika class turunannya kertas)
                        else if (barangDipilih instanceof AlatTulis) AlatTulis.totalStokAlatTulis--; // mengurangi stok pada class turunan ( jika class turunannya alat tulis)
                        else if (barangDipilih instanceof AlatKantor) AlatKantor.totalStokAlatKantor--; // mengurangi stok pada class turunan ( jika class turunannya alat kantor)
                        else if (barangDipilih instanceof Buku) Buku.totalStokBuku--; // mengurangi stok pada class turunan ( jika class turunannya buku)

                    System.out.println(
                            "Barang berhasil ditambahkan"
                    );
                } else {
                    System.out.println(
                            "Stok habis"
                    );
                }
            } else {
                System.out.println(
                        "Barang tidak ditemukan"
                );
            }
            System.out.print(
                    "\nTambah barang lagi? (ya/tidak): "
            );

            lanjut = input.nextLine();
        } while (lanjut.equalsIgnoreCase("ya"));

        transaksi.buatTransaksi(); //memanggil method buatTransaksi milik class Transaksi (untuk membuat objek transaksi)
        transaksi.tampilkanTransaksi(); //memanggil method tampilkanTransaksi milik class Transaksi (untuk menampilkan transaksi)
        historyTransaksi.tambahkan(transaksi); //menambahkan objek transaksi pada objek historyTransaksi (ber-class SistemInventarisTransaksi) dengan memanggil method tambahkan milik class objek
    }

    public static void editBarang() {
        // fungsi untuk mengedit barang yang pernah dibuat dan tersimpan dalam sisteminventarisbarang

        //menampilkan semua list barang yang ada di objek inventarisBarang (class sisteminventarisbarang)
        inventarisBarang.tampilkan();

        System.out.print(
                "\nMasukkan ID Barang: "
        );

        String idCari = input.nextLine();
        //mencari barang yang sesuai input di dalam penyimpanan milik class SistemInventarisBarang yang bersifat statissss
        Barang barangEdit = inventarisBarang.cariBarang(idCari);

        if (barangEdit != null) {
            System.out.print(
                    "Masukkan Stok Baru: "
            );
            int stokBaru = input.nextInt();
            System.out.print(
                    "Masukkan Harga Box Baru: "
            );
            int hargaBoxBaru = input.nextInt();
            System.out.print(
                    "Masukkan Harga Satuan Baru: "
            );
            int hargaSatuanBaru = input.nextInt();
            input.nextLine();

            //memanggil method editBarang milik class SistemInventarisBarang
            barangEdit.editBarang(
                    stokBaru,
                    hargaBoxBaru,
                    hargaSatuanBaru
            );

            System.out.println(
                    "Barang berhasil diedit"
            );
        } else {
            System.out.println(
                    "Barang tidak ditemukan"
            );
        }
    }


}