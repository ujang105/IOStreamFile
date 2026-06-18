package bagian3.kontak;

public class MainKontak {
    public static void main(String[] args) {
      
        BukuKontak buku = new BukuKontak("kontak.txt");
        buku.tambahKontak(new Kontak("Andi", "0811111", "andi@email.com"));
        buku.tambahKontak(new Kontak("Budi", "0822222", "budi@email.com"));
        buku.tambahKontak(new Kontak("Citra", "0833333", "citra@email.com"));
        
        buku.tampilkanSemua();
        buku.simpanKeBerkas();
        
        System.out.println();
        
       
        BukuKontak bukuLain = new BukuKontak("kontak.txt");
        bukuLain.muatDariBerkas();
        bukuLain.tampilkanSemua();
        
        System.out.println();
        
      
        bukuLain.cariKontak("Budi");  // Skenario: Kontak ada
        bukuLain.cariKontak("Dewi");  // Skenario: Kontak tidak ada
        
        System.out.println();
        
        
        bukuLain.hapusKontak("Andi"); 
        
        System.out.println();
        
        
        System.out.println("=== Kondisi Akhir Daftar Kontak ===");
        bukuLain.tampilkanSemua();
        System.out.println("Jumlah kontak sekarang: " + bukuLain.jumlahKontak());
    }
}