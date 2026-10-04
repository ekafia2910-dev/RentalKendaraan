package com.mycompany.rentalkendaraan;

import java.util.Scanner;

public class RentalKendaraan {


    public static void cariKendaraan(String platKeyword, Kendaraan[] daftar, int total) {
        System.out.println("\n--- Hasil Pencarian Berdasarkan Plat Nomor: \"" + platKeyword + "\" ---");
        boolean ditemukan = false;
        for (int i = 0; i < total; i++) {
            if (daftar[i].getPlatNomor().equalsIgnoreCase(platKeyword)) {
                System.out.print("Ditemukan pada indeks " + (i + 1) + " -> ");
                daftar[i].tampilkanInfo();
                ditemukan = true;
            }
        }
        if (!ditemukan) {
            System.out.println("Kendaraan dengan plat nomor tersebut tidak ditemukan.");
        }
    }


    public static void cariKendaraan(double maxTarif, Kendaraan[] daftar, int total) {
        System.out.println("\n--- Hasil Pencarian Kendaraan dengan Tarif <= Rp " + maxTarif + " ---");
        boolean ditemukan = false;
        for (int i = 0; i < total; i++) {
            if (daftar[i].getTarifPerHari() <= maxTarif) {
                System.out.print("Ditemukan pada indeks " + (i + 1) + " -> ");
                daftar[i].tampilkanInfo();
                ditemukan = true;
            }
        }
        if (!ditemukan) {
            System.out.println("Tidak ada kendaraan yang sesuai dengan batas tarif tersebut.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Kendaraan[] daftarKendaraan = new Kendaraan[10];
        int jumlahKendaraan = 0;
        boolean isRunning = true;

        // Pre-load data dummy (3 data awal)
        daftarKendaraan[jumlahKendaraan++] = new Mobil("Toyota Avanza", "B1234XYZ", 350000.0, 4, "Otomatis");
        daftarKendaraan[jumlahKendaraan++] = new Motor("Honda Beat", "BE5678AB", 90000.0, 110, "Standar");
        daftarKendaraan[jumlahKendaraan++] = new Mobil("Honda Civic", "D9999AA", 750000.0, 4, "Manual");

        System.out.println("==================================================");
        System.out.println("    SELAMAT DATANG DI SISTEM RENTAL KENDARAAN!    ");
        System.out.println("==================================================");

        while (isRunning) {
            System.out.println("\nMenu Utama:");
            System.out.println("1. Tambah Kendaraan Baru");
            System.out.println("2. Lihat Daftar Kendaraan");
            System.out.println("3. Cari Kendaraan (Fitur Overloading)");
            System.out.println("4. Keluar");
            System.out.print("Pilih Menu (1-4): ");

            int pilihan = scanner.nextInt();
            scanner.nextLine(); // Membersihkan sisa buffer enter

            switch (pilihan) {
                case 1 -> {
                    if (jumlahKendaraan < daftarKendaraan.length) {
                        System.out.println("\n--- Pilih Jenis Kendaraan ---");
                        System.out.println("1. Mobil");
                        System.out.println("2. Motor");
                        System.out.print("Pilihan jenis (1/2): ");
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
                            System.out.print("Masukkan Jenis Transmisi (Manual/Otomatis): ");
                            String transmisi = scanner.nextLine();

                            daftarKendaraan[jumlahKendaraan] = new Mobil(merk, plat, tarif, pintu, transmisi);
                            jumlahKendaraan++;
                            System.out.println("Sukses! Data Mobil berhasil ditambahkan.");
                        } else if (jenis == 2) {
                            System.out.print("Masukkan Kapasitas Mesin (CC): ");
                            int cc = scanner.nextInt();
                            scanner.nextLine();
                            System.out.print("Masukkan Tipe Bagasi: ");
                            String bagasi = scanner.nextLine();

                            daftarKendaraan[jumlahKendaraan] = new Motor(merk, plat, tarif, cc, bagasi);
                            jumlahKendaraan++;
                            System.out.println("Sukses! Data Motor berhasil ditambahkan.");
                        } else {
                            System.out.println("Pilihan jenis kendaraan tidak valid!");
                        }
                    } else {
                        System.out.println("Maaf, kapasitas tempat parkir/garasi sudah penuh!");
                    }
                }
                case 2 -> {
                    System.out.println("\n--- Daftar Kendaraan Rental ---");
                    if (jumlahKendaraan == 0) {
                        System.out.println("Belum ada kendaraan yang terdaftar.");
                    } else {
                        for (int i = 0; i < jumlahKendaraan; i++) {
                            System.out.print((i + 1) + ". ");
                            daftarKendaraan[i].tampilkanInfo(); // Memanggil Method Overriding
                            daftarKendaraan[i].simulasiRental();
                            System.out.println();
                        }
                        System.out.println("Total Item Kendaraan di Garasi: " + Kendaraan.totalKendaraanTerdaftar);
                    }
                    System.out.print("\nTekan Enter untuk melanjutkan...");
                    scanner.nextLine();
                }
                case 3 -> {
                    System.out.println("\n--- Menu Pencarian Kendaraan (Overloading) ---");
                    System.out.println("1. Cari berdasarkan Plat Nomor");
                    System.out.println("2. Cari berdasarkan Batas Maksimal Tarif per Hari");
                    System.out.print("Pilih mode (1/2): ");
                    int modeCari = scanner.nextInt();
                    scanner.nextLine();

                    if (modeCari == 1) {
                        System.out.print("Masukkan Plat Nomor yang dicari: ");
                        String kunciPlat = scanner.nextLine();
                        cariKendaraan(kunciPlat, daftarKendaraan, jumlahKendaraan); // Memanggil overloading String
                    } else if (modeCari == 2) {
                        System.out.print("Masukkan Batas Tarif Maksimal (Rp): ");
                        double kunciTarif = scanner.nextDouble();
                        scanner.nextLine();
                        cariKendaraan(kunciTarif, daftarKendaraan, jumlahKendaraan); // Memanggil overloading double
                    } else {
                        System.out.println("Pilihan mode pencarian tidak valid.");
                    }

                    System.out.print("\nTekan Enter untuk melanjutkan...");
                    scanner.nextLine();
                }
                case 4 -> {
                    System.out.println("Terima kasih telah menggunakan Sistem Rental Kendaraan!");
                    isRunning = false;
                }
                default -> System.out.println("Pilihan tidak valid. Silakan masukkan angka 1-4.");
            }
        }
        scanner.close();
    }
}