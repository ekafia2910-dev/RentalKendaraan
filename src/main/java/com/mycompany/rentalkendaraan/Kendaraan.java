package com.mycompany.rentalkendaraan;

public class Kendaraan {
    private String merk;
    private String platNomor;
    private double tarifPerHari;
    
    public static int totalKendaraanTerdaftar = 0;
    public Kendaraan(String merk, String platNomor, double tarifPerHari) {
        this.merk = merk;
        this.platNomor = platNomor;
        setTarifPerHari(tarifPerHari); // Menggunakan setter untuk validasi
        totalKendaraanTerdaftar++;
    }

    public String getMerk() {
        return this.merk;
    }

    public void setMerk(String merk) {
        this.merk = merk;
    }

    public String getPlatNomor() {
        return this.platNomor;
    }

    public void setPlatNomor(String platNomor) {
        this.platNomor = platNomor;
    }

    public double getTarifPerHari() {
        return this.tarifPerHari;
    }

    public void setTarifPerHari(double tarifPerHari) {
        if (tarifPerHari > 0) {
            this.tarifPerHari = tarifPerHari;
        } else {
            System.out.println("Peringatan: Tarif harus lebih dari 0! Diset default ke 50000.");
            this.tarifPerHari = 50000.0;
        }
    }

    public void tampilkanInfo() {
        System.out.printf("Merk: %-15s | Plat: %-10s | Tarif/Hari: Rp %.2f\n", 
                this.merk, this.platNomor, this.tarifPerHari);
    }

    public void simulasiRental() {
        System.out.println("-> Simulasi: Kendaraan umum siap disewa.");
    }
}
