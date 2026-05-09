package com.bank.app.accounts;

/**
 * YatirimHesabi sinifi - BankaHesabi sinifindan miras alir.
 * Yatirim hesabi islemlerini gerceklestirir.
 * Para ekleme ve para cekme islemlerini destekler.
 */
public class YatirimHesabi extends BankaHesabi {

    // Hesap turu bilgisi
    private String hesapTuru;

    /**
     * YatirimHesabi constructor'i
     * @param bakiye Hesabin baslangic bakiyesi
     */
    public YatirimHesabi(double bakiye) {
        // Ust sinif (BankaHesabi) constructor'ini cagir
        super(bakiye);
        this.hesapTuru = "Yatirim Hesabi";
    }

    // --- Getter ve Setter Metotlari ---

    public String getHesapTuru() {
        return hesapTuru;
    }

    public void setHesapTuru(String hesapTuru) {
        this.hesapTuru = hesapTuru;
    }

    /**
     * Yatirim hesabina para ekler
     * @param miktar Eklenecek miktar
     */
    public void paraEkle(double miktar) {
        if (miktar > 0) {
            // Bakiyeye miktari ekle
            setBakiye(getBakiye() + miktar);
            System.out.println("Yatirim hesabina " + String.format("%.2f", miktar) + " TL eklendi.");
            System.out.println("Yeni bakiye: " + String.format("%.2f", getBakiye()) + " TL");
        } else {
            System.out.println("Eklenecek miktar 0'dan buyuk olmalidir!");
        }
    }

    /**
     * Yatirim hesabindan para ceker
     * @param miktar Cekilecek miktar
     */
    public void paraCek(double miktar) {
        if (miktar > 0) {
            if (getBakiye() >= miktar) {
                // Bakiyeden miktari dus
                setBakiye(getBakiye() - miktar);
                System.out.println("Yatirim hesabindan " + String.format("%.2f", miktar) + " TL cekildi.");
                System.out.println("Yeni bakiye: " + String.format("%.2f", getBakiye()) + " TL");
            } else {
                System.out.println("Yetersiz bakiye! Mevcut bakiye: " + String.format("%.2f", getBakiye()) + " TL");
            }
        } else {
            System.out.println("Cekilecek miktar 0'dan buyuk olmalidir!");
        }
    }

    /**
     * YatirimHesabi bilgilerini String olarak dondurur
     * @return Hesap bilgileri
     */
    @Override
    public String toString() {
        return "=== " + hesapTuru + " ===" +
               "\n" + super.toString();
    }
}
