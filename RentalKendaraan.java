package com.mycompany.rentalkendaraan;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

public class RentalKendaraan {

    // Method pencarian menggunakan throws Custom Exception (Modul 9)
    public static void cariKendaraan(String platKeyword, ArrayList<Kendaraan> daftar) throws KendaraanTidakDitemukanException {
        System.out.println("\n--- Hasil Pencarian Berdasarkan Plat Nomor: \"" + platKeyword + "\" ---");
        boolean ditemukan = false;
        for (int i = 0; i < daftar.size(); i++) {
            if (daftar.get(i).getPlatNomor().equalsIgnoreCase(platKeyword)) {
                daftar.get(i).tampilkanInfo();
                ditemukan = true;
            }
        }
        if (!ditemukan) {
            throw new KendaraanTidakDitemukanException("Gagal: Kendaraan dengan plat nomor tersebut tidak terdaftar di sistem.");
        }
    }

    public static void prosesRental(Kendaraan item) {
        item.simulasiRental();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        ArrayList<Kendaraan> daftarKendaraan = new ArrayList<>();
        
        HashMap<String, String> dataPenyewa = new HashMap<>();

        try {
            daftarKendaraan.add(new Mobil("Toyota Avanza", "B1234XYZ", 350000.0, 4, "Otomatis"));
            daftarKendaraan.add(new Motor("Honda Beat", "BE5678AB", 90000.0, 110, "Standar"));
            daftarKendaraan.add(new Truk("Hino Dutro", "B9999CD", 800000.0, 5.5));
        } catch (Exception e) {
            System.out.println("Error saat inisialisasi data: " + e.getMessage());
        }

        System.out.println("==================================================");
        System.out.println("    SELAMAT DATANG DI SISTEM RENTAL KENDARAAN!    ");
        System.out.println("==================================================");

        boolean isRunning = true;
        while (isRunning) {
            try {
                System.out.println("\nMenu Utama:");
                System.out.println("1. Tambah Kendaraan Baru");
                System.out.println("2. Lihat Daftar Kendaraan & Info Status");
                System.out.println("3. Cari Kendaraan (Demo Custom Exception)");
                System.out.println("4. Kelola Data Penyewa (Demo HashMap)");
                System.out.println("5. Keluar");
                System.out.print("Pilih Menu (1-5): ");

                int pilihan = scanner.nextInt();
                scanner.nextLine();

                switch (pilihan) {
                    case 1 -> {
                        System.out.println("\n--- Pilih Jenis Kendaraan ---");
                        System.out.println("1. Mobil");
                        System.out.println("2. Motor");
                        System.out.println("3. Truk");
                        System.out.print("Pilihan jenis (1/2/3): ");
                        int jenis = scanner.nextInt();
                        scanner.nextLine();

                        System.out.print("Masukkan Merk Kendaraan: ");
                        String merk = scanner.nextLine();
                        System.out.print("Masukkan Plat Nomor: ");
                        String plat = scanner.nextLine();
                        System.out.print("Masukkan Tarif per Hari (Rp): ");
                        double tarif = scanner.nextDouble();
                        scanner.nextLine();

                        if (jenis == 1) {
                            System.out.print("Masukkan Jumlah Pintu: ");
                            int pintu = scanner.nextInt();
                            scanner.nextLine();
                            System.out.print("Masukkan Transmisi (Manual/Otomatis): ");
                            String transmisi = scanner.nextLine();
                            daftarKendaraan.add(new Mobil(merk, plat, tarif, pintu, transmisi));
                        } else if (jenis == 2) {
                            System.out.print("Masukkan Kapasitas Mesin (CC): ");
                            int cc = scanner.nextInt();
                            scanner.nextLine();
                            System.out.print("Masukkan Tipe Bagasi: ");
                            String bagasi = scanner.nextLine();
                            daftarKendaraan.add(new Motor(merk, plat, tarif, cc, bagasi));
                        } else if (jenis == 3) {
                            System.out.print("Masukkan Kapasitas Beban (Ton): ");
                            double beban = scanner.nextDouble();
                            scanner.nextLine();
                            daftarKendaraan.add(new Truk(merk, plat, tarif, beban));
                        }
                        System.out.println("Sukses! Data berhasil ditambahkan ke ArrayList. Total: " + daftarKendaraan.size());
                    }
                    case 2 -> {
                        System.out.println("\n--- Daftar Kendaraan Rental ---");
                        if (daftarKendaraan.isEmpty()) {
                            System.out.println("Belum ada kendaraan terdaftar.");
                        } else {
                            for (int i = 0; i < daftarKendaraan.size(); i++) {
                                System.out.print((i + 1) + ". ");
                                daftarKendaraan.get(i).tampilkanInfo();
                                prosesRental(daftarKendaraan.get(i));
                                daftarKendaraan.get(i).hitungPajakKendaraan();

                                if (daftarKendaraan.get(i) instanceof DapatDiasuransikan) {
                                    ((DapatDiasuransikan) daftarKendaraan.get(i)).prosesAsuransi();
                                }
                                if (daftarKendaraan.get(i) instanceof DapatDiservice) {
                                    ((DapatDiservice) daftarKendaraan.get(i)).servisRutin();
                                }
                                System.out.println();
                            }
                            System.out.println("Total Kendaraan (size): " + daftarKendaraan.size());
                        }
                    }
                    case 3 -> {
                        System.out.println("\n--- Fitur Cari Kendaraan ---");
                        System.out.print("Masukkan Plat Nomor yang dicari: ");
                        String kunciPlat = scanner.nextLine();
                        
                        try {
                            cariKendaraan(kunciPlat, daftarKendaraan);
                        } catch (KendaraanTidakDitemukanException e) {
                            System.out.println("Peringatan Exception: " + e.getMessage());
                        } finally {
                            System.out.println("-> Info Sistem: Sesi pencarian kendaraan selesai dieksekusi.");
                        }
                    }
                    case 4 -> {
                        System.out.println("\n--- Kelola Data Penyewa (HashMap) ---");
                        System.out.println("1. Tambah Penyewa Baru");
                        System.out.println("2. Cari Penyewa via ID/NIK");
                        System.out.println("3. Tampilkan Semua Penyewa");
                        System.out.print("Pilih opsi (1/3): ");
                        int menuPenyewa = scanner.nextInt();
                        scanner.nextLine();

                        if (menuPenyewa == 1) {
                            System.out.print("Masukkan ID/NIK (sebagai Key): ");
                            String idKey = scanner.nextLine();
                            System.out.print("Masukkan Nama Lengkap (sebagai Value): ");
                            String namaValue = scanner.nextLine();
                            
                            dataPenyewa.put(idKey, namaValue); // Menggunakan method .put()
                            System.out.println("Sukses! Data penyewa berhasil ditambahkan.");
                        } else if (menuPenyewa == 2) {
                            System.out.print("Masukkan ID/NIK yang dicari: ");
                            String cariId = scanner.nextLine();
                            
                            if (dataPenyewa.containsKey(cariId)) {
                                System.out.println("Ditemukan! Nama Penyewa: " + dataPenyewa.get(cariId)); 
                            } else {
                                System.out.println("Penyewa dengan ID tersebut tidak terdaftar.");
                            }
                        } else if (menuPenyewa == 3) {
                            System.out.println("Total Penyewa Terdaftar: " + dataPenyewa.size());
                            for (String keyId : dataPenyewa.keySet()) { 
                                System.out.println("- ID: " + keyId + " | Nama: " + dataPenyewa.get(keyId));
                            }
                        }
                    }
                    case 5 -> {
                        System.out.println("Terima kasih telah menggunakan sistem!");
                        isRunning = false;
                    }
                    default -> System.out.println("Pilihan menu tidak valid.");
                }

            } catch (InputMismatchException e) {
                System.out.println("\n[TERJADI ERROR] Input tidak valid: Anda wajib memasukkan format angka!");
                scanner.nextLine(); // Membersihkan buffer scanner
            } catch (Exception e) {
                System.out.println("\n[TERJADI ERROR SISTEM] " + e.getMessage());
            } finally {
                System.out.println("-> Blok Finally: Siklus iterasi menu berhasil dilewati dengan aman.\n");
            }
        }
        scanner.close();
    }
}