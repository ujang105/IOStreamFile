package bagian3.kontak;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.ArrayList;

public class BukuKontak {
    private ArrayList<Kontak> daftar = new ArrayList<>();
    private String namaBerkas;

    public BukuKontak(String namaBerkas) {
        this.namaBerkas = namaBerkas;
    }

    public void tambahKontak(Kontak kontak) {
        daftar.add(kontak);
    }

    public void tampilkanSemua() {
        System.out.println("== Daftar Kontak ==");
        for (int i = 0; i < daftar.size(); i++) {
            Kontak k = daftar.get(i);
            System.out.println((i + 1) + ". " + k.info());
        }
    }

    public void simpanKeBerkas() {
        try (PrintWriter penulis = new PrintWriter(new FileWriter(namaBerkas))) {
            for (Kontak k : daftar) {
                penulis.println(k.keBaris());
            }
            System.out.println("Kontak disimpan ke " + namaBerkas);
        } catch (IOException e) {
            System.out.println("Gagal menyimpan: " + e.getMessage());
        }
    }

    // SOAL 1: Method mencari kontak berdasarkan nama
    public void cariKontak(String nama) {
        System.out.println("--> Mencari kontak dengan nama: " + nama);
        boolean ditemukan = false;
        for (Kontak k : daftar) {
           
            if (k.getNama().equalsIgnoreCase(nama)) {
                System.out.println("Kontak Ditemukan: " + k.info());
                ditemukan = true;
                break; 
            }
        }
        if (!ditemukan) {
            System.out.println("Kontak dengan nama \"" + nama + "\" tidak ditemukan.");
        }
    }

   
    public void hapusKontak(String nama) {
        System.out.println("--> Menghapus kontak dengan nama: " + nama);
        boolean berhasilHapus = false;
        
        for (int i = 0; i < daftar.size(); i++) {
            if (daftar.get(i).getNama().equalsIgnoreCase(nama)) {
                daftar.remove(i);
                berhasilHapus = true;
                break; 
            }
        }
        
        if (berhasilHapus) {
            System.out.println("Kontak \"" + nama + "\" berhasil dihapus dari daftar.");
            simpanKeBerkas(); // Perubahan langsung disimpan ke file teks
        } else {
            System.out.println("Gagal menghapus: Kontak \"" + nama + "\" tidak ditemukan.");
        }
    }

  
    public void muatDariBerkas() {
        daftar.clear();
        try (BufferedReader pembaca = new BufferedReader(new FileReader(namaBerkas))) {
            String baris;
            while ((baris = pembaca.readLine()) != null) {
                String[] bagian = baris.split(";");
               
                if (bagian.length == 3) {
                    daftar.add(new Kontak(bagian[0], bagian[1], bagian[2]));
                }
            }
            System.out.println("Kontak dimuat dari " + namaBerkas);
        } catch (IOException e) {
            System.out.println("Gagal memuat: " + e.getMessage());
        }
    }

    public int jumlahKontak() {
        return daftar.size();
    }
}