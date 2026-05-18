public class Barang {
        String idBarang;
        String namaBarang;
        String detailBarang;
        int stokBarang;
        int hargaBarangPerSatuan;
        int hargaBarangPerBox;
        int kolom;
        int baris;

        public void tampilkanBarang(){
            System.out.println("----------- Barang ------------");
            System.out.println("ID Barang: " + idBarang);
            System.out.println("Nama Barang: " + namaBarang);
            System.out.println("Stok Barang: " + stokBarang);
            System.out.println("Detail Barang: " + detailBarang);
            System.out.println("Harga Barang Per-Satuan: " + hargaBarangPerSatuan);
            System.out.println("Harga Barang Per-Box: " + hargaBarangPerBox);
            System.out.println("Kolom: " + kolom);
            System.out.println("Baris: " + baris);
            System.out.println();
        }
        public editBarang(int stok, int hargaPerBox, int hargaPerSatuan){
            this.stokBarang = stok;
            this.hargaBarangPerBox = hargaPerBox;
            this.hargaBarangPerSatuan = hargaPerSatuan;
        }

        class Kertas extends Barang {
            int lembar;
            int ketebalanKertas;
            int ukuranKertas;
            String jenisKertas;
            String merk;

            public void tampilkanBarang(){
                
            }
        }
        class AlatTulis extends Barang {
            String merk;
            String jenisAlatTulis;
            String warna;
        }
        class AlatKantor extends Barang {
            String bahan;
            String jenisAlatKantor;
            String warna;
        }
        class Buku extends Barang {
            String jenisBuku;
            String merk;
            int lembar;
        }
}
