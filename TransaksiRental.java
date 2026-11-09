package com.mycompany.rentalkendaraan;

public class TransaksiRental {
    public static void prosesRental(Pelanggan pelanggan, Kendaraan kendaraan) {
        System.out.println("\n===== STRUK TRANSAKSI RENTAL (ASOSIASI) =====");
        System.out.println("Penyewa  : " + pelanggan.getNama() + " (NIK: " + pelanggan.getNik() + ")");
        System.out.println("Kendaraan: " + kendaraan.getMerk() + " | Plat: " + kendaraan.getPlatNomor());
        System.out.println("Tarif/Hr : Rp " + kendaraan.getTarifPerHari());
        System.out.println("Status   : Berhasil dicatat dalam sistem.");
        
        kendaraan.simulasiRental();
        
        if (kendaraan instanceof DapatDiasuransikan) {
            ((DapatDiasuransikan) kendaraan).prosesAsuransi();
        }
        System.out.println("=============================================");
    }
}