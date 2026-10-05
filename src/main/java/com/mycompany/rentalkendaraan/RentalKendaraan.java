package com.mycompany.rentalkendaraan;

import java.util.Scanner;

public class RentalKendaraan {


    public static void cariKendaraan(String platKeyword, Kendaraan[] daftar, int total) {
        System.out.println("\n--- Hasil Pencarian Berdasarkan Plat Nomor: \"" + platKeyword + "\" ---");
        boolean ditemukan = false;
        for (int i = 0; i < total; i++) {
            if (daftar[i].getPlatNomor().equalsIgnoreCase(platKeyword)) {
                daftar[i].tampilkanInfo();
                ditemukan = true;
            }
        }
        if (!ditemukan) System.out.println("Kendaraan tidak ditemukan.");
    }

    public static void cariKendaraan(double maxTarif, Kendaraan[] daftar, int total) {
        System.out.println("\n--- Hasil Pencarian Kendaraan dengan Tarif <= Rp " + maxTarif + " ---");
        boolean ditemukan = false;
        for (int i = 0; i < total; i++) {
            if (daftar[i].getTarifPerHari() <= maxTarif) {
                daftar[i].tampilkanInfo();
                ditemukan = true;
            }
        }
        if (!ditemukan) System.out.println("Tidak ada kendaraan yang sesuai.");
    }

    public static void prosesRental(Kendaraan item) {
        item.simulasiRental();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Kendaraan[] daftarKendaraan = new Kendaraan[10];
        int jumlahKendaraan = 0;
        boolean isRunning = true;

        daftarKendaraan[jumlahKendaraan++] = new Mobil("Toyota Avanza", "B1234XYZ", 350000.0, 4, "Otomatis");
        daftarKendaraan[jumlahKendaraan++] = new Motor("Honda Beat", "BE5678AB", 90000.0, 110, "Standar");
        daftarKendaraan[jumlahKendaraan++] = new Truk("Hino Dutro", "B9999CD", 800000.0, 5.5);
        daftarKendaraan[jumlahKendaraan++] = new Mobil("Honda Civic", "D9999AA", 750000.0, 4, "Manual");

        System.out.println("==================================================");
        System.out.println("    SELAMAT DATANG DI SISTEM RENTAL KENDARAAN!    ");
        System.out.println("==================================================");

        while (isRunning) {
            System.out.println("\nMenu Utama:");
            System.out.println("1. Tambah Kendaraan Baru");
            System.out.println("2. Lihat Daftar Kendaraan & Simulasi Rental");
            System.out.println("3. Cari Kendaraan (Overloading)");
            System.out.println("4. Keluar");
            System.out.print("Pilih Menu (1-4): ");

            int pilihan = scanner.nextInt();
            scanner.nextLine();

            switch (pilihan) {
                case 1 -> {
                    if (jumlahKendaraan < daftarKendaraan.length) {
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
                            daftarKendaraan[jumlahKendaraan] = new Mobil(merk, plat, tarif, pintu, transmisi);
                            jumlahKendaraan++;
                        } else if (jenis == 2) {
                            System.out.print("Masukkan Kapasitas Mesin (CC): ");
                            int cc = scanner.nextInt();
                            scanner.nextLine();
                            System.out.print("Masukkan Tipe Bagasi: ");
                            String bagasi = scanner.nextLine();
                            daftarKendaraan[jumlahKendaraan] = new Motor(merk, plat, tarif, cc, bagasi);
                            jumlahKendaraan++;
                        } else if (jenis == 3) {
                            System.out.print("Masukkan Kapasitas Beban (Ton): ");
                            double beban = scanner.nextDouble();
                            scanner.nextLine();
                            daftarKendaraan[jumlahKendaraan] = new Truk(merk, plat, tarif, beban);
                            jumlahKendaraan++;
                        }
                        System.out.println("Sukses! Data berhasil ditambahkan.");
                    } else {
                        System.out.println("Maaf, garasi sudah penuh!");
                    }
                }
                case 2 -> {
                    System.out.println("\n--- Daftar Kendaraan Rental ---");
                    if (jumlahKendaraan == 0) {
                        System.out.println("Belum ada kendaraan terdaftar.");
                    } else {
                        for (int i = 0; i < jumlahKendaraan; i++) {
                            System.out.print((i + 1) + ". ");
                            daftarKendaraan[i].tampilkanInfo(); 
                            prosesRental(daftarKendaraan[i]);
                            System.out.println();
                        }
                        System.out.println("Total Kendaraan: " + Kendaraan.totalKendaraanTerdaftar);
                    }
                }
                case 3 -> {
                    System.out.println("\n--- Menu Pencarian ---");
                    System.out.println("1. Cari berdasarkan Plat Nomor");
                    System.out.println("2. Cari berdasarkan Batas Maksimal Tarif");
                    System.out.print("Pilih mode (1/2): ");
                    int modeCari = scanner.nextInt();
                    scanner.nextLine();

                    if (modeCari == 1) {
                        System.out.print("Masukkan Plat Nomor: ");
                        String kunciPlat = scanner.nextLine();
                        cariKendaraan(kunciPlat, daftarKendaraan, jumlahKendaraan);
                    } else if (modeCari == 2) {
                        System.out.print("Masukkan Batas Tarif Maksimal (Rp): ");
                        double kunciTarif = scanner.nextDouble();
                        scanner.nextLine();
                        cariKendaraan(kunciTarif, daftarKendaraan, jumlahKendaraan);
                    }
                }
                case 4 -> {
                    System.out.println("Terima kasih!");
                    isRunning = false;
                }
                default -> System.out.println("Pilihan tidak valid.");
            }
        }
        scanner.close();
    }
}