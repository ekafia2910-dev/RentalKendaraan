package com.mycompany.rentalkendaraan;

public class Garasi {
    private String namaGarasi;
    private int kapasitasParkir;

    public Garasi(String namaGarasi, int kapasitasParkir) {
        this.namaGarasi = namaGarasi;
        this.kapasitasParkir = kapasitasParkir;
    }

    public void infoGarasi() {
        System.out.println("-> [Komposisi Garasi] " + namaGarasi + " diaktifkan. Kapasitas Parkir: " + kapasitasParkir + " unit.");
    }
}