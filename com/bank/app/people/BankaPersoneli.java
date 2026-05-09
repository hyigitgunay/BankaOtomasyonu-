package com.bank.app.people;

import java.util.ArrayList;
import java.util.Random;

/**
 * BankaPersoneli sinifi - Kisi sinifindan miras alir.
 * Bankanin personellerini temsil eder.
 * Her personelin bir personelID'si ve sorumlulugundaki musterilerin listesi vardir.
 */
public class BankaPersoneli extends Kisi {

    // Personelin benzersiz kimlik numarasi (otomatik uretilir)
    private String personelID;
    // Personelin sorumlu oldugu musterilerin listesi
    private ArrayList<Musteri> musteriler;

    /**
     * BankaPersoneli constructor'i
     * personelID otomatik olarak random number generator ile uretilir
     * @param ad Personelin adi
     * @param soyad Personelin soyadi
     * @param email Personelin email adresi
     * @param telefonNumarasi Personelin telefon numarasi
     */
    public BankaPersoneli(String ad, String soyad, String email, int telefonNumarasi) {
        // Ust sinif (Kisi) constructor'ini cagir
        super(ad, soyad, email, telefonNumarasi);
        // PersonelID'yi random olarak uret (P + 6 haneli sayi)
        Random random = new Random();
        this.personelID = "P" + (100000 + random.nextInt(900000));
        // Musteriler listesini baslat
        this.musteriler = new ArrayList<>();
    }

    // --- Getter ve Setter Metotlari ---

    public String getPersonelID() {
        return personelID;
    }

    public void setPersonelID(String personelID) {
        this.personelID = personelID;
    }

    public ArrayList<Musteri> getMusteriler() {
        return musteriler;
    }

    public void setMusteriler(ArrayList<Musteri> musteriler) {
        this.musteriler = musteriler;
    }

    /**
     * Personelin sorumluluguna yeni bir musteri ekler
     * @param musteri Eklenecek musteri nesnesi
     */
    public void musteriEkle(Musteri musteri) {
        musteriler.add(musteri);
        System.out.println("Musteri '" + musteri.getAd() + " " + musteri.getSoyad() + "' personel '" + getAd() + " " + getSoyad() + "' sorumluluguna eklendi.");
    }

    /**
     * BankaPersoneli bilgilerini String olarak dondurur
     * @return Personel bilgileri
     */
    @Override
    public String toString() {
        return "=== Banka Personeli ===" +
               "\nPersonel ID: " + personelID +
               "\n" + super.toString() +
               "\nSorumlu Musteri Sayisi: " + musteriler.size();
    }
}
