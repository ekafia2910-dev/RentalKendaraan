package com.mycompany.rentalkendaraan;

public class KendaraanTidakDitemukanException extends Exception {
    public KendaraanTidakDitemukanException(String message) {
        super(message);
    }
}