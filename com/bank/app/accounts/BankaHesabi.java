package com.bank.app.accounts;

import java.util.Random;

/**
 * BankaHesabi sinifi - Tum banka hesap turlerinin temel sinifidir.
 * VadesizHesap ve YatirimHesabi siniflari bu siniftan miras alir.
 * Her hesabin bir IBAN numarasi ve bakiyesi vardir.
 */
public class BankaHesabi {

    // Hesabin benzersiz IBAN numarasi (otomatik uretilir)
    private String iban;
    // Hesaptaki mevcut bakiye
    private double bakiye;

    /**
     * BankaHesabi constructor'i
     * IBAN otomatik olarak random number generator ile uretilir
     * @param bakiye Hesabin baslangic bakiyesi
     */
    public BankaHesabi(double bakiye) {
        // IBAN'i random olarak uret (TR + 24 haneli sayi)
        Random random = new Random();
        StringBuilder ibanBuilder = new StringBuilder("TR");
        for (int i = 0; i < 24; i++) {
            ibanBuilder.append(random.nextInt(10));
        }
        this.iban = ibanBuilder.toString();
        this.bakiye = bakiye;
    }

    // --- Getter ve Setter Metotlari ---

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public double getBakiye() {
        return bakiye;
    }

    public void setBakiye(double bakiye) {
        this.bakiye = bakiye;
    }

    /**
     * BankaHesabi bilgilerini String olarak dondurur
     * @return Hesap bilgileri
     */
    @Override
    public String toString() {
        return "IBAN: " + iban + ", Bakiye: " + String.format("%.2f", bakiye) + " TL";
    }
}
