package tugas;

public class MainTugas {

    public static void main(String[] args) {

       
        String[] kategori = {
            "Elektronik",
            "Makanan",
            "Peralatan Rumah Tangga"
        };

        System.out.println("===== DAFTAR KATEGORI =====");
        for (String k : kategori) {
            System.out.println("- " + k);
        }

        
        Gudang gudang = new Gudang();

      
        gudang.tambahBarang(new Barang("Laptop", 8500000, 5));
        gudang.tambahBarang(new Barang("Mouse", 150000, 20));
        gudang.tambahBarang(new Barang("Keyboard", 300000, 15));
        gudang.tambahBarang(new Barang("Printer", 1200000, 3));
        gudang.tambahBarang(new Barang("Flashdisk", 100000, 25));

       
        gudang.tampilkanSemua();

    
        gudang.simpanKeBerkas("barang.txt");

      
        Gudang gudangBaru = new Gudang();

       
        gudangBaru.muatDariBerkas("barang.txt");

     
        gudangBaru.tampilkanSemua();

     
        System.out.println("===== TOTAL NILAI PERSEDIAAN =====");
        System.out.println("Rp" + gudangBaru.totalNilai());
    }
}