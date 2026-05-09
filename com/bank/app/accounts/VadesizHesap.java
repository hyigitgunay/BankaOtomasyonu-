package com.bank.app.accounts;

import com.bank.app.cards.KrediKarti;

/**
 * VadesizHesap sinifi - BankaHesabi sinifindan miras alir.
 * Vadesiz (cari) hesap islemlerini gerceklestirir.
 * Para transferi ve kredi karti borc odeme islemlerini destekler.
 */
public class VadesizHesap extends BankaHesabi {

    // Hesap turu bilgisi
    private String hesapTuru;

    /**
     * VadesizHesap constructor'i
     * @param bakiye Hesabin baslangic bakiyesi
     */
    public VadesizHesap(double bakiye) {
        // Ust sinif (BankaHesabi) constructor'ini cagir
        super(bakiye);
        this.hesapTuru = "Vadesiz Hesap";
    }

    // --- Getter ve Setter Metotlari ---

    public String getHesapTuru() {
        return hesapTuru;
    }

    public void setHesapTuru(String hesapTuru) {
        this.hesapTuru = hesapTuru;
    }

    /**
     * Hesaplar arasi para transferi gerceklestirir
     * Gonderen hesabin bakiyesinden miktar dusulur, alici hesabin bakiyesine eklenir
     * @param aliciHesap Para gonderilecek hesap
     * @param gonderenHesap Para gonderilen hesap
     * @param miktar Transfer edilecek miktar
     */
    public void paraTransferi(BankaHesabi aliciHesap, BankaHesabi gonderenHesap, double miktar) {
        // Gonderen hesapta yeterli bakiye var mi kontrol et
        if (gonderenHesap.getBakiye() >= miktar) {
            // Gonderen hesaptan miktari dus
            gonderenHesap.setBakiye(gonderenHesap.getBakiye() - miktar);
            // Alici hesaba miktari ekle
            aliciHesap.setBakiye(aliciHesap.getBakiye() + miktar);
            System.out.println("Para transferi basarili!");
            System.out.println("Gonderen IBAN: " + gonderenHesap.getIban() + " -> Yeni Bakiye: " + String.format("%.2f", gonderenHesap.getBakiye()) + " TL");
            System.out.println("Alici IBAN: " + aliciHesap.getIban() + " -> Yeni Bakiye: " + String.format("%.2f", aliciHesap.getBakiye()) + " TL");
        } else {
            System.out.println("Yetersiz bakiye! Mevcut bakiye: " + String.format("%.2f", gonderenHesap.getBakiye()) + " TL, Transfer miktari: " + String.format("%.2f", miktar) + " TL");
        }
    }

    /**
     * Vadesiz hesaptan kredi karti borcu odeme islemi yapar
     * Hesabin bakiyesinden miktar dusulur, kredi kartinin guncel borcu azaltilir
     * @param kart Borcu odenecek kredi karti
     * @param miktar Odenecek miktar
     */
    public void krediKartiBorcOdeme(KrediKarti kart, double miktar) {
        // Hesapta yeterli bakiye var mi kontrol et
        if (getBakiye() >= miktar) {
            // Odeme miktari guncel borctan fazla olmasin
            if (miktar > kart.getGuncelBorc()) {
                System.out.println("Odeme miktari guncel borctan fazla olamaz! Guncel borc: " + String.format("%.2f", kart.getGuncelBorc()) + " TL");
            } else {
                // Hesaptan miktari dus
                setBakiye(getBakiye() - miktar);
                // Kredi kartinin borcunu azalt
                kart.setGuncelBorc(kart.getGuncelBorc() - miktar);
                System.out.println("Kredi karti borc odemesi basarili!");
                System.out.println("Odenen miktar: " + String.format("%.2f", miktar) + " TL");
                System.out.println("Kalan hesap bakiyesi: " + String.format("%.2f", getBakiye()) + " TL");
                System.out.println("Kalan kart borcu: " + String.format("%.2f", kart.getGuncelBorc()) + " TL");
            }
        } else {
            System.out.println("Yetersiz bakiye! Mevcut bakiye: " + String.format("%.2f", getBakiye()) + " TL");
        }
    }

    /**
     * VadesizHesap bilgilerini String olarak dondurur
     * @return Hesap bilgileri
     */
    @Override
    public String toString() {
        return "=== " + hesapTuru + " ===" +
               "\n" + super.toString();
    }
}
