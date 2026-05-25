import java.util.Scanner;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Main {

    static Scanner input = new Scanner(System.in);

    static SistemInventarisBarang inventarisBarang = new SistemInventarisBarang();

    static SistemInventarisHistoryTransaksi historyTransaksi = new SistemInventarisHistoryTransaksi();

    public static void main(String[] args) {
        for (int i = 0; i < 4; i++) {
            SistemInventarisBarang.inventarisBarang.add(new ArrayList<>());
        }

        inputBarang();
        menuUtama();
    }

    public static void inputBarang() {
        String lanjut;
        do {
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

            System.out.print("ID Barang: ");
            String id = input.nextLine();

            System.out.print("Nama Barang: ");
            String nama = input.nextLine();

            System.out.print("Stok Barang: ");
            int stok = input.nextInt();

            System.out.print("Harga Per-Satuan: ");
            int hargaSatuan = input.nextInt();

            System.out.print("Harga Per-Box: ");
            int hargaBox = input.nextInt();
            input.nextLine();

            switch (pilih) {
                case 1:
                    System.out.print("Jenis Kertas: ");
                    String jenisKertas =
                            input.nextLine();

                    System.out.print("Merk Kertas: ");
                    String merkKertas =
                            input.nextLine();

                    System.out.print("Ukuran Kertas: ");
                    String ukuran =
                            input.nextLine();

                    new Kertas(
                            id,
                            nama,
                            stok,
                            hargaSatuan,
                            hargaBox,
                            "Kertas",
                            jenisKertas,
                            merkKertas,
                            ukuran
                    );
                    break;

                case 2:
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
                    break;

                case 3:
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
                    break;

                case 4:
                    System.out.print("Jenis Buku: ");
                    String jenisBuku =
                            input.nextLine();
                    System.out.print("Merk Buku: ");
                    String merkBuku =
                            input.nextLine();

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
        int menu;
        do {
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
                    "6. Logout"
            );
            System.out.print("Pilih Menu: ");
            menu = input.nextInt();
            input.nextLine();

            switch (menu) {
                case 1:
                    inventarisBarang.tampilkan();
                    break;
                    
                case 2:
                    inputBarang();
                    break;

                case 3:
                    tambahTransaksi();
                    break;

                case 4:
                    historyTransaksi.tampilkan();
                    break;

                case 5:
                    editBarang();
                    break;

                case 6:
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

    public static void tambahTransaksi() {
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

        do {
            inventarisBarang.tampilkan();
            System.out.print(
                    "\nMasukkan ID Barang: "
            );

            String idCari = input.nextLine();
            Barang barangDipilih =
                    cariBarang(idCari);

            if (barangDipilih != null) {
                if (barangDipilih.stokBarang > 0) {
                    transaksi.tambahBarang(
                            barangDipilih
                    );
                    barangDipilih.stokBarang--;
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

        transaksi.buatTransaksi();
        transaksi.tampilkanTransaksi();
        historyTransaksi.tambahkan(transaksi);
    }

    public static void editBarang() {
        inventarisBarang.tampilkan();
        System.out.print(
                "\nMasukkan ID Barang: "
        );

        String idCari = input.nextLine();
        Barang barangEdit =
                cariBarang(idCari);

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

    public static Barang cariBarang(String idCari) {
        for (List<Barang> baris :SistemInventarisBarang.inventarisBarang) {
            for (Barang barang : baris) {
                if (barang.idBarang.equalsIgnoreCase(idCari)) {
                    return barang;
                }
            }
        }
        return null;
    }
}