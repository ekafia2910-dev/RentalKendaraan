package com.mycompany.rentalkendaraan;

public class Motor extends Kendaraan {
    private int kapasitasMesinCC;
    private String tipeBagasi; 

    public Motor(String merk, String platNomor, double tarifPerHari, int kapasitasMesinCC, String tipeBagasi) {
        super(merk, platNomor, tarifPerHari);
        this.kapasitasMesinCC = kapasitasMesinCC;
        this.tipeBagasi = tipeBagasi;
    }

    public int getKapasitasMesinCC() {
        return this.kapasitasMesinCC;
    }

    public void setKapasitasMesinCC(int kapasitasMesinCC) {
        this.kapasitasMesinCC = kapasitasMesinCC;
    }

    public String getTipeBagasi() {
        return this.tipeBagasi;
    }

    public void setTipeBagasi(String tipeBagasi) {
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
}