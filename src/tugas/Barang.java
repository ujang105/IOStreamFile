package tugas;

public class Barang {
    private String nama;
    private double harga;
    private int stok;

    public Barang(String nama, double harga, int stok) {
        this.nama = nama;
        this.harga = harga;
        this.stok = stok;
    }

    public String getNama() {
        return nama;
    }

    public double getHarga() {
        return harga;
    }

    public int getStok() {
        return stok;
    }

    
    public String keBaris() {
        return nama + ";" + harga + ";" + stok;
    }

   
    public void info() {
        System.out.println("Nama : " + nama);
        System.out.println("Harga: Rp" + harga);
        System.out.println("Stok : " + stok);
        System.out.println("------------------------");
    }
}