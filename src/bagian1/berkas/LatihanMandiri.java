package bagian1.berkas;

import java.io.File;
import java.io.IOException;

public class LatihanMandiri {
    public static void main(String[] args) {
        
        
        System.out.println("--- SOAL 1 ---");
        File laporan = new File("laporan.txt");
        
        if (laporan.exists()) {
            System.out.println("Berkas laporan.txt ditemukan.");
            System.out.println("Ukuran berkas: " + laporan.length() + " byte");
        } else {
            System.out.println("Berkas laporan.txt tidak ditemukan.");
        }
        System.out.println();


        System.out.println("--- SOAL 2 ---");
        File folderArsip = new File("arsip");
        
        if (folderArsip.mkdir()) {
            System.out.println("Pesan: Folder 'arsip' berhasil dibuat.");
        } else {
            System.out.println("Pesan: Folder 'arsip' gagal dibuat (mungkin folder sudah ada).");
        }
        System.out.println();


        
        System.out.println("--- SOAL 3 ---");
        File berkasSementara = new File("sementara.txt");
        
        try {
           
            if (berkasSementara.createNewFile()) {
                System.out.println("Berkas sementara.txt berhasil dibuat.");
            }
            
            
            System.out.println("Apakah berkas ada (Sebelum dihapus)? : " + berkasSementara.exists());
            
           
            if (berkasSementara.delete()) {
                System.out.println("Berkas sementara.txt berhasil dihapus.");
            } else {
                System.out.println("Gagal menghapus berkas.");
            }
            
           
            System.out.println("Apakah berkas ada (Sesudah dihapus)? : " + berkasSementara.exists());
            
        } catch (IOException e) {
            System.out.println("Terjadi kesalahan I/O: " + e.getMessage());
        }
    }
}