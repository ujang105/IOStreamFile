package tugas;

import java.util.ArrayList;
import java.io.*;

public class Gudang {

    private ArrayList<Barang> daftarBarang;

    public Gudang() {
        daftarBarang = new ArrayList<>();
    }

    public void tambahBarang(Barang barang) {
        daftarBarang.add(barang);
    }

    public void tampilkanSemua() {
        System.out.println("\n===== DAFTAR BARANG =====");
        for (Barang b : daftarBarang) {
            b.info();
        }
    }

    public void simpanKeBerkas(String namaFile) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(namaFile))) {

            for (Barang b : daftarBarang) {
                pw.println(b.keBaris());
            }

            System.out.println("Data berhasil disimpan ke " + namaFile);

        } catch (IOException e) {
            System.out.println("Gagal menyimpan file: " + e.getMessage());
        }
    }

    public void muatDariBerkas(String namaFile) {
        daftarBarang.clear();

        try (BufferedReader br = new BufferedReader(new FileReader(namaFile))) {

            String baris;

            while ((baris = br.readLine()) != null) {

                String[] data = baris.split(";");

                String nama = data[0];
                double harga = Double.parseDouble(data[1]);
                int stok = Integer.parseInt(data[2]);

                tambahBarang(new Barang(nama, harga, stok));
            }

            System.out.println("Data berhasil dimuat dari " + namaFile);

        } catch (IOException e) {
            System.out.println("Gagal membaca file: " + e.getMessage());
        }
    }

    public double totalNilai() {
        double total = 0;

        for (Barang b : daftarBarang) {
            total += b.getHarga() * b.getStok();
        }

        return total;
    }
}