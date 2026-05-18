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
        public void editBarang(int stok, int hargaPerBox, int hargaPerSatuan){
            this.stokBarang = stok;
            this.hargaBarangPerBox = hargaPerBox;
            this.hargaBarangPerSatuan = hargaPerSatuan;
        }

        class Kertas extends Barang {
            int lembar;
            int ketebalanKertas;
            int ukuranKertas;
            String jenisKertas;
            String merkKertas;

            @Override
            public void tampilkanBarang(){
                super.tampilkanBarang();
                
                System.out.println("Lembar Kertas: " + lembar);
                System.out.println("Jenis Kertas: " + jenisKertas);
                System.out.println("Merk Kertas: " + merkKertas);
                System.out.println("Ketebalan Kertas: " + ketebalanKertas);
                System.out.println("Ukuran Kertas: " + ukuranKertas);
            }
        }
        class AlatTulis extends Barang {
            String merkAlatTulis;
            String jenisAlatTulis;
            String warnaAlatTulis;

            @Override
            public void tampilkanBarang(){
                super.tampilkanBarang();
                
                System.out.println("Jenis Alat Tulis: " + jenisAlatTulis);
                System.out.println("Merk Alat Tulis: " + merkAlatTulis);
                System.out.println("Warna Alat Tulis: " + warnaAlatTulis);
            }
        }
        class AlatKantor extends Barang {
            String bahan;
            String jenisAlatKantor;
            String merkAlatKantor;
            String warnaAlatKantor;

            @Override
            public void tampilkanBarang(){
                super.tampilkanBarang();
                
                System.out.println("Jenis Alat Kantor: " + jenisAlatKantor);
                System.out.println("Merk Alat Kantor: " + merkAlatKantor);
                System.out.println("Bahan Alat Kantor: " + bahan);
                System.out.println("Warna Alat Kantor: " + warnaAlatKantor);
            }
        }
        class Buku extends Barang {
            String jenisBuku;
            String merkBuku;
            int lembarBuku;

            @Override
            public void tampilkanBarang(){
                super.tampilkanBarang();
                
                System.out.println("Jenis Buku: " + jenisBuku);
                System.out.println("Merk Buku: " + merkBuku);
                System.out.println("Jumlah Lembar Buku: " + lembarBuku);
            }
        }
}
