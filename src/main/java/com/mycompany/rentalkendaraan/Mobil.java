package com.mycompany.rentalkendaraan;

public class Mobil extends Kendaraan implements DapatDiasuransikan, DapatDiservice {
    private int jumlahPintu;
    private String jenisTransmisi;

    public Mobil(String merk, String platNomor, double tarifPerHari, int jumlahPintu, String jenisTransmisi) {
        super(merk, platNomor, tarifPerHari);
        this.jumlahPintu = jumlahPintu;
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
    
    @Override
    public void hitungPajakKendaraan() {
        System.out.println("-> Pajak Kendaraan: Rp 2.500.000 / tahun (Kategori Mobil).");
    }

    @Override
    public void prosesAsuransi() {
        System.out.println("-> Status Asuransi: Asuransi All-Risk aktif untuk mobil ini.");
    }


    @Override
    public void servisRutin() {
        System.out.println("-> Status Servis: Wajib ganti oli dan cek mesin setiap 10.000 km.");
    }

}