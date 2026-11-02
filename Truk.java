package com.mycompany.rentalkendaraan;

public class Truk extends Kendaraan implements DapatDiasuransikan, DapatDiservice {
    private double kapasitasBebanTon;

    public Truk(String merk, String platNomor, double tarifPerHari, double kapasitasBebanTon) throws Exception{
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
    
    @Override
    public void hitungPajakKendaraan() {
        System.out.println("-> Pajak Kendaraan: Rp 4.500.000 / tahun (Kategori Truk Komersial).");
    }

    @Override
    public void prosesAsuransi() {
        System.out.println("-> Status Asuransi: Asuransi TLO (Total Loss Only) & Muatan Logistik aktif.");
    }

    @Override
    public void servisRutin() {
        System.out.println("-> Status Servis: Wajib cek hidrolik dan rem angin setiap 20.000 km.");
    }
}