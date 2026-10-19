package com.mycompany.rentalkendaraan;

public class Motor extends Kendaraan implements DapatDiservice {
    private int kapasitasMesinCC;
    private String tipeBagasi;

    public Motor(String merk, String platNomor, double tarifPerHari, int kapasitasMesinCC, String tipeBagasi) {
        super(merk, platNomor, tarifPerHari);
        this.kapasitasMesinCC = kapasitasMesinCC;
        this.tipeBagasi = tipeBagasi;
    }

    @Override
    public void tampilkanInfo() {
        System.out.printf("[MOTOR] Merk: %-12s | Plat: %-8s | Tarif: Rp %.0f | CC: %d CC | Bagasi: %s\n",
                getMerk(), getPlatNomor(), getTarifPerHari(), this.kapasitasMesinCC, this.tipeBagasi);
    }

    @Override
    public void simulasiRental() {
        System.out.println("-> Syarat Rental Motor: Wajib melampirkan SIM C dan helm disediakan 2 buah.");
    }
    
    @Override
    public void hitungPajakKendaraan() {
        System.out.println("-> Pajak Kendaraan: Rp 250.000 / tahun (Kategori Motor).");
    }

    @Override
    public void servisRutin() {
        System.out.println("-> Status Servis: Wajib ganti oli setiap 2.000 km.");
    }

}