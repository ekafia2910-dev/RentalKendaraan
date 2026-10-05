package com.mycompany.rentalkendaraan;

public class Truk extends Kendaraan {
    private double kapasitasBebanTon;

    public Truk(String merk, String platNomor, double tarifPerHari, double kapasitasBebanTon) {
        super(merk, platNomor, tarifPerHari);
        this.kapasitasBebanTon = kapasitasBebanTon;
    }

    @Override
    public void tampilkanInfo() {
        System.out.printf("[TRUK]  Merk: %-12s | Plat: %-8s | Tarif: Rp %.0f | Beban: %.1f Ton\n",
                getMerk(), getPlatNomor(), getTarifPerHari(), this.kapasitasBebanTon);
    }

    @Override
    public void simulasiRental() {
        System.out.println("-> Syarat Rental Truk: Wajib melampirkan SIM B1/B2 Umum dan surat jalan logistik.");
    }
}