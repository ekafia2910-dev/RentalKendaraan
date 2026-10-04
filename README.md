#Nur Eka Oktafia - 2517051079


#**Rental Kendaraan**

#Fitur Utama & Konsep OOP yang Diterapkan

Sistem ini mengimplementasikan pilar-pilar utama Pemrograman Berorientasi Objek secara komprehensif:

1. **Inheritance (Pewarisan):**
   * Terdapat *Superclass* induk bernama Kendaraan yang mewariskan atribut dasar kepada *Subclass* anak (Mobil dan Motor) menggunakan keyword extends.
2. **Encapsulation (Enkapsulasi) & Access Modifier:**
   * Seluruh atribut penting (seperti merk, plat nomor, dan tarif) dideklarasikan sebagai private untuk menjaga integritas data.
   * Akses baca/tulis diatur menggunakan metode getter dan setter yang dilengkapi validasi data masukan.
3. **Keyword this dan super:**
   * Penggunaan this untuk mengatasi konflik penamaan variabel lokal dan atribut class.
   * Penggunaan super di dalam konstruktor subclass untuk mewarisi dan menginisialisasi properti dari superclass.
4. **Static Member:**
   * Variabel totalKendaraanTerdaftar berstatus static untuk mencatat jumlah akumulasi objek kendaraan yang berhasil dibuat secara global.
5. **Method Overloading & Overriding:**
   * **Overriding (@Override):** Subclass menimpa method tampilkanInfo() dan simulasiRental() milik induk agar sesuai dengan spesifikasi khusus kendaraan.
   * **Overloading:** Terdapat dua fungsi pencarian cariKendaraan dengan parameter input yang berbeda (berdasarkan Plat Nomor bertipe String dan berdasarkan Batas Tarif bertipe double).
6. **Struktur Kontrol & I/O:**
   * Membaca masukan interaktif konsol menggunakan kelas Scanner.
   * Menggunakan perulangan while dan for, percabangan switch-case serta if-else, dan penyimpanan objek ke dalam struktur data Array.

---

#📂 Struktur Arsitektur Class

```text
RentalKendaraan/
│
├── src/
│   └── main/
│       └── java/
│           └── com/
│               └── mycompany/
│                   └── rentalkendaraan/
│                       ├── Kendaraan.java        # Superclass (Induk)
│                       ├── Mobil.java            # Subclass 1 (Anak)
│                       ├── Motor.java            # Subclass 2 (Anak)
│                       └── RentalKendaraan.java  # Main Class / Entry Point
│
└── pom.xml (atau konfigurasi project build)
