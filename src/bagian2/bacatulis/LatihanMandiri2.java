package bagian2.bacatulis;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;

public class LatihanMandiri2 {
    public static void main(String[] args) {
        String namaBerkas = "hari.txt";

        
        System.out.println("=== SOAL 1: Menulis & Membaca 5 Hari ===");
        
        
        try (PrintWriter penulis = new PrintWriter(new FileWriter(namaBerkas))) {
            penulis.println("Senin");
            penulis.println("Selasa");
            penulis.println("Rabu");
            penulis.println("Kamis");
            penulis.println("Jumat");
            System.out.println("Berhasil menulis 5 hari ke " + namaBerkas + "\n");
        } catch (IOException e) {
            System.out.println("Gagal menulis berkas: " + e.getMessage());
        }

       
        tampilkanIsiBerkas(namaBerkas);


        
        System.out.println("\n=== SOAL 2: Menambahkan (Append) 2 Hari Lagi ===");
        
    
        try (PrintWriter penulisAppend = new PrintWriter(new FileWriter(namaBerkas, true))) {
            penulisAppend.println("Sabtu");
            penulisAppend.println("Minggu");
            System.out.println("Berhasil menambahkan 2 hari baru.\n");
        } catch (IOException e) {
            System.out.println("Gagal menambah data berkas: " + e.getMessage());
        }

       
        tampilkanIsiBerkas(namaBerkas);


        
        System.out.println("\n=== SOAL 3: Menghitung Jumlah Baris ===");
        
        int jumlahBaris = 0;
        try (BufferedReader pembaca = new BufferedReader(new FileReader(namaBerkas))) {
            while (pembaca.readLine() != null) {
                jumlahBaris++;
            }
            System.out.println("Jumlah baris di dalam berkas " + namaBerkas + " adalah: " + jumlahBaris + " baris.");
        } catch (IOException e) {
            System.out.println("Gagal menghitung baris berkas: " + e.getMessage());
        }
    }

    
    public static void tampilkanIsiBerkas(String namaBerkas) {
        System.out.println("--- Isi Berkas " + namaBerkas + " ---");
        try (BufferedReader pembaca = new BufferedReader(new FileReader(namaBerkas))) {
            String baris;
            while ((baris = pembaca.readLine()) != null) {
                System.out.println(baris);
            }
            System.out.println("--------------------------------");
        } catch (IOException e) {
            System.out.println("Gagal membaca berkas: " + e.getMessage());
        }
    }
}