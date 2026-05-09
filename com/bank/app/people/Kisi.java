package com.bank.app.people;

/**
 * Kisi sinifi - Tum kisi turlerinin (BankaPersoneli, Musteri) temel sinifidir.
 * Ad, soyad, email ve telefon numarasi gibi ortak ozellikleri icerir.
 */
public class Kisi {

    // Kisinin adi
    private String ad;
    // Kisinin soyadi
    private String soyad;
    // Kisinin email adresi
    private String email;
    // Kisinin telefon numarasi
    private int telefonNumarasi;

    /**
     * Kisi sinifi constructor'i
     * @param ad Kisinin adi
     * @param soyad Kisinin soyadi
     * @param email Kisinin email adresi
     * @param telefonNumarasi Kisinin telefon numarasi
     */
    public Kisi(String ad, String soyad, String email, int telefonNumarasi) {
        this.ad = ad;
        this.soyad = soyad;
        this.email = email;
        this.telefonNumarasi = telefonNumarasi;
    }

    // --- Getter ve Setter Metotlari ---

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getSoyad() {
        return soyad;
    }

    public void setSoyad(String soyad) {
        this.soyad = soyad;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getTelefonNumarasi() {
        return telefonNumarasi;
    }

    public void setTelefonNumarasi(int telefonNumarasi) {
        this.telefonNumarasi = telefonNumarasi;
    }

    /**
     * Kisi bilgilerini String olarak dondurur
     * @return Kisi bilgileri
     */
    @Override
    public String toString() {
        return "Ad: " + ad + ", Soyad: " + soyad + ", Email: " + email + ", Telefon: " + telefonNumarasi;
    }
}
