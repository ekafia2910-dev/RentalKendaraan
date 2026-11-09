package com.mycompany.rentalkendaraan;

import java.util.ArrayList;
import java.util.HashMap;

public class ManajemenRental {
    private String namaAgensi;
    private Garasi garasiUtama; 
    private ArrayList<Kendaraan> daftarKendaraan; 
    private HashMap<String, Pelanggan> dataPelanggan;

    public ManajemenRental(String namaAgensi) {
        this.namaAgensi = namaAgensi;
        this.garasiUtama = new Garasi("Garasi Pusat Kendaraan", 25);
        this.daftarKendaraan = new ArrayList<>();
        this.dataPelanggan = new HashMap<>();
    }

    public void bukaAgensi() {
        System.out.println("\n*** Menginisialisasi Sistem " + this.namaAgensi + " ***");
        garasiUtama.infoGarasi();
    }

    public void tambahKendaraan(Kendaraan k) {
        daftarKendaraan.add(k);
        System.out.println("Sukses! Kendaraan ditambahkan ke sistem. (Total Unit: " + daftarKendaraan.size() + ")");
    }

    public void tambahPelanggan(Pelanggan p) {
        dataPelanggan.put(p.getNik(), p);
        System.out.println("Berhasil menambahkan data pelanggan!");
    }

    public void lihatSemuaKendaraan() {
        if (daftarKendaraan.isEmpty()) {
            System.out.println("Belum ada kendaraan yang tersimpan.");
            return;
        }
        for (int i = 0; i < daftarKendaraan.size(); i++) {
            System.out.print((i + 1) + ". ");
            daftarKendaraan.get(i).tampilkanInfo();
            daftarKendaraan.get(i).hitungPajakKendaraan();

            if (daftarKendaraan.get(i) instanceof DapatDiasuransikan) {
                ((DapatDiasuransikan) daftarKendaraan.get(i)).prosesAsuransi();
            }
            if (daftarKendaraan.get(i) instanceof DapatDiservice) {
                ((DapatDiservice) daftarKendaraan.get(i)).servisRutin();
            }
            System.out.println();
        }
    }

    public void cariKendaraan(String plat) throws KendaraanTidakDitemukanException {
        System.out.println("Mencari Kendaraan dengan Plat: " + plat);
        boolean ditemukan = false;
        for (Kendaraan k : daftarKendaraan) {
            if (k.getPlatNomor().equalsIgnoreCase(plat)) {
                k.tampilkanInfo();
                ditemukan = true;
            }
        }
        if (!ditemukan) {
            throw new KendaraanTidakDitemukanException("Gagal: Kendaraan dengan plat nomor '" + plat + "' tidak terdaftar.");
        }
    }

    public void cariPelanggan(String nik) {
        if (dataPelanggan.containsKey(nik)) {
            System.out.println("Ditemukan! Nama Pelanggan: " + dataPelanggan.get(nik).getNama());
        } else {
            System.out.println("Pelanggan dengan NIK tersebut tidak terdaftar.");
        }
    }

    public void lihatSemuaPelanggan() {
        System.out.println("Total Pelanggan Terdaftar: " + dataPelanggan.size());
        for (Pelanggan p : dataPelanggan.values()) {
            System.out.println("- NIK: " + p.getNik() + " | Nama: " + p.getNama());
        }
    }

    public Pelanggan getPelanggan(String nik) {
        return dataPelanggan.get(nik);
    }

    public Kendaraan getKendaraanInt(int index) {
        return daftarKendaraan.get(index);
    }

    public int getJumlahKendaraan() {
        return daftarKendaraan.size();
    }
}