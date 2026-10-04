package com.mycompany.rentalkendaraan;

public class Mobil extends Kendaraan {
    private int jumlahPintu;
    private String jenisTransmisi; 

  
    public Mobil(String merk, String platNomor, double tarifPerHari, int jumlahPintu, String jenisTransmisi) {
        super(merk, platNomor, tarifPerHari);
        this.jumlahPintu = jumlahPintu;
        this.jenisTransmisi = jenisTransmisi;
    }

    public int getJumlahPintu() {
        return this.jumlahPintu;
    }

    public void setJumlahPintu(int jumlahPintu) {
        this.jumlahPintu = jumlahPintu;
    }

    public String getJenisTransmisi() {
        return this.jenisTransmisi;
    }

    public void setJenisTransmisi(String jenisTransmisi) {
        this.jenisTransmisi = jenisTransmisi;
    }

    
    @Override
    public void tampilkanInfo() {
        System.out.printf("[MOBIL] Merk: %-12s | Plat: %-8s | Tarif: Rp %.0f | Pintu: %d | Transmisi: %s\n",
                getMerk(), getPlatNomor(), getTarifPerHari(), this.jumlahPintu, this.jenisTransmisi);
    }

    @Override
    public void simulasiRental() {
        System.out.println("-> Syarat Rental Mobil: Wajib melampirkan SIM A dan KTP penjamin.");
    }
}